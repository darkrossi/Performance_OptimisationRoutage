/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simufiles;

import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;

public class Simulator {

    private FileAtt m_file1;
    private FileAtt m_file2;

    private Service m_serv1;
    private Service m_serv2;

    private Poisson m_poisson;

    private double m_lambda;

    private TreeMap<Double, Requete> m_events;

    private double m_current_time;

    private int m_current_num;

    private int m_n_periode;
    
    private int m_nb_paquets_total;
    private int m_nb_paquets_max;

    public Simulator(double mu1, double mu2, double lambda, int n_periode, int nb_paquets_max) {
        this.m_lambda = lambda;

        this.m_n_periode = n_periode;

        this.m_file1 = new FileAtt();
        this.m_file2 = new FileAtt();

        this.m_serv1 = new Service(mu1);
        /**
         * On fait attendre un peu le Thread pour pas que les random des
         * exponentiels des deux Serveurs soient les mêmes
         */
        Random rand = new Random((new Date()).getTime());
        long tem = (long) (rand.nextDouble() * 100);
        try {
            Thread.sleep(tem);
        } catch (InterruptedException e) {
        }
        this.m_serv2 = new Service(mu2);

        this.m_poisson = new Poisson(lambda);

        this.m_events = new TreeMap<>();
        this.m_current_time = 0;
        m_events.put(this.m_current_time, new Requete(Main.ARRIVAL, 0));

        this.m_current_num = 0;

        this.m_nb_paquets_total = 0;
        this.m_nb_paquets_max = nb_paquets_max;
    }

    public LinkedList<Stat> run() {
        LinkedList<Stat> list_stats = new LinkedList<>();
        while (m_nb_paquets_total < m_nb_paquets_max) {
            double time = m_events.firstKey();
            m_current_time = time;
            Requete current_requete = m_events.remove(time);
            int type_current_requete = current_requete.getM_type();
            if (type_current_requete == Main.ARRIVAL) {

                m_nb_paquets_total++;
                
                /**
                 * Si une personne arrive alors on la rajoute dans une des files
                 * d'attente suivant m_current_num en calculant un temps de
                 * sorti
                 */
                int num_file;
                FileAtt current_file;
                Service current_service;
                if (m_current_num < m_n_periode) {
                    num_file = 1;
                    current_file = m_file1;
                    current_service = m_serv1;
                } else {
                    num_file = 2;
                    current_file = m_file2;
                    current_service = m_serv2;
                }
                current_file.ajoutClient();
                m_current_num = (m_current_num + 1) % (m_n_periode + 1);

                /**
                 * Si le service est dispo alors on lui ajoute un client
                 */
                if (current_service.testAvailable(m_current_time)) {
                    current_file.departClient();
                    double expon_time = current_service.getExp();
                    current_service.arrivee(m_current_time + expon_time);
                    m_events.put(m_current_time + expon_time, new Requete(Main.DEPART, num_file));
                }

                /**
                 * Puis on fait arriver un autre client
                 */
                double poisson_time = this.m_poisson.getPoisson();
                m_events.put(m_current_time + poisson_time, new Requete(Main.ARRIVAL, 0));

            } else if (type_current_requete == Main.DEPART) {
                int num_file = current_requete.getM_num_file();
                Service current_service;
                FileAtt current_file;
                if (num_file == 1) {
                    current_service = m_serv1;
                    current_file = m_file1;
                } else {
                    current_service = m_serv2;
                    current_file = m_file2;
                }

                int nb_personne_file = current_file.getNbPersonnes();
                if (nb_personne_file != 0) {
                    current_file.departClient();
                    double expon_time = current_service.getExp();
                    current_service.arrivee(m_current_time + expon_time);
                    m_events.put(m_current_time + expon_time, new Requete(Main.DEPART, num_file));
                }
            }
            
            int nb_client_file1 = m_file1.getNbPersonnes();
            int nb_client_file2 = m_file2.getNbPersonnes();            
            list_stats.add(new Stat(m_current_time, nb_client_file1, nb_client_file2));
        }
        return list_stats;
    }

}

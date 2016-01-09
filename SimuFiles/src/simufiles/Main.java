/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simufiles;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 *
 * @author Mickaël
 */
public class Main {

    public static final int ARRIVAL = 0;
    public static final int DEPART = 1;

    public static void main(String[] args) {
        /**
         * mu1, mu2, lambda, nb_periode, nb_paquets_max
         */
        TreeMap<Double, Integer> list_finale = new TreeMap<>();
        for (int i = 1; i < 10; i++) {
            Simulator simulator = new Simulator(2, 1, 1, i, 100000);
            LinkedList<Stat> stats = simulator.run();
            double count = 0;
            for (Stat stat : stats) {
                int nb_paquets1 = stat.getPaquets1();
                int nb_paquets2 = stat.getPaquets2();
                int nb_paquets_total = nb_paquets1 + nb_paquets2;
                count+= nb_paquets_total;
            }
            list_finale.put(count/stats.size(), i);
            System.out.println("Pour n = " + i + " on a nombre moyen de paquets en attente = " + count/stats.size());
        }
        
        System.out.println("\tLe min est pour n = " + list_finale.firstEntry().getValue() + " (avec Nmoy = " + list_finale.firstEntry().getKey() + ")");

    }

}

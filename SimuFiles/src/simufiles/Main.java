/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simufiles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static final int ARRIVAL = 0;
    public static final int DEPART = 1;

    public static void main(String[] args) {
        double mu1, mu2, lambda;
        int nb_paquets_max;
        if (args.length < 4) {
            System.out.println("Veuillez renseigner les paramètres -> mu1, mu2, lambda, nb_paquets_max");
            return;
        }
        mu1 = Double.parseDouble(args[0]);
        mu2 = Double.parseDouble(args[1]);
        lambda = Double.parseDouble(args[2]);
        nb_paquets_max = Integer.parseInt(args[3]);

        /**
         * mu1, mu2, lambda, nb_periode, nb_paquets_max
         */
        TreeMap<Double, Integer> list_finale = new TreeMap<>();
        for (int i = 1; i < 100; i++) {
            List<Double> moyennes = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Simulator simulator = new Simulator(mu1, mu2, lambda, i, nb_paquets_max);
                LinkedList<Stat> stats = simulator.run();
                double count = 0;
                for (Stat stat : stats) {
                    int nb_paquets1 = stat.getPaquets1();
                    int nb_paquets2 = stat.getPaquets2();
                    int nb_paquets_total = nb_paquets1 + nb_paquets2;
                    count += nb_paquets_total;
                }
                double moyenne = count / stats.size();
                moyennes.add(moyenne);
            }
            double super_moyenne = calculateAverage(moyennes);
            list_finale.put(super_moyenne, i);

            Intervalle intervalle_de_confiance = intervalle_de_confiance(moyennes, super_moyenne, moyennes.size());
            System.out.println("Pour n = " + i + " on a un nombre moyen de paquets en attente = " + super_moyenne + " [" + intervalle_de_confiance.getInf() + ", " + intervalle_de_confiance.getMax() + "] ");
        }

        System.out.println("\tLe min est pour n = " + list_finale.firstEntry().getValue() + " (avec Nmoy = " + list_finale.firstEntry().getKey() + ")");

    }

    public static Intervalle intervalle_de_confiance(List<Double> list, double moyenne, int taille) {
        double variance = variance(list, moyenne);
        double erreur = 2 * Math.sqrt(variance / taille);
        Intervalle result = new Intervalle(moyenne - erreur, moyenne + erreur);
        return result;
    }

    private static double calculateAverage(List<Double> marks) {
        double sum = 0;
        if (!marks.isEmpty()) {
            for (Double mark : marks) {
                sum += mark;
            }
            return sum / marks.size();
        }
        return sum;
    }

    private static double variance(List<Double> list, double moyenne) {
        double sum_temp = 0;
        for (Double double1 : list) {
            sum_temp += (double1 - moyenne) * (double1 - moyenne);
        }
        sum_temp = sum_temp / list.size();
        return sum_temp;
    }

    public static class Intervalle {

        private double inf;
        private double max;

        public Intervalle(double inf, double max) {
            this.inf = inf;
            this.max = max;
        }

        /**
         * @return the inf
         */
        public double getInf() {
            return inf;
        }

        /**
         * @param inf the inf to set
         */
        public void setInf(double inf) {
            this.inf = inf;
        }

        /**
         * @return the max
         */
        public double getMax() {
            return max;
        }

        /**
         * @param max the max to set
         */
        public void setMax(double max) {
            this.max = max;
        }

    }

}

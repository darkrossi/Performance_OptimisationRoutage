package simufiles;

import java.util.Random;
import java.util.*;

public class Poisson {

//    int secondes;
    double lambda;
    Random rand;

//    public Poisson(double lam, int nbSecondes) {
//        secondes = nbSecondes;
//        lambda = lam;
//        rand = new Random((new Date()).getTime());
//    }
    public Poisson(double lambda) {
        this.lambda = lambda;
        this.rand = new Random((new Date()).getTime());
    }

    public double getPoisson() {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= Math.random();
        } while (p > L);

        return k - 1;
    }

}

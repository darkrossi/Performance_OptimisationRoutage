package simufiles;

import java.util.Random;
import java.util.*;

public class Exponentielle {

    double mu;
    Random rand;

    public Exponentielle(double mu) {
        this.mu = mu;
        rand = new Random((new Date()).getTime());
    }

    public double getExp() {
        return -(Math.log(rand.nextDouble()) / mu);

    }
}

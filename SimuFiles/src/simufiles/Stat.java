/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simufiles;

/**
 *
 * @author Mickaël
 */
public class Stat {

    private double time;
    private int paquets1, paquets2;

    public Stat(double time, int paquets1, int paquets2) {
        this.time = time;
        this.paquets1 = paquets1;
        this.paquets2 = paquets2;
    }

    /**
     * @return the time
     */
    public double getTime() {
        return time;
    }

    /**
     * @return the paquets1
     */
    public int getPaquets1() {
        return paquets1;
    }

    /**
     * @return the paquets2
     */
    public int getPaquets2() {
        return paquets2;
    }

}

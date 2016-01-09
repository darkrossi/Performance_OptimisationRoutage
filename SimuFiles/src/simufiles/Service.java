package simufiles;

public class Service {

    Exponentielle ex;
    double mu;
    double time;

    /**
     * Constructeur
     *
     * @param mu
     */
    public Service(double mu) {
        this.mu = mu;
        this.ex = new Exponentielle(mu);
        this.time = 0;
    }

    public double getExp() {
        return ex.getExp();
    }

    public void arrivee(double time) {
        this.time = time;
    }

    /**
     * Test l'occupation du service
     *
     * @return
     */
    public boolean testAvailable(double time) {
        return (this.time <= time);
    }
}

package logiikka;

public class Riski {
    private Osake osake;
    private Salkku salkku;
    private Double beta;
    private Double volatiliteetti;

    public Riski(Salkku salkku, Double beta, Double volatiliteetti) {
        this.salkku = salkku;
        this.beta = beta;
        this.volatiliteetti = volatiliteetti;
    }

    public Riski(Osake osake, Double beta, Double volatiliteetti) {
        this.osake = osake;
        this.beta = beta;
        this.volatiliteetti = volatiliteetti;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }

    public Double getVolatiliteetti() {
        return volatiliteetti;
    }

    public void setVolatiliteetti(Double volatiliteetti) {
        if (volatiliteetti < 0) {
            return;
        }
        this.volatiliteetti = volatiliteetti;
    }
}

package logiikka;

public class Riski {
    private Osake osake;
    private Salkku salkku;
    private Double beta;
    private Double volatiliteetti;
    
    public Riski(Osake osake) {
        this.osake = osake;
    }
    
    public Riski(Salkku salkku) {
        this.salkku = salkku;
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

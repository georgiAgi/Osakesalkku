package logiikka;

/**
 * Luokka kuvaa riskiä markkinabetan ja volatiliteetin avulla. Kuvaa sekä
 * yksittäisten osakkeiden että koko salkun riskiä.
 *
 * @author gexgex
 */
public class Riski {

    private Double beta;
    private Double volatiliteetti;

    public Riski(Double beta, Double volatiliteetti) {
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

    /**
     * Metodi tarkistaa, ettei käyttäjän syöttämä volatiliteetti ole 
     * negatiivinen ja asettaa uuden volatiliteetin.
     *
     * @param volatiliteetti Käyttäjän syöttämä volatiliteetti
     */
    public void setVolatiliteetti(Double volatiliteetti) {
        if (volatiliteetti < 0) {
            return;
        }
        this.volatiliteetti = volatiliteetti;
    }
}

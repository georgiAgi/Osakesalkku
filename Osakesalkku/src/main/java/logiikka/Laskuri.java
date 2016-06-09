package logiikka;

/**
 * Luokka tarjoaa useita salkun tunnuslukujen laskentaan tarvittavia metodeita.
 * 
 * @author gexgex
 */
public class Laskuri {
    private Salkku salkku;
    
    public Laskuri(Salkku salkku) {
        this.salkku = salkku;
    }
    
    /**
     * Metodi laskee ja palauttaa salkun arvonmuutoksen euroissa.
     */
    public double salkunArvonMuutos() {
        return salkku.arvo() - salkku.alkuArvo();
    }
    
    /**
     * Metodi laskee ja palauttaa salkun prosentuaalisen kasvun.
     */
    public double salkunArvonKasvuprosentti() {
        double desimaali = (double) salkunArvonMuutos() / salkku.alkuArvo();
        desimaali *= 100;
        return desimaali;
    }
    
    /**
     * Metodi palauttaa parametrina olevan osakkeen arvonmuutoksen euroissa.
     * 
     * @param   osake   Osake, jonka arvonmuutos lasketaan
     */
    public double osakkeenArvonMuutos(Osake osake) {
        return osake.getHinta() - osake.getAlkuArvo();
    }
    
    /**
     * Metodi palauttaa parametrina olevan osakkeen prosentuaalisen kasvun.
     *
     * @param osake Osake, jonka arvonmuutos lasketaan
     */
    public double osakkeenArvonKasvuprosentti(Osake osake) {
        double desimaali = (double) osakkeenArvonMuutos(osake) / osake.getAlkuArvo();
        desimaali *= 100;
        return desimaali;
    }
    
    /**
     * Metodi palauttaa osakesalkun markkinabetan.
     * 
     * HUOM: Kuvaa salkun ja markkinoiden kehityksen korrelaatiota.
     */
    public double salkunBeta() {
        double beta = 0;
        for (Osake o : salkku.getOsakkeet()) {
            beta += o.getMaara() * o.getHinta() * o.getRiski().getBeta();
        }
        return beta / salkunOsakkeidenPainotettuMaara(); //osakkeiden beta-lukujen painotettu keskiarvo;
    }
    
    private int salkunOsakkeidenPainotettuMaara() {
        int maara = 0;
        for (Osake o : salkku.getOsakkeet()) {
            maara += o.getMaara() * o.getHinta();
        }
        return maara;
    }
    
    /**
     * Metodi palauttaa osakesalkun volatiliteetin eli keskihajonnan.
     * 
     * HUOM: Metodi käyttää erittäin karkeaa arviota osakkeiden korrelaatiosta.
     */
    public double salkunVolatiliteetti() {
        double volatiliteetti = 0;
        double osakkeidenMaara = salkunOsakkeidenPainotettuMaara();
        for (Osake i : salkku.getOsakkeet()) {
            for (Osake j : salkku.getOsakkeet()) {
                volatiliteetti += (i.getMaara() * i.getHinta() / osakkeidenMaara) * (j.getMaara() * j.getHinta() / osakkeidenMaara) * korrelaatio(i, j) * i.getRiski().getVolatiliteetti() * j.getRiski().getVolatiliteetti();
            }
        }
        volatiliteetti = Math.sqrt(volatiliteetti);
        return volatiliteetti;
    }
    
    private double korrelaatio(Osake a, Osake b) {
        if (a.equals(b)) {
            return 1.0;
        }
        return Math.min((a.getToimiala().getKorrelaatio() + b.getToimiala().getKorrelaatio()) / 2, 1.0); //korrelaatio korkeintaan 1
    } //oikeasti korrelaatio vaatisi hirveästi dataa osakkeista, nyt vain vertailen toimialoja, arviot ovat epätarkkoja, mutta kelpaavat varmaan tähän projektiin
}

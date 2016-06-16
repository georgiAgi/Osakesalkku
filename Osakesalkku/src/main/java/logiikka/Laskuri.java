package logiikka;

/**
 * Luokka tarjoaa useita salkun tunnuslukujen laskentaan tarvittavia metodeita.
 * 
 * @author gexgex
 */
public class Laskuri {
    private Salkku salkku;
    
    /**
     * Konstruktori luo uuden laskurin, joka käyttää metodeissaan parametrinaan 
     * saamaansa Salkku-oliota.
     *
     * @param salkku laskurissa käytettävä salkku
     */
    public Laskuri(Salkku salkku) {
        this.salkku = salkku;
    }
    
    /**
     * Metodi laskee ja palauttaa salkun arvonmuutoksen euroissa.
     * 
     * @return liukulukumuotoinen salkun arvonmuutos
     */
    public double salkunArvonmuutos() {
        return salkku.arvo() - salkku.alkuArvo();
    }
    
    /**
     * Metodi laskee ja palauttaa salkun prosentuaalisen kasvun.
     *
     * @return liukulukumuotoinen salkun kasvuprosentti
     */
    public double salkunArvonKasvuprosentti() {
        double desimaali = (double) salkunArvonmuutos() / salkku.alkuArvo();
        desimaali *= 100;
        return desimaali;
    }
    
    /**
     * Metodi palauttaa parametrina olevan osakkeen arvonmuutoksen euroissa.
     * 
     * @param   osake   Osake, jonka arvonmuutos lasketaan
     *
     * @return liukulukumuotoinen osakkeen arvonmuutos
     */
    public double osakkeenArvonmuutos(Osake osake) {
        return osake.getHinta() - osake.getAlkuArvo();
    }
    
    /**
     * Metodi palauttaa parametrina olevan osakkeen prosentuaalisen kasvun.
     *
     * @param osake Osake, jonka arvonmuutos lasketaan
     * 
     * @return liukulukumuotoinen osakkeen kasvuprosentti
     */
    public double osakkeenArvonKasvuprosentti(Osake osake) {
        double desimaali = (double) osakkeenArvonmuutos(osake) / osake.getAlkuArvo();
        desimaali *= 100;
        return desimaali;
    }
    
    /**
     * Metodi palauttaa osakesalkun markkinabetan.
     * 
     * HUOM: Kuvaa salkun ja markkinoiden kehityksen korrelaatiota.
     *
     * @return liukulukumuotoinen salkun markkinabeta
     */
    public double salkunBeta() {
        double beta = 0;
        for (Osake o : salkku.getOsakkeet()) {
            beta += o.getMaara() * o.getHinta() * o.getRiski().getBeta();
        }
        return beta / salkunOsakkeidenPainotettuMaara();
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
     *
     * @return liukulukumuotoinen salkun volatiliteetti
     */
    public double salkunVolatiliteetti() {
        double volatiliteetti = 0;
        double osakkeidenMaara = salkunOsakkeidenPainotettuMaara();
        for (Osake i : salkku.getOsakkeet()) {
            for (Osake j : salkku.getOsakkeet()) {
                volatiliteetti += (i.getMaara() * i.getHinta() / osakkeidenMaara) 
                        * (j.getMaara() * j.getHinta() / osakkeidenMaara) 
                        * korrelaatio(i, j) * i.getRiski().getVolatiliteetti() 
                        * j.getRiski().getVolatiliteetti();
            }
        }
        volatiliteetti = Math.sqrt(volatiliteetti);
        return volatiliteetti;
    }
    
    private double korrelaatio(Osake a, Osake b) {
        if (a.equals(b)) {
            return 1.0;
        }
        return Math.min((a.getToimiala().getKorrelaatio() 
                + b.getToimiala().getKorrelaatio()) / 2, 1.0);
    } 
}

package logiikka;

public class Laskuri {
    private Salkku salkku;
    
    public Laskuri(Salkku salkku) {
        this.salkku = salkku;
    }
    
    public int salkunArvonMuutos() {
        return salkku.arvo() - salkku.alkuArvo();
    }
    
    public int salkunArvonSuhteellinenMuutos() {
        return (salkku.arvo() - salkku.alkuArvo()) / salkku.alkuArvo() * 100;
    }
    
    public int osakkeenArvonMuutos(Osake osake) {
        return osake.getHinta() - osake.getAlkuArvo();
    }
    
    public int osakkeenArvonSuhteellinenMuutos(Osake osake) {
        return osakkeenArvonMuutos(osake) / osake.getAlkuArvo() * 100;
    }
    
    public double salkunBeta() {
        double beta = 0;
        int osakkeidenMaara = 0;
        for (Osake o : salkku.getOsakkeet()) {
            beta += o.getMaara() * o.getRiski().getBeta();
            osakkeidenMaara += o.getMaara();
        }
        return beta / osakkeidenMaara; //osakkeiden beta-lukujen painotettu keskiarvo;
    }
    
    public int salkunOsakkeidenMaara() {
        int maara = 0;
        for (Osake o : salkku.getOsakkeet()) {
            maara += o.getMaara();
        }
        return maara;
    }
    
    public double salkunVolatiliteetti() {
        double volatiliteetti = 0;
        int osakkeidenMaara = salkunOsakkeidenMaara();
        for (Osake i : salkku.getOsakkeet()) {
            for (Osake j : salkku.getOsakkeet()) {
                volatiliteetti += (i.getMaara() / osakkeidenMaara) * (j.getMaara() / osakkeidenMaara) * korrelaatio(i, j) * i.getRiski().getVolatiliteetti() * j.getRiski().getVolatiliteetti();
            }
        }
        return volatiliteetti;
    }
    
    public double korrelaatio(Osake a, Osake b) {
        if (a.equals(b)) {
            return 1.0;
        }
        return Math.min((a.getToimiala().getKorrelaatio() + b.getToimiala().getKorrelaatio()) / 2, 1.0);
    }
}
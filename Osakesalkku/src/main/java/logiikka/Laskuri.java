package logiikka;

public class Laskuri {
    private Salkku salkku;
    
    public Laskuri(Salkku salkku) {
        this.salkku = salkku;
    }
    
    public int salkunArvonMuutos() {
        return salkku.arvo() - salkku.alkuArvo();
    }
    
    public int salkunArvonKasvuprosentti() {
        double desimaali = (double) salkunArvonMuutos() / salkku.alkuArvo();
        desimaali *= 100;
        return (int) desimaali;
    }
    
    public int osakkeenArvonMuutos(Osake osake) {
        return osake.getHinta() - osake.getAlkuArvo();
    }
    
    public int osakkeenArvonKasvuprosentti(Osake osake) {
        double desimaali = (double) osakkeenArvonMuutos(osake) / osake.getAlkuArvo();
        desimaali *= 100;
        return (int) desimaali;
    }
    
    public double salkunBeta() {
        double beta = 0;
        int osakkeidenPainotettuMaara = 0;
        for (Osake o : salkku.getOsakkeet()) {
            beta += o.getMaara() * o.getHinta() * o.getRiski().getBeta();
            osakkeidenPainotettuMaara += o.getMaara() * o.getHinta();
        }
        return beta / osakkeidenPainotettuMaara; //osakkeiden beta-lukujen painotettu keskiarvo;
    }
    
    public int salkunOsakkeidenPainotettuMaara() {
        int maara = 0;
        for (Osake o : salkku.getOsakkeet()) {
            maara += o.getMaara() * o.getHinta();
        }
        return maara;
    }
    
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
    
    public double korrelaatio(Osake a, Osake b) {
        if (a.equals(b)) {
            return 1.0;
        }
        return Math.min((a.getToimiala().getKorrelaatio() + b.getToimiala().getKorrelaatio()) / 2, 1.0); //korrelaatio korkeintaan 1
    } //oikeasti korrelaatio vaatisi hirveästi dataa osakkeista, nyt vain vertailen toimialoja, arviot ovat epätarkkoja, mutta kelpaavat varmaan tähän projektiin
}

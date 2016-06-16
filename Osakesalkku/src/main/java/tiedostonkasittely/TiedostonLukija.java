package tiedostonkasittely;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import logiikka.Osake;
import logiikka.Riski;
import logiikka.Salkku;
import logiikka.Toimiala;

/**
 * Luokka toteuttaa osakesalkun tiedostosta lukemisen.
 *
 * @author gexgex
 */
public class TiedostonLukija {
    private Salkku salkku;
    
    /**
     * Metodi lukee tekstitiedoston joka oletettavasti sisältää salkun tiedot
     * oikeassa muodossa ja luo niiden perusteella salkun.
     *
     * @param tiedosto Luettava tiedosto
     * 
     * @throws FileNotFoundException
     */
    public void lue(File tiedosto) throws FileNotFoundException {
        salkku = new Salkku();
        Scanner lukija = new Scanner(tiedosto);
        
        while (lukija.hasNextLine()) {
            String osakeTxt = lukija.nextLine();
            String[] osakeTiedot = osakeTxt.split(";");
            if (osakeTiedot.length != 7) {
                break;
            }
            salkku.lisaaOsake(merkkijonotOsakkeeksi(osakeTiedot));
        }
    }
    
    private Osake merkkijonotOsakkeeksi(String[] osakeTiedot) {
        String nimi = osakeTiedot[0];
        double hinta = Double.parseDouble(osakeTiedot[1]);
        int maara = Integer.parseInt(osakeTiedot[2]);
        double alkuArvo = Double.parseDouble(osakeTiedot[3]);
        Toimiala toimiala = Toimiala.merkkijonoToimialaksi(osakeTiedot[4].toUpperCase());
        double beta = Double.parseDouble(osakeTiedot[5]);
        double volatiliteetti = Double.parseDouble(osakeTiedot[6]);
        
        Osake osake = new Osake(nimi, hinta, maara);
        osake.setRiski(new Riski(beta, volatiliteetti));
        osake.setToimiala(toimiala);

        return osake;
    }
    
    public Salkku getSalkku() {
        return this.salkku;
    }
}

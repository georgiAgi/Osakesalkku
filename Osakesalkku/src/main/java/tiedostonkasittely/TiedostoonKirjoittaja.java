package tiedostonkasittely;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.nio.file.*;
import logiikka.*;

/**
 * Luokka toteuttaa osakesalkun tiedostoon kirjoittamisen. Tiedostot 
 * tallennetaan .salkku-tyyppisiksi tekstitiedostoiksi.
 *
 * @author gexgex
 */
public class TiedostoonKirjoittaja {

    private Salkku salkku;
    private File tiedosto;

    /**
     * Konstruktori luo uuden tiedostonkirjoittajan. Se asettaa parametrina 
     * saadun Salkku-olion luokan attribuutiksi.
     *
     * @param salkku Tiedostoon kirjoitettava salkku
     */
    public TiedostoonKirjoittaja(Salkku salkku) {
        this.salkku = salkku;
    }

    /**
     * Metodi kirjoittaa salkun tiedot uudelle .salkku-tiedostolle.
     *
     * @param tiedostonNimi Tiedoston nimi polkua varten
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void save(String tiedostonNimi) throws FileNotFoundException, IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        Path polku = Files.write(Paths.get(tiedostonNimi + ".salkku"), rivit(), 
                utf8, StandardOpenOption.CREATE);
        
        tiedosto = polku.toFile();
    }
    
    public File getTiedosto() {
        return this.tiedosto;
    }

    /**
     * Metodi palauttaa salkun osakkeet merkkijonotyyppisinä riveinä .salkku-
     * tiedostoon sopivassa muodossa.
     *
     * @return lista oikeanmuotoisia osakkeita merkkijonoina
     */
    public List<String> rivit() {
        ArrayList<String> rivit = new ArrayList();

        for (Osake osake : salkku.getOsakkeet()) {
            rivit.add(osake.getNimi() + ";" + osake.getHinta() + ";" 
                    + osake.getMaara() + ";" + osake.getAlkuArvo() + ";" 
                    + osake.getToimiala() + ";" + osake.getRiski().getBeta() 
                    + ";" + osake.getRiski().getVolatiliteetti());
        }

        return rivit;
    }
}

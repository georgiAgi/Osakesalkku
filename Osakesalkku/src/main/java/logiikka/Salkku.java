package logiikka;

import java.util.*;

/**
 * Luokka toimii osakesalkkuna sisältäen listan osakkeistaan. Sen metodit
 * palauttavat joitain salkkuun liittyviä tunnuslukuja.
 *
 * @author gexgex
 */
public class Salkku {

    private Riski riski;
    private List<Osake> osakkeet;

    /**
     * Konstruktori luo uuden Salkku-olion ja tälle tyhjän ArrayListin osakkeita
     * varten.
     * 
     */
    public Salkku() {
        osakkeet = new ArrayList();
    }

    /**
     * Metodi palauttaa osakesalkun arvon perustuen osakkeiden määrään ja
     * hintoihin.
     *
     * @return liukulukumuotoinen salkun arvo
     */
    public double arvo() {
        double arvo = 0;
        for (Osake o : osakkeet) {
            arvo += o.getMaara() * o.getHinta();
        }
        return arvo;
    }

    /**
     * Metodi palauttaa salkusta osakkeen parametrina olevan osakkeen nimen
     * perusteella. Jos osaketta ei ole, metodi palauttaa null.
     *
     * @param nimi Käyttäjän hakeman osakkeen nimi
     *
     * @return osake, jonka nimi vastaa haettua
     */
    public Osake osakeNimenPerusteella(String nimi) {
        for (Osake o : osakkeet) {
            if (o.getNimi().equals(nimi)) {
                return o;
            }
        }
        return null;
    }

    public List<Osake> getOsakkeet() {
        return osakkeet;
    }

    /**
     * Metodi lisää parametrina syötetyn osakkeen salkkuun. Se ensin tarkistaa,
     * ettei osakkeen hinta ole negatiivinen ja ettei salkussa ole jo samaa
     * osaketta. Jos on, se kutsuu vaihdaOsaketta() metodia, jolloin osaketta
     * ostetaan salkkuun lisää.
     *
     * @param osake Salkkuun lisättävä osake
     */
    public void lisaaOsake(Osake osake) {
        if (osake.getHinta() < 0) {
            return;
        }
        if (osakkeet.contains(osake)) {
            vaihdaOsaketta(osake);
            return;
        }
        osakkeet.add(osake);
    }

    /**
     * Metodi vaihtaa osaketta, eli muuttaa osakkeiden määrän ja arvon. Jos
     * osaketta ostetaan lisää se muuttaa sen alkuarvon kutsumalla Osake-luokan
     * uusiAlkuArvo()-metodia. Jos osakkeen määrä muuttuu nollaksi, se poistaa
     * osakkeen salkusta kutsumalla poistaOsake()-metodia.
     *
     * @param osake Vaihdettava osake
     */
    public void vaihdaOsaketta(Osake osake) {
        Osake o = osakeNimenPerusteella(osake.getNimi());

        if (osake.getMaara() > 0) {
            o.uusiAlkuArvo(osake);
        } else if (osake.getMaara() + o.getMaara() == 0) {
            poistaOsake(o);
            return;
        }
        o.setMaara(osake.getMaara() + o.getMaara());
        o.setHinta(osake.getHinta());
    }

    /**
     * Metodi palauttaa salkussa olevien osakkeiden eri toimialojen lukumäärän.
     *
     * @return kokonaisluku, joka vastaa salkun toimialojen lukumäärää
     */
    public int toimialojenLkm() {
        HashSet<Toimiala> toimialat = new HashSet();
        for (Osake o : osakkeet) {
            toimialat.add(o.getToimiala());
        }
        return toimialat.size();
    }

    public Riski getRiski() {
        return riski;
    }

    public void setRiski(Riski riski) {
        this.riski = riski;
    }

    /**
     * Metodi poistaa osakkeen salkusta.
     *
     * @param osake Poistettava osake
     */
    public void poistaOsake(Osake osake) {
        for (int i = 0; i < osakkeet.size(); i++) {
            if (osakkeet.get(i).equals(osake)) {
                osakkeet.remove(i);
            }
        }
    }

    /**
     * Metodi palauttaa salkun alkuarvon eli osakkeiden keskimääräiseen
     * hankintahintaan perustuvan kokonaisarvon.
     *
     * @return liukulukumuotoinen alkuarvo perustuen osakkeiden
     * hankintahintoihin
     */
    public double alkuArvo() {
        double alkuArvo = 0;
        for (Osake o : osakkeet) {
            alkuArvo += o.getMaara() * o.getAlkuArvo();
        }
        return alkuArvo;
    }

}

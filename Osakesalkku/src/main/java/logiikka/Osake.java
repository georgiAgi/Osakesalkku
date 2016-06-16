package logiikka;

import java.util.Objects;

/**
 * Luokka toimii yksittäisten osakkeiden runkona.
 *
 * @author gexgex
 */
public class Osake {

    private String nimi;
    private double hinta;
    private int maara;
    private double alkuArvo;
    private Riski riski;
    private Toimiala toimiala;

    /**
     * Konstruktori luo uuden Osake-olion. Se asettaa sen nimen, hinnan, määrän
     * ja alkuarvon parametreina saatujen tietojen perusteella.
     * 
     * @param nimi osakkeen nimi
     * @param hinta osakkeen hinta
     * @param maara osakkeiden määrä
     */
    public Osake(String nimi, double hinta, int maara) {
        this.nimi = nimi;
        this.hinta = hinta;
        this.maara = maara;
        this.alkuArvo = hinta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Osake other = (Osake) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

    /**
     * Metodi laskee osakkeelle uuden alkuarvon perustuen ostojen painotettuun
     * keskiarvoon. Metodia käytetään vain kun alkuarvo, eli hankintahinta
     * muuttuu ts. ostettaessa jo omistettua osaketta lisää.
     *
     * @param uusi Oston tiedot Osake-tyyppisenä oliona
     */
    public void uusiAlkuArvo(Osake uusi) {
        double uusiArvo = this.alkuArvo * this.maara + uusi.hinta * uusi.maara;
        uusiArvo = uusiArvo / (this.maara + uusi.maara);
        this.alkuArvo = uusiArvo;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public double getHinta() {
        return hinta;
    }

    /**
     * Metodi asettaa osakkeelle hinnan, jos se ei ole negatiivinen.
     *
     * @param hinta käyttäjän asettama hinta
     */
    public void setHinta(double hinta) {
        if (hinta < 0) {
            return;
        }
        this.hinta = hinta;
    }

    public int getMaara() {
        return maara;
    }

    public void setMaara(int maara) {
        this.maara = maara;
    }

    public double getAlkuArvo() {
        return alkuArvo;
    }

    public Riski getRiski() {
        return riski;
    }

    public void setRiski(Riski riski) {
        this.riski = riski;
    }

    public Toimiala getToimiala() {
        return toimiala;
    }

    public void setToimiala(Toimiala toimiala) {
        this.toimiala = toimiala;
    }

}

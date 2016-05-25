package logiikka;

import java.util.Objects;

public class Osake {

    private String nimi;
    private int hinta;
    private int maara;
    private int alkuArvo;
    private Riski riski;
    private Toimiala toimiala;

    public Osake(String nimi, int hinta, int maara) {
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

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getHinta() {
        return hinta;
    }

    public void setHinta(int hinta) {
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

    public int getAlkuArvo() {
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

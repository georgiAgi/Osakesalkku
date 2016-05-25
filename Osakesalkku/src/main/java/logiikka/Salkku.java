package logiikka;

import java.util.*;

public class Salkku {
    private Riski riski;
    private List<Osake> osakkeet;
    
    public Salkku() {
        osakkeet = new ArrayList();
    }

    public int arvo() {
        int arvo = 0;
        for (Osake o : osakkeet) {
            arvo += o.getMaara() * o.getHinta();
        }
        return arvo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.osakkeet);
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
        final Salkku other = (Salkku) obj;
        if (!Objects.equals(this.osakkeet, other.osakkeet)) {
            return false;
        }
        return true;
    }

    public List<Osake> getOsakkeet() {
        return osakkeet;
    }

    public void lisaaOsake(Osake osake) {
        if (osake.getHinta() < 0) {
            return;
        }
        if (osakkeet.contains(osake)) {
            ostaOsaketta(osake); //ostaa osaketta, jos se omistetaan jo
            return;
        }
        osakkeet.add(osake);
    }
    
    public void ostaOsaketta(Osake osake) { //toimii myös myyntinä toistaiseksi
        if (!osakkeet.contains(osake)) {
            lisaaOsake(osake); //lisää osakkeen salkkuun eli ostaa sitä ensimmäisen kerran
            return;
        }
        int arvo = osake.getHinta();
        if (arvo < 0) {
            return; //hinta ei voi olla negatiivinen. Tästä täytyisi varmaan vielä tehdä virheilmoitus
        }
        for (Osake o : osakkeet) {
            if (o.equals(osake)) {
                o.setHinta(arvo);
                int maara = o.getMaara();
                maara += osake.getMaara();
                o.setMaara(maara);
            }
        }
        return;
    }
    
    public int alkuArvo() {
        int alkuArvo = 0;
        for (Osake o : osakkeet) {
            alkuArvo += o.getMaara() * o.getAlkuArvo();
        }
        return alkuArvo;
    }
    
}

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

    public void lisaaOsake(Osake osake) {
        if (osake.getHinta() < 0) {
            return;
        }
        if (osakkeet.contains(osake)) {
            vaihdaOsaketta(osake); //ostaa osaketta, jos se omistetaan jo
            return;
        }
        osakkeet.add(osake);
    }
    
    public void vaihdaOsaketta(Osake osake) { //osto ja myynti, turha eriyttää kahdeksi lähes identtiseksi metodiksi
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
                int maara = o.getMaara();
                
                if (osake.getMaara() + maara < 0) {
                    return; //toistaiseksi ainakaan osakkeita ei voi shortata, eli osakkeiden määrä ei voi painua negatiiviseksi
                }
                
                maara += osake.getMaara();
                if (maara == 0) {
                    poistaOsake(o); //poistaa osakkeen salkusta, jos loputkin myydään pois
                    return;
                }
                
                o.setMaara(maara);
                o.setHinta(arvo);
                o.setToimiala(osake.getToimiala());
                o.setRiski(osake.getRiski());
            }
        }
    }

    public Riski getRiski() {
        return riski;
    }

    public void setRiski(Riski riski) {
        this.riski = riski;
    }
    
    public void poistaOsake(Osake osake) {
        for (int i = 0; i < osakkeet.size(); i++) {
            if (osakkeet.get(i) == osake) {
                osakkeet.remove(i);
            }
        }
    }
    
    public int alkuArvo() {
        int alkuArvo = 0;
        for (Osake o : osakkeet) {
            alkuArvo += o.getMaara() * o.getAlkuArvo();
        }
        return alkuArvo;
    }
    
}

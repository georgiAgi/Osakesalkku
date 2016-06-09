package logiikka;

import java.util.*;

/**
 * Luokka toimii osakesalkkuna sisältäen listan osakkeistaan.
 * Sen metodit palauttavat joitain salkkuun liittyviä tunnuslukuja.
 * 
 * @author gexgex
 */
public class Salkku {
    private Riski riski;
    private List<Osake> osakkeet;
    
    public Salkku() {
        osakkeet = new ArrayList();
    }

    /**
     * Metodi palauttaa osakesalkun arvon perustuen osakkeiden määrään ja 
     * hintoihin.
     */
    public double arvo() {
        double arvo = 0;
        for (Osake o : osakkeet) {
            arvo += o.getMaara() * o.getHinta();
        }
        return arvo;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 71 * hash + Objects.hashCode(this.osakkeet);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Salkku other = (Salkku) obj;
//        if (!Objects.equals(this.osakkeet, other.osakkeet)) {
//            return false;
//        }
//        return true;
//    }
    
    /**
     * Metodi palauttaa salkusta osakkeen parametrina olevan osakkeen nimen 
     * perusteella. Jos osaketta ei ole, metodi palauttaa null.
     *
     * @param nimi Käyttäjän hakeman osakkeen nimi
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
        double arvo = osake.getHinta();
        if (arvo < 0) {
            return; //hinta ei voi olla negatiivinen. Tästä täytyisi varmaan vielä tehdä virheilmoitus
        }
        for (Osake o : osakkeet) {
            if (o.equals(osake)) {
                int maara = o.getMaara();
                
                if (osake.getMaara() + maara < 0) {
                    return; //toistaiseksi ainakaan osakkeita ei voi shortata, eli osakkeiden määrä ei voi painua negatiiviseksi
                }
                
                if (osake.getMaara() > 0) { //ostettaessa lisää, muutetaan alkuarvoa
                    o.uusiAlkuArvo(osake);
                }
                
                maara += osake.getMaara();
                if (maara == 0) {
                    poistaOsake(o); //poistaa osakkeen salkusta, jos loputkin myydään pois
                    return;
                }
                
                o.setMaara(maara);
                o.setHinta(arvo);
//                o.setToimiala(osake.getToimiala());
//                o.setRiski(osake.getRiski());
            }
        }
    }
    
    /**
     * Metodi palauttaa salkussa olevien osakkeiden eri toimialojen lukumäärän.
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
     */
    public double alkuArvo() {
        double alkuArvo = 0;
        for (Osake o : osakkeet) {
            alkuArvo += o.getMaara() * o.getAlkuArvo();
        }
        return alkuArvo;
    }
    
}

package logiikka;
/**
 * Enum-luokka sisältää käytettävissä olevat toimialat, sekä näihin liittyvät 
 * korrelaatiot markkinan kanssa.
 * 
 * HUOM: 24.5. laskettu toimialan beta-lukujen keskiarvo, joka kuvastaa tässä
 * toimialariskiä.
 * 
 * @author gexgex
 */
public enum Toimiala {
    PERUSTEOLLISUUS(1.029),
    TEOLLISUUSTUOTTEET(0.63465116),
    KULUTUSTAVARAT(0.53285714),
    TERVEYDENHUOLTO(0.70285714),
    KULUTUSPALVELUT(0.475),
    TIETOLIIKENNEPALVELUT(0.95),
    RAHOITUS(0.48823529),
    TEKNOLOGIA(0.62473684),
    ENERGIA(0.975);
    
    private Double korrelaatioMarkkinanKanssa;
    
    private Toimiala(Double korrelaatio) {
        this.korrelaatioMarkkinanKanssa = korrelaatio;
    }
    
    public Double getKorrelaatio() {
        return this.korrelaatioMarkkinanKanssa;
    }
    
    /**
     * Metodi palauttaa toimialan parametrina olevan nimen perusteella.
     *
     * @param merkkijono Käyttäjän syöttämä toimialan nimi ISOIN kirjaimin
     * 
     * @return toimiala jos sellainen merkkijonon perusteella löytyy
     */
    public static Toimiala merkkijonoToimialaksi(String merkkijono) {
        for (Toimiala t : Toimiala.values()) {
            if (merkkijono.equals(t.name())) {
                return t;
            }
        }
        return null;
    }

    /**
     * Metodi palauttaa toimialan nimen isolla alkukirjaimella kirjoitettuna 
     * String-tyyppisenä oliona.
     */
    @Override
    public String toString() {
        String toimiala = name().toLowerCase();
        String palautettava = toimiala.substring(0, 1).toUpperCase() + toimiala.substring(1);
        return palautettava;
    }
}

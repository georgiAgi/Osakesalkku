package logiikka;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SalkkuTest {
    
    Salkku salkku;
    ArrayList<Osake> osakkeet;
    
    public SalkkuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Osake a = new Osake("Talvivaara", 1, 1000);
        Osake b = new Osake("Nokia", 6, 1000);
        Osake c = new Osake("Nordea", 10, 1000);
        
        a.setToimiala(Toimiala.PERUSTEOLLISUUS);
        b.setToimiala(Toimiala.TEKNOLOGIA);
        c.setToimiala(Toimiala.RAHOITUS);
        
        a.setRiski(new Riski(1.2, 0.3));
        b.setRiski(new Riski(0.5, 0.2));
        c.setRiski(new Riski(0.7, 0.24));
        
        salkku = new Salkku();
        
        osakkeet = new ArrayList();
        osakkeet.add(a);
        osakkeet.add(b);
        osakkeet.add(c);
        
        for (Osake o : osakkeet) {
            salkku.lisaaOsake(o);
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void salkkuLisaaOsakkeetOikein() {
        String vastaus = "";
        
        for (Osake o : salkku.getOsakkeet()) {
            vastaus += o.getNimi() + " ";
        }
        
        assertEquals("Talvivaara Nokia Nordea ", vastaus);
    }
    
    @Test
    public void salkkuEiLisaaSamaaOsaketta() {
        salkku.lisaaOsake(new Osake("Nokia", 5, 500));

        String vastaus = "";

        for (Osake o : salkku.getOsakkeet()) {
            vastaus += o.getNimi() + " ";
        }
        
        assertEquals("Talvivaara Nokia Nordea ", vastaus);
    }
    
    @Test
    public void salkussaOnOikeaArvo() {
        double vastaus = salkku.arvo();
        
        assertEquals(17000, vastaus, 0.02);
    }
    
    @Test
    public void salkussaOnOikeaArvoJoOmistetunOsakkeenLisayksenJalkeen() {
        salkku.vaihdaOsaketta(new Osake("Nokia", 5, 500));
        
        double vastaus = salkku.arvo();

        assertEquals(18500, vastaus, 0.02);
    }
    
    @Test
    public void salkkuunEiVoiLisataNegatiivisiaOsakkeita() {
        salkku.lisaaOsake(new Osake("Nokia", -5, 500));

        double vastaus = salkku.arvo();

        assertEquals(17000, vastaus, 0.02);
    }
    
    @Test
    public void salkkuunEiVoiOstaaNegatiivisiaOsakkeita() {
        salkku.vaihdaOsaketta(new Osake("Nokia", -5, 500));

        double vastaus = salkku.arvo();

        assertEquals(17000, vastaus, 0.02);
    }
    
    @Test
    public void salkkuLoytaaOsakkeenNimenPerusteella() {
        Osake vastaus = salkku.osakeNimenPerusteella("Nordea");

        assertEquals(new Osake("Nordea", 0, 0), vastaus);
    }
    
    @Test
    public void salkkuPalauttaaNullJosOsakettaEiOleNimenPerusteella() {
        Osake vastaus = salkku.osakeNimenPerusteella("Gazprom");

        assertEquals(null, vastaus);
    }
    
    @Test
    public void salkkuLisaaOsakkeenJosVaihdetaanOsakettaJotaEiOmisteta() {
        salkku.vaihdaOsaketta(new Osake("Cargotec", 4, 5000));
        Osake vastaus = salkku.getOsakkeet().get(salkku.getOsakkeet().size()-1);
        
        assertEquals(new Osake("Cargotec", 0, 0), vastaus);
    }
    
    @Test
    public void salkkuPoistaaOikein() {
        salkku.poistaOsake(new Osake("Talvivaara", 4, 5000));
        int vastaus = salkku.getOsakkeet().size();
        
        assertEquals(2, vastaus);
    }
    
    @Test
    public void salkkuLaskeeToimialatOikein() {
        Osake osake = new Osake("Sampo", 13, 500);
        osake.setToimiala(Toimiala.RAHOITUS);
        salkku.lisaaOsake(osake);
        int vastaus = salkku.toimialojenLkm();

        assertEquals(3, vastaus);
    }
}

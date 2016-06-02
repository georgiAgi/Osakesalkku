package logiikka;

import java.util.ArrayList;
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
        
        a.setRiski(new Riski(a, 1.2, 0.3));
        b.setRiski(new Riski(b, 0.5, 0.2));
        c.setRiski(new Riski(c, 0.7, 0.24));
        
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
        int vastaus = salkku.arvo();
        
        assertEquals(17000, vastaus);
    }
    
    @Test
    public void salkussaOnOikeaArvoJoOmistetunOsakkeenLisayksenJalkeen() {
        salkku.vaihdaOsaketta(new Osake("Nokia", 5, 500));
        
        int vastaus = salkku.arvo();

        assertEquals(18500, vastaus);
    }
    
    @Test
    public void salkkuunEiVoiLisataNegatiivisiaOsakkeita() {
        salkku.lisaaOsake(new Osake("Nokia", -5, 500));

        int vastaus = salkku.arvo();

        assertEquals(17000, vastaus);
    }
    
    @Test
    public void salkkuunEiVoiOstaaNegatiivisiaOsakkeita() {
        salkku.vaihdaOsaketta(new Osake("Nokia", -5, 500));

        int vastaus = salkku.arvo();

        assertEquals(17000, vastaus);
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
}

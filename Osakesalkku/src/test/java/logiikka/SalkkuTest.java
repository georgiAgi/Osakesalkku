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
        salkku = new Salkku();
        
        osakkeet = new ArrayList();
        osakkeet.add(a);
        osakkeet.add(b);
        osakkeet.add(c);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void salkkuLisaaOsakkeetOikein() {
        for (Osake o : osakkeet) {
            salkku.lisaaOsake(o);
        }
        
        String vastaus = "";
        
        for (Osake o : salkku.getOsakkeet()) {
            vastaus += o.getNimi() + " ";
        }
        
        assertEquals("Talvivaara Nokia Nordea ", vastaus);
    }
    
    @Test
    public void salkkuEiLisaaSamaaOsaketta() {
        for (Osake o : osakkeet) {
            salkku.lisaaOsake(o);
        }
        
        salkku.lisaaOsake(new Osake("Nokia", 5, 500));

        String vastaus = "";

        for (Osake o : salkku.getOsakkeet()) {
            vastaus += o.getNimi() + " ";
        }
        
        assertEquals("Talvivaara Nokia Nordea ", vastaus);
    }
    
    @Test
    public void salkussaOnOikeaArvo() {
        for (Osake o : osakkeet) {
            salkku.lisaaOsake(o);
        }

        int vastaus = salkku.arvo();
        
        assertEquals(17000, vastaus);
    }
    
    @Test
    public void salkussaOnOikeaArvoJoOmistetunOsakkeenLisayksenJalkeen() {
        for (Osake o : osakkeet) {
            salkku.lisaaOsake(o);
        }
        salkku.ostaOsaketta(new Osake("Nokia", 5, 500));
        
        int vastaus = salkku.arvo();

        assertEquals(18500, vastaus);
    }
    
    @Test
    public void salkkuunEiVoiLisataNegatiivisiaOsakkeita() {
        for (Osake o : osakkeet) {
            salkku.lisaaOsake(o);
        }
        salkku.lisaaOsake(new Osake("Nokia", -5, 500));

        int vastaus = salkku.arvo();

        assertEquals(17000, vastaus);
    }
    
    @Test
    public void salkkuunEiVoiOstaaNegatiivisiaOsakkeita() {
        for (Osake o : osakkeet) {
            salkku.lisaaOsake(o);
        }
        salkku.ostaOsaketta(new Osake("Nokia", -5, 500));

        int vastaus = salkku.arvo();

        assertEquals(17000, vastaus);
    }
}

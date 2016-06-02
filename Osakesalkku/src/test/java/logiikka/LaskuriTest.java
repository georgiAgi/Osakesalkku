package logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaskuriTest {

    Salkku salkku;
    ArrayList<Osake> osakkeet;
    Laskuri laskuri;

    public LaskuriTest() {
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

        a.setHinta(5);

        salkku = new Salkku();

        osakkeet = new ArrayList();
        osakkeet.add(a);
        osakkeet.add(b);
        osakkeet.add(c);

        for (Osake o : osakkeet) {
            salkku.lisaaOsake(o);
        }

        this.laskuri = new Laskuri(salkku);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void salkunArvonMuutosOnOikein() {
        int vastaus = laskuri.salkunArvonMuutos();
        
        assertEquals(4000, vastaus);
    }
    
    @Test
    public void salkunArvonKasvuprosenttiOnOikein() {
        int vastaus = laskuri.salkunArvonKasvuprosentti();

        assertEquals(23, vastaus);
    }
    
    @Test
    public void osakkeenArvonKasvuprosenttiOnOikein() {
        int vastaus = laskuri.osakkeenArvonKasvuprosentti(osakkeet.get(0));

        assertEquals(400, vastaus);
    }
    
    @Test
    public void salkunBetaOnOikein() {
        double vastaus = laskuri.salkunBeta();

        assertEquals(0.76, vastaus, 0.02);
    }
    
    @Test
    public void salkunVolatiliteettiOnOikein() {
        double vastaus = laskuri.salkunVolatiliteetti();

        assertEquals(0.21, vastaus, 0.01);
    }
}

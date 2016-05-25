package logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OsakeTest {
    Osake osake;

    public OsakeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.osake = new Osake("Talvivaara", 1, 1000);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void konstruktoriAsettaaNimenOikein() {
        String vastaus = osake.getNimi();
        
        assertEquals("Talvivaara", vastaus);
    }
    
    @Test
    public void konstruktoriAsettaaHinnanOikein() {
        int vastaus = osake.getHinta();

        assertEquals(1, vastaus);
    }
    
    @Test
    public void AlkuArvoOnOikeinHinnanMuutoksenJalkeen() {
        osake.setHinta(100);
        int vastaus = osake.getAlkuArvo();
        
        assertEquals(1, vastaus);
    }
    
    @Test
    public void konstruktoriAsettaaAlkuArvonOikein() {
        int vastaus = osake.getAlkuArvo();

        assertEquals(1, vastaus);
    }
    
    @Test
    public void hintaaEiVoiAsettaaNegatiiviseksi() {
        osake.setHinta(-10);
        int vastaus = osake.getHinta();

        assertEquals(1, vastaus);
    }
}

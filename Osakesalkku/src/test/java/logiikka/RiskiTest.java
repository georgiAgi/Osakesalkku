/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gexgex
 */
public class RiskiTest {

    Salkku salkku;
    ArrayList<Osake> osakkeet;
    Laskuri laskuri;

    public RiskiTest() {
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
    public void asettaaSalkunRiskinOikein() {
        Riski salkunRiski = new Riski(salkku, laskuri.salkunBeta(), laskuri.salkunVolatiliteetti());
        salkku.setRiski(salkunRiski);
        
        assertEquals(salkku.getRiski().getVolatiliteetti(), 0.21, 0.02);
        assertEquals(salkku.getRiski().getBeta(), 0.76, 0.02);
    }
}

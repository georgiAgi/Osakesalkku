/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

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
public class ToimialaTest {

    public ToimialaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void toimialaLoytyyMerkkijononPerusteella() {
        Toimiala vastaus = Toimiala.merkkijonoToimialaksi("RAHOITUS");
        assertEquals(Toimiala.RAHOITUS, vastaus);
    }

    @Test
    public void tuntematonToimialaEiLoydy() {
        Toimiala vastaus = Toimiala.merkkijonoToimialaksi("Sähkötekniikka");
        assertEquals(null, vastaus);
    }
}

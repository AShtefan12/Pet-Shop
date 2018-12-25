/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander
 */
public class SpeciesTest {

    public SpeciesTest() {
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

    /**
     * Test of getgivenName method, of class Species.
     */
    @Test
    public void testGetgivenName() {
        System.out.println("getgivenName");
        Species instance = new Species("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, "not venomous");
        String expResult = "Boa Constrictor";
        String result = instance.getgivenName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getclassName method, of class Species.
     */
    @Test
    public void testGetclassName() {
        System.out.println("getclassName");
        Species instance = new Species("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, "not venomous");
        String expResult = "Reptilia";
        String result = instance.getclassName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getorderName method, of class Species.
     */
    @Test
    public void testGetorderName() {
        System.out.println("getorderName");
        Species instance = new Species("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, "not venomous");
        String expResult = "Squamata";
        String result = instance.getorderName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getfamilyName method, of class Species.
     */
    @Test
    public void testGetfamilyName() {
        System.out.println("getfamilyName");
        Species instance = new Species("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, "not venomous");
        String expResult = "Boidae";
        String result = instance.getfamilyName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getgenusName method, of class Species.
     */
    @Test
    public void testGetgenusName() {
        System.out.println("getgenusName");
        Species instance = new Species("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, "not venomous");
        String expResult = "Boa";
        String result = instance.getgenusName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getspeciesName method, of class Species.
     */
    @Test
    public void testGetspeciesName() {
        System.out.println("getspeciesName");
        Species instance = new Species("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, "not venomous");
        String expResult = "Boa constrictor";
        String result = instance.getspeciesName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getnumLegs method, of class Species.
     */
    @Test
    public void testGetnumLegs() {
        System.out.println("getnumLegs");
        Species instance = new Species("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, "not venomous");
        Integer expResult = 0;
        Integer result = instance.getnumLegs();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAttribute method, of class Species.
     */
    @Test
    public void testGetAttribute() {
        System.out.println("getAttribute");
        Species instance = new Species("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, "not venomous");
        String expResult = "not venomous";
        String result = instance.getAttribute();
        assertEquals(expResult, result);

    }

}

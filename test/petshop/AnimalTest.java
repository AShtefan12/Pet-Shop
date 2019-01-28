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
public class AnimalTest {
    
    public AnimalTest() {
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
     * Test of setSoldDate method, of class Animal.
     */
    @Test
    public void testSetSoldDate() {
        System.out.println("setSoldDate");
        String soldDate = "2018-05-18";
        Animal instance = new Animal("Rabbit", "Ray", "10.20", "male", "red");
        instance.setSoldDate(soldDate);
        
        assertEquals(soldDate, instance.getSoldDate());
    }

    /**
     * Test of getCommonName method, of class Animal.
     */
    @Test
    public void testGetCommonName() {
        System.out.println("getCommonName");
        Animal instance = new Animal("Rabbit", "Ray", "10.20", "male", "red");
        String expResult = "Ray";
        String result = instance.getCommonName();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of getSoldDate method, of class Animal.
     */
    @Test
    public void testGetSoldDate() {
        System.out.println("getSoldDate");
        Animal instance = new Animal("Rabbit", "Ray", "10.20", "male", "red", "2018-04-12", "2018-05-18");
        String expResult = "2018-05-18";
        String result = instance.getSoldDate();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getGivenName method, of class Animal.
     */
    @Test
    public void testGetGivenName() {
        System.out.println("getGivenName");
        Animal instance = new Animal("Rabbit", "Ray", "10.20", "male", "red");
        String expResult = "Rabbit";
        String result = instance.getGivenName();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of getPetSex method, of class Animal.
     */
    @Test
    public void testGetPetSex() {
        System.out.println("getPetSex");
        Animal instance = new Animal("Rabbit", "Ray", "10.20", "male", "red");
        String expResult = "male";
        String result = instance.getPetSex();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getPetColor method, of class Animal.
     */
    @Test
    public void testGetPetColor() {
        System.out.println("getPetColor");
        Animal instance = new Animal("Rabbit", "Ray", "10.20", "male", "red");
        String expResult = "red";
        String result = instance.getPetColor();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getPetPrice method, of class Animal.
     */
    @Test
    public void testGetPetPrice() {
        System.out.println("getPetPrice");
        Animal instance = new Animal("Rabbit", "Ray", "10.20", "male", "red");
        double expResult = 10.20;
        double result = instance.getPetPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getArrivalDate method, of class Animal.
     */
    @Test
    public void testGetArrivalDate() {
        System.out.println("getArrivalDate");
        Animal instance = new Animal("Rabbit", "Ray", "10.20", "male", "red","2018-04-12");
        String expResult = "2018-04-12";
        String result = instance.getArrivalDate();
        assertEquals(expResult, result);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Alexander
 */
public class Animal {

    private String commonName;
    private String soldDate = "";
    private String givenName;
    private String petSex;
    private String petColor;

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }
    private double petPrice;
    private String arrivalDate;
   
    public Animal(String givenName, String commonName , String petPrice, String petSex, String petColor) {
        this.commonName = commonName;
        this.givenName = givenName;
        this.petSex = petSex;
        this.petColor = petColor;
        this.petPrice = Double.parseDouble(petPrice);
        this.arrivalDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }

    public Animal(String givenName, String commonName , String petPrice, String petSex, String petColor,String arrivalDate) {
       this(givenName,commonName,petPrice,petSex,petColor);
       this.arrivalDate = arrivalDate;
    }
    
    public Animal(String givenName, String commonName , String petPrice, String petSex, String petColor,String arrivalDate,String soldDate) {
       this(givenName,commonName,petPrice,petSex,petColor,arrivalDate);
       this.soldDate = soldDate;
    }

    Animal(String[] array) {
       this.commonName = array[1];
       
    }

    public String getCommonName() {
        return commonName;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getPetSex() {
        return petSex;
    }

    public String getPetColor() {
        return petColor;
    }

    public double getPetPrice() {
        return petPrice;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

}

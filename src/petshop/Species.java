/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

/**
 *
 * @author Alexander
 */
public class Species {
    private String givenName;
    private String className;
    private String orderName;
    private String familyName;
    private String genusName;
    private String speciesName;
    private int numLegs;
    private String attribute;

    public Species(String givenName, String className, String orderName, String familyName, String genusName, String speciesName, int numLegs) {
        this.givenName = givenName;
        this.className = className;
        this.orderName = orderName;
        this.familyName = familyName;
        this.genusName = genusName;
        this.speciesName = speciesName;
        this.numLegs = numLegs;
        this.attribute = "";
    }

    public Species(String givenName, String className, String orderName, String familyName, String genusName, String speciesName, int numLegs, String attribute) {
        this(givenName, className, orderName, familyName, genusName, speciesName, numLegs);
        this.attribute = attribute;
    }

    public String getgivenName() {
        return givenName;
    }

    public String getclassName() {
        return className;
    }

    public String getorderName() {
        return orderName;
    }

    public String getfamilyName() {
        return familyName;
    }

    public String getgenusName() {
        return genusName;
    }

    public String getspeciesName() {
        return speciesName;
    }

    public Integer getnumLegs() {
        return numLegs;
    }
    
    public String getAttribute() {
        return attribute;
    }
}

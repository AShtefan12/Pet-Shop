package petshop;

public class Reptile extends Species {
    private Boolean isVenomous;

    public Reptile(String givenName, String className, String orderName, String familyName, String genusName, String speciesName, Integer numLegs, Boolean isVenomous) {
        super(givenName, className, orderName, familyName, genusName, speciesName, numLegs);
        this.isVenomous = isVenomous;
    }

    public Boolean getVenomous() {
        return isVenomous;
    }
}

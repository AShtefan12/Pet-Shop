
package petshop;

/**
 *
 * @author Alexander
 */
public class Parrot extends Animal {

    private String isTalking;

//    public Parrot(String commonName, String isTalking) {
//        super(commonName);
//        this.isTalking = isTalking;
//    }

    public Parrot(String givenName, String commonName, String petPrice, String petSex, String petColor) {
        super(givenName, commonName, petPrice, petSex, petColor);
    }
}

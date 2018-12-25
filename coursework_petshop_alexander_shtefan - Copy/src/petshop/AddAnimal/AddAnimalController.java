/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.AddAnimal;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import petshop.Animal;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class AddAnimalController implements Initializable {

    @FXML
    private AnchorPane submit;
    @FXML
    private TextField givenName;
    @FXML
    private TextField commonName;
    @FXML
    private TextField petPrice;
    @FXML
    private TextField petSex;
    @FXML
    private TextField petColor;
    @FXML
    private DatePicker arrivalDate;
    @FXML
    private DatePicker soldDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddAnimal(ActionEvent event) {
        
        if (givenName.getText().isEmpty() || commonName.getText().isEmpty() || petPrice.getText().isEmpty() || petSex.getText().isEmpty() || petColor.getText().isEmpty()){
            
            return;
        }

        Stage stage = (Stage) submit.getScene().getWindow();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.now();

        String arrivaldate = localDate.format(formatter);
        if (arrivalDate.getValue() != null) {

            arrivaldate = arrivalDate.getValue().format(formatter);
        }

        String solddate = "";
        if (soldDate.getValue() != null) {

            solddate = soldDate.getValue().format(formatter);

        }

        Animal animal = new Animal(givenName.getText(), commonName.getText(), petPrice.getText(), petSex.getText(), petColor.getText(), arrivaldate, solddate);

        petshop.PetShop.pets.add(animal);

       
        stage.close();

    }

}

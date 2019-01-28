/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.Search;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import petshop.Animal;
import petshop.Species;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class SearchController implements Initializable {

    @FXML
    private TableView<Animal> mainTable;
    @FXML
    private TableColumn<Animal, String> givenColumn;
    @FXML
    private TableColumn<Animal, String> commonColumn;
    @FXML
    private TableColumn<Animal, String> priceColumn;
    @FXML
    private TableColumn<Animal, String> sexColumn;
    @FXML
    private TableColumn<Animal, String> colorColumn;
    @FXML
    private TableColumn<Animal, String> arrivalColumn;
    @FXML
    private TableColumn<Animal, String> soldColumn;
    @FXML
    private TextField givenName;
    @FXML
    private TextField commonName;
    @FXML
    private TextField petSex;
    @FXML
    private TextField petColor;
    @FXML
    private TextField className;
    @FXML
    private TextField genusName;
    @FXML
    private TextField orderName;
    @FXML
    private TextField familyName;
    @FXML
    private TextField speciesName;
    @FXML
    private TextField minLegs;
    @FXML
    private TextField maxLegs;
    @FXML
    private ComboBox<String> property;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        givenColumn.setCellValueFactory(new PropertyValueFactory<>("givenName"));
        commonColumn.setCellValueFactory(new PropertyValueFactory<>("commonName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("petPrice"));
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("petSex"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("petColor"));
        arrivalColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        soldColumn.setCellValueFactory(new PropertyValueFactory<>("soldDate"));

        mainTable.setItems(petshop.PetShop.pets);

        TableColumn<Animal, Boolean> sellingColumn = new TableColumn<>("Sell");

        sellingColumn.setSortable(false);

        sellingColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Animal, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Animal, Boolean> features) {
                return new SimpleBooleanProperty(features.getValue() != null && features.getValue().getSoldDate().isEmpty());
            }
        });

        sellingColumn.setCellFactory(new Callback<TableColumn<Animal, Boolean>, TableCell<Animal, Boolean>>() {
            @Override
            public TableCell<Animal, Boolean> call(TableColumn<Animal, Boolean> animalBooleanTableColumn) {
                return new SellAnimalCell(mainTable);
            }
        });

        mainTable.getColumns().add(sellingColumn);

        property.getItems().setAll("", "venomous", "not venomous", "talking", "not talking");

    }

    @FXML
    private void propertySearch(ActionEvent event) {
        commonSearch();
    }

    private void commonSearch() {

        FilteredList<Animal> filteredData = new FilteredList<>(petshop.PetShop.pets, p -> true);

        filteredData.setPredicate(animal -> {

            if (!animal.getGivenName().toLowerCase().contains(givenName.getText().toLowerCase())) {
                return false;
            }
            if (!animal.getCommonName().toLowerCase().contains(commonName.getText().toLowerCase())) {
                return false;
            }
            if (!animal.getPetSex().toLowerCase().contains(petSex.getText().toLowerCase())) {
                return false;
            }
            if (!animal.getPetColor().toLowerCase().contains(petColor.getText().toLowerCase())) {
                return false;
            }
            Species species = null;
            for (Species s : petshop.PetShop.species) {
                if (s.getgivenName().toLowerCase().equals(animal.getCommonName().toLowerCase())) {
                    species = s;
                }
            }
            if (!species.getclassName().toLowerCase().contains(className.getText().toLowerCase())) {
                return false;
            }
            if (!species.getorderName().toLowerCase().contains(orderName.getText().toLowerCase())) {
                return false;
            }
            if (!species.getfamilyName().toLowerCase().contains(familyName.getText().toLowerCase())) {
                return false;
            }
            if (!species.getgenusName().toLowerCase().contains(genusName.getText().toLowerCase())) {
                return false;
            }
            if (!species.getspeciesName().toLowerCase().contains(speciesName.getText().toLowerCase())) {
                return false;
            }
            if (!minLegs.getText().isEmpty() && species.getnumLegs() < Integer.parseInt(minLegs.getText())) {
                return false;
            }
            if (!maxLegs.getText().isEmpty() && species.getnumLegs() > Integer.parseInt(maxLegs.getText())) {
                return false;
            }
            if (property.getValue() != null && !species.getAttribute().toLowerCase().contains(property.getValue().toLowerCase())) {
                return false;
            }
            return true;
        });

        SortedList<Animal> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(mainTable.comparatorProperty());

        mainTable.setItems(sortedData);
    }

    @FXML
    private void search(KeyEvent event) {
        commonSearch();
    }

    @FXML
    private void legsearch(KeyEvent event) {
        commonSearch();
    }

    private static class SellAnimalCell extends TableCell<Animal, Boolean> {

        final Button cellButton = new Button("Sell");

        SellAnimalCell(final TableView tblView) {

            cellButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    int selectedIndex = getTableRow().getIndex();

                    Animal animal = petshop.PetShop.pets.get(selectedIndex);

                    animal.setSoldDate(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
                    
                    petshop.PetShop.pets.set(selectedIndex, animal);

                    tblView.setItems(petshop.PetShop.pets);

                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                if (t) {
                    setGraphic(cellButton);
                } else {
                    Button soldButton = new Button("Sold");
                    soldButton.setDisable(true);
                    setGraphic(soldButton);
                }
            }
        }

    }

}

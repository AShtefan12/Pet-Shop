/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Alexander
 */
public class PetShop extends Application {

    public static ObservableList<Animal> pets = FXCollections.observableArrayList();
    public static ArrayList<Species> species = new ArrayList();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getSpeciesData();
        launch(args);
    }

    public static void getSpeciesData() {
        species.add(new Species("Dog", "Mammalia", "Carnivora", "Canidae", "Canis", "Canis lupus", 4));
        species.add(new Species("Cat", "Mammalia", "Carnivora", "Felidae", "Felis", "Felis silvestris", 4));
        species.add(new Species("Rabbit", "Mammalia", "Lagomorpha", "Leporidae", "Oryctolagus", "Oryctolagus cuniculus", 4));
        species.add(new Species("Golden Hamster", "Mammalia", "Rodentia", "Cricetidae", "Mesocricetus", "Mesocricetus auratus", 4));
        species.add(new Species("Roborovski Hamster", "Mammalia", "Rodentia", "Cricetidae", "Phodopus", "Phodopus roborovskii", 4));
        species.add(new Species("Guinea Pig", "Mammalia", "Rodentia", "Caviidae", "Cavia", "Cavia porcellus", 4));
        species.add(new Species("Edwards's Fig Parrot", "Aves", "Psittaciformes", "Psittaculidae", "Psittaculirostris", "Psittaculirostris edwardsii", 2, "not talking"));
        species.add(new Species("Norwegian Blue", "Aves", "Psittaciformes", "Psittacidae", "Mopsitta", "Mopsitta tanta", 2, "talking"));
        species.add(new Species("Hyacinth Macaw", "Aves", "Psittaciformes", "Psittacidae", "Anodorhynchus", "Anodorhynchus hyacinthinus", 2, "talking"));
        species.add(new Species("Yellow Canary", "Aves", "Passeriformes", "Fringillidae", "Crithagra", "Crithagra flaviventris", 2));
        species.add(new Species("Goldfish", "Actinopterygii", "Cypriniformes", "Cyprinidae", "Carassius", "Carassius auratus", 0));
        species.add(new Species("Koi", "Actinopterygii", "Cypriniformes", "Cyprinidae", "Cyprinus", "Cyprinus rubrofuscus", 0));
        species.add(new Species("Common Barbel", "Actinopterygii", "Cypriniformes", "Cyprinidae", "Barbus", "Barbus barbus", 0));
        species.add(new Species("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, "not venomous"));
        species.add(new Species("Corn Snake", "Reptilia", "Squamata", "Colubridae", "Pantherophis", "Pantherophis guttatus", 0, "not venomous"));
        species.add(new Species("Black-necked Spitting Cobra", "Reptilia", "Squamata", "Elapidae", "Naja", "Naja nigricollis", 0, "venomous"));

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Alexander
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane Anchorpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddAnimals(ActionEvent event) {

        FileChooser Choose = new FileChooser();
        File file = Choose.showOpenDialog(Anchorpane.getScene().getWindow());

        if (file == null) {
            return;
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] array = line.split(", ");
                if (array.length == 5) {
                    Animal animal = new Animal(array[0], array[1], array[2], array[3], array[4]);
                    PetShop.pets.add(animal);
                } else if (array.length == 6) {
                    Animal animal = new Animal(array[0], array[1], array[2], array[3], array[4], array[5]);
                    PetShop.pets.add(animal);
                } else {
                    Animal animal = new Animal(array[0], array[1], array[2], array[3], array[4], array[5], array[6]);
                    PetShop.pets.add(animal);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void WriteAnimals(ActionEvent event) {

        FileChooser Choose = new FileChooser();
        File file = Choose.showSaveDialog(Anchorpane.getScene().getWindow());

        if (file == null) {
            return;
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));

            ObservableList<Animal> sortedList = PetShop.pets;

            Collections.sort(sortedList, new Comparator<Animal>() {
                @Override
                public int compare(Animal t, Animal t1) {
                    if (t1.getSoldDate().isEmpty() && t.getSoldDate().isEmpty()) {
                        return t.getArrivalDate().compareTo(t1.getArrivalDate());
                    }
                    return t1.getSoldDate().compareTo(t.getSoldDate());
                }
            });

            for (Animal animal : sortedList) {

                bw.write(animal.getGivenName() + ", " + animal.getCommonName() + ", " + animal.getPetPrice() + ", " + animal.getPetSex() + ", " + animal.getPetColor() + ", " + animal.getArrivalDate());
                if (!animal.getSoldDate().isEmpty()) {
                    bw.write(", " + animal.getSoldDate());
                }
                bw.newLine();

            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }

    }

    @FXML
    private void AddAnimal(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/petshop/AddAnimal/AddAnimal.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add your animal");
            stage.setScene(new Scene(root, 900, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ComputeRevenue(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/petshop/ComputeRevenue/ComputeRevenue.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Compute revenue for set day or month");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Search(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/petshop/Search/Search.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Search");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



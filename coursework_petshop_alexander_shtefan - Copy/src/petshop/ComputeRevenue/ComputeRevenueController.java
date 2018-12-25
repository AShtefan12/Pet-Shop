/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.ComputeRevenue;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.monthName;
import java.awt.geom.Arc2D;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class ComputeRevenueController implements Initializable {

    @FXML
    private ComboBox<String> specMonth;
    @FXML
    private ComboBox<String> specYear;
    @FXML
    private DatePicker specDate;
    @FXML
    private Label result;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String[] yearStrings = new String[100];
        for (int i = 0; i < 100; i++) {
            yearStrings[i] = String.valueOf(2018 - i);
        }
        specYear.getItems().setAll(yearStrings);

        String[] monthStrings = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
        };

        specMonth.getItems().setAll(monthStrings);

    }

    @FXML
    private void Reset(ActionEvent event) {

        specMonth.setValue(null);
        specYear.setValue(null);
        specDate.setValue(null);
        result.setText("");
    }

    @FXML
    private void revenue(ActionEvent event) {

        if (specDate.getValue() != null) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String date = specDate.getValue().format(formatter);

            double sellPrice = petshop.PetShop.pets.stream().filter((t) -> {
                return date.equals(t.getSoldDate());
            }).mapToDouble((t) -> {
                return t.getPetPrice(); 
            }).sum();

            result.setText("£ " + String.valueOf(sellPrice));

        } else if (specMonth.getValue() != null && specYear.getValue() != null) {
            String monthName = specMonth.getValue();

            Date date;
            try {
                date = new SimpleDateFormat("MMMM").parse(monthName);
            } catch (ParseException ex) {
                return;
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            String yearMonth = specYear.getValue() + "-" + (cal.get(Calendar.MONTH) +1);

            double sellPrice = petshop.PetShop.pets.stream().filter((t) -> {

                return t.getSoldDate().contains(yearMonth); //To change body of generated lambdas, choose Tools | Templates.
            }).mapToDouble((t) -> {
                return t.getPetPrice(); //To change body of generated lambdas, choose Tools | Templates.
            }).sum();

            result.setText("£ " + String.valueOf(sellPrice));

        }

    }

}

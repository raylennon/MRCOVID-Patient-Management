import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class ViewController {

    @FXML
    private AnchorPane homepane;
    @FXML
    private AnchorPane pane1;
    @FXML
    private AnchorPane pane2;
    @FXML
    private AnchorPane pane3;
    @FXML
    private AnchorPane pane4;
    @FXML
    private AnchorPane pane5;
    @FXML
    private AnchorPane updatelanding;
    @FXML
    private AnchorPane updatepane;

    @FXML
    TextField searchName;

    @FXML
    private void handleButtonClick(ActionEvent event) {


        Button source = (Button) event.getSource();

        if (!(source.getId().equals("search") && !updateFields())) {

            homepane.setVisible(false);
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            updatelanding.setVisible(false);
            updatepane.setVisible(false);

            switch (source.getId()) {
                case "button1" -> pane1.setVisible(true);
                case "button2" -> pane2.setVisible(true);
                case "button3" -> pane3.setVisible(true);
                case "button4" -> pane4.setVisible(true);
                case "button5" -> pane5.setVisible(true);
                case "homebutton" -> homepane.setVisible(true);
                case "updatebutton" -> updatelanding.setVisible(true);
                case "search" -> {
                    updateFields();
                    updatepane.setVisible(true);
                }
                default -> System.out.println("idk");
            }
        }
    }

    @FXML
    TextField firstentry;
    @FXML
    TextField lastentry;
    @FXML
    TextField DOBentry;
    @FXML
    TextField addressentry;
    @FXML
    TextField cityentry;
    @FXML
    TextField stateentry;
    @FXML
    TextField zipcodeentry;
    @FXML
    TextField emailentry;
    @FXML
    TextField phoneentry;
    @FXML
    CheckBox symptomentry;
    @FXML
    CheckBox firsttestentry;

    @FXML
    private boolean updateFields() {
        if (!searchName.getText().equals("")) {
            ArrayList<Patient> Patients = home.getPatients();
            for (Patient indiv : Patients) {
                if (indiv.first.equals(searchName.getText())) {
                    firstentry.setText(indiv.first);
                    lastentry.setText(indiv.last);
                    DOBentry.setText(indiv.birth);
                    addressentry.setText(indiv.address);
                    cityentry.setText(indiv.city);
                    stateentry.setText(indiv.state);
                    zipcodeentry.setText(Integer.toString(indiv.zip));
                    emailentry.setText(indiv.email);
                    phoneentry.setText(indiv.phone);
                    symptomentry.setSelected(indiv.symptoms);
                    return true;
                }
            } return false;

        } else {
            return false;
        }

    }
}
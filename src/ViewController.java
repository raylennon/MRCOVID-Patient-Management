import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

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
    private void handleButtonClick(ActionEvent event) {

        Button source = (Button) event.getSource();
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
            case "search" -> updatepane.setVisible(true);
            default -> System.out.println("idk");
        }
        // etc...
    }
}
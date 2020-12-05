import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ViewController {

    @FXML
    private Button button1 ;

    @FXML
    private Button button2 ;

    @FXML
    private Button button3 ;

    @FXML
    private Button button4 ;

    @FXML
    private Button button5 ;

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
    private void handleButtonClick(ActionEvent event) {

        Button source = (Button) event.getSource();
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(false);
        pane4.setVisible(false);

        switch (source.getId()) {
            case "button1" -> pane1.setVisible(true);
            case "button2" -> pane2.setVisible(true);
            case "button3" -> pane3.setVisible(true);
            case "button4" -> pane4.setVisible(true);
            case "button5" -> pane5.setVisible(true);
            default -> System.out.println("idk");
        }
        // etc...
    }
}
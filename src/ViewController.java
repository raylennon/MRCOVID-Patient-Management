import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

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

    public void initialize() {
        // initialization here, if needed...
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        // I really don't recommend using a single handler like this,
        // but it will work
        //System.out.println("does this work???");
        Button source = (Button) event.getSource();

        switch (source.getId()) {
            case "button1":
                System.out.println("Button 1");
                break;
            case "button2":
                System.out.println("Button 2");
                break;
            case "button3":
                System.out.println("Looks like 3");
                break;
            case "button4":
                System.out.println("Button 4");
                break;
            case "button5":
                System.out.println("Probably 5");
                break;
            default:
                System.out.println("idk");
        }
        // etc...
    }
}
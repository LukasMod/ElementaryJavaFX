package Main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
   // void setStage (Stage stage) {this.stage = stage;}

    @FXML
    Label labelText;
    @FXML
    Button button1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelText.setText("Program wystartował");
    }

    public void buttonClicked() { labelText.setText("Button został kliknięty"); }

public static void closeProgram () {
    Platform.exit();
    System.exit(0);
}
}

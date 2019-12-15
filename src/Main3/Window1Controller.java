package Main3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Window1Controller implements Initializable {

    @FXML
    Label label1;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setValue(String pParam) {
        label1.setText(pParam);
    }

}

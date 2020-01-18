package MainZP17;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField textField;
    @FXML
    private Label labelName;
    @FXML
    private Button buttonWrite;

    private Person person = new Person();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        textField.setText(person.getName());
//        labelName.setText(person.getName());
        textField.textProperty().bindBidirectional(person.getPropertyTextField());
        labelName.textProperty().bind(person.getPropertyTextField());
    }

    public void write() {
        System.out.println(person.getIntegerProperty().get());
        System.out.println(person.getIntegerProperty().getValue());
//        labelName.setText(textField.getText());
//        person.setName(textField.getText());
    }
}

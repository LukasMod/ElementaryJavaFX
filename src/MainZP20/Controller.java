package MainZP20;

import com.sun.javafx.geom.BaseBounds;
import com.sun.security.jgss.GSSUtil;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {


    @FXML
    private TextField nameTextField;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Label surnameLabel;

    @FXML
    private TextField yearTextField;

    @FXML
    private CheckBox confirmCheckBox;

    @FXML
    private Label ageLabel;

    @FXML
    private Button logginButton;

    private BooleanProperty checkBoxProperty = new SimpleBooleanProperty();
    private Object ObservableValue;

    @FXML
    public void initialize() {
        confirmCheckBox.selectedProperty().bindBidirectional(checkBoxProperty);

        nameTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                //observableValue to ten sam ym co textProperty
                System.out.println("Old Value " + s);
                System.out.println("New Value " + t1);
                //czyszczenie pola "lastname" po wymazaniu "name" - czyszczenie pól
                if (t1.isEmpty()) {
                    surnameTextField.setText("");
                }

            }
        });

        surnameTextField.focusedProperty().addListener(((observableValue, aBoolean, t1) -> {
            if (t1) {
                System.out.println("Your are in field Lastname");
            } else {
                System.out.println("You were in Field Lastname");
            }
        }));
        //druga metoda podpinania Listenera  (zaczyna się od metody yearTextFieldListener)
        yearTextField.textProperty().addListener(Controller::yearTextFieldListener);


        checkBoxProperty.addListener(((observableValue, aBoolean, t1) -> {
            if (t1) {
                System.out.println("Checked");
            } else {
                System.out.println("Unchecked");
            }

        }));
    }

    private static void yearTextFieldListener(ObservableValue<? extends String> observableValue,
                                              String oldValue, String newValue) {
        System.out.println("Here: " + observableValue);
        System.out.println("New Value: " + newValue);
    }
}

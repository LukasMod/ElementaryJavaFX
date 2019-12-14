package Main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    // void setStage (Stage stage) {this.stage = stage;}

    @FXML
    Label labelText;
    @FXML
    Button button1;
    @FXML
    TextField textField1;
    @FXML
    RadioButton radioBwoman;
    @FXML
    RadioButton radioBman;
    @FXML
    CheckBox checkBclickMe;

    static ToggleGroup tg;


    @Override
    public void initialize(URL location, ResourceBundle resources) {   //ustawia pierwsze wartości
        labelText.setText("Program started");
        button1.setGraphic(new ImageView("Main/cancel.png"));
        //radioBwoman.setToggleGroup(tg);
        // radioBman.setToggleGroup(tg);
        List<RadioButton> rbList = new ArrayList<>();
        rbList.add(radioBwoman);
        rbList.add(radioBman);
        MainWindowController.prepareRadioButtons(rbList);

       /* checkBclickMe.setAllowIndeterminate(true);   //ustawienie stanu niokreślonego
        System.out.println(checkBclickMe.isSelected()); //sprawdza stan checkboxa
*/
        checkBclickMe.setSelected(true); //domyślna wartość checkBoxa
    }

    public void buttonClicked() {   //procedury po kliknięciu
        String txtFromTextField = textField1.getText();
        labelText.setText("Button was clicked and " + txtFromTextField);
        textField1.setText("");
        textField1.setDisable(true);
    }

    private static void prepareRadioButtons(List<RadioButton> rbList) {
        tg = new ToggleGroup();
        for (RadioButton rb : rbList) {
            rb.setToggleGroup(tg);
        }
    }

    public void radioClicked() {
        RadioButton selectedRB = (RadioButton) tg.getSelectedToggle();
        //potrzebne rzutowanie, bo oczekujemy RadioButton
        String clickedId = selectedRB.getId();
        String clickedLabel = selectedRB.getText();
        textField1.setText("Id: " + clickedId + ", Nazwa: " + clickedLabel);
    }

    public void checkBoxclicked() {
        boolean checked = checkBclickMe.isSelected();

        if (checked) {
            textField1.clear();
            textField1.appendText(" CheckBox is selected");
        } else {
            textField1.clear();
            textField1.appendText(" CheckBox is NOT selected");
        }

    }

    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }
}

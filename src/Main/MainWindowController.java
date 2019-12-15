package Main;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

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

    static Label lbl;
    static ComboBox combo;
    static ToggleGroup tg;
    static String[] daysWeek = {"monday", "tuesday", "wednesday", "friday", "saturday", "sunday"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {   //ustawia pierwsze wartości
        labelText.setText("Program started");
        button1.setGraphic(new ImageView("Main/cancel.png"));
        //radioBwoman.setToggleGroup(tg);     //używamy listy ArrayList, zamiast tego
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

    public static void getDaysWeek() {
        if (combo.getValue().toString() != null) {
            lbl.setText(combo.getValue().toString());
        }
    }

    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }

    public static void addControls(StackPane stackPane) {
        lbl = new Label();
        lbl.setText("Testing");
        StackPane.setMargin(lbl, new Insets(280, 10, 10, 10));
        stackPane.getChildren().add(lbl);


//      PIERWSZY SPOSÓB DODAWANIA COMBOBOX Z LISTĄ + ODCZYTYWANIE WARTOŚCI
//        ObservableList<Cars> carsList = FXCollections.observableArrayList(
//                new Cars("FI", "Fiat"),
//                new Cars("FO", "Ford"),
//                new Cars("ME", "Mercedes"),
//                new Cars("VW", "Volkswagen")
//        );
//        combo = new ComboBox(carsList);
//        //odczytanie wartości z combo
//        combo.getSelectionModel().selectedItemProperty().addListener(
//                new ChangeListener<Cars>() {
//                    @Override
//                    public void changed(ObservableValue<? extends Cars> observableValue, Cars cars, Cars t1) {
//                        if (t1 != null) {
//                            if (cars != null) {
//                                lbl.setText(t1.getName() + "(" + t1.getCode() + ") Previous value: " + cars.getName());
//                            } else {
//                                lbl.setText(t1.getName() + "(" + t1.getCode() + ")");
//                            }
//                        }
//                    }
////                    @Override
////                    public void changed(ObservableValue observableValue, Object o, Object t1) {
////                    }
//                }
//        );
        combo = new ComboBox(FXCollections.observableArrayList(daysWeek));
        combo.setOnAction(event -> MainWindowController.getDaysWeek());


        StackPane.setMargin(combo, new Insets(230, 10, 10, 10));
        stackPane.getChildren().add(combo);
    }


}

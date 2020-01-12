package Main6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Button b1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //można deklarować @FXML zamiast public/private
    @FXML
    //okienko wyświetlające stacktrace wymuszonego błędu
    void showDialogWindow(ActionEvent event) {
        // Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // Alert alert = new Alert(Alert.AlertType.WARNING); //zmiana typu alertu
        Alert alert = new Alert(Alert.AlertType.ERROR); //zmiana typu alertu
        alert.setTitle("Info");
        //alert.setHeaderText("Header"); //nagłówek - zmiana nazwy
        alert.setHeaderText(null); //nagłówek - brak nagłówka (null albo "")
        alert.setContentText("Test dialog window");

        //symulacja błędu, aby wyświtlić stacktrace

        Exception ex = new FileNotFoundException("Nie odnaleziona pliku");
        StringWriter s = new StringWriter();
        try (PrintWriter p = new PrintWriter(s)) {
            ex.printStackTrace(p);
        }
        String exText = s.toString(); //konwersja na String

        Label l = new Label("Excepion");
        TextArea txtArea = new TextArea(exText);
        txtArea.setEditable(false);
        txtArea.setWrapText(true);

        txtArea.setMaxWidth(Double.MAX_VALUE);
        txtArea.setMaxHeight(Double.MAX_VALUE);

        GridPane.setVgrow(txtArea, Priority.ALWAYS);
        GridPane.setHgrow(txtArea, Priority.ALWAYS);

        GridPane exceptionComponent = new GridPane();
        exceptionComponent.setMaxWidth(Double.MAX_VALUE);
        exceptionComponent.add(l, 0, 0);
        exceptionComponent.add(txtArea, 0, 1);

        //wyświetlamy zawartosc zwinieta, ale pozwala na rozwiniecie
        alert.getDialogPane().setExpandableContent(exceptionComponent);

        alert.showAndWait(); //okienko oczeukuje na naszą reakcję

    }

    @FXML
        //okienko z kilkoma opcjami wyboru
    void showDialogWindow2(ActionEvent event) {
//
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //zmiana typu alertu
//        alert.setTitle("Info");
//        alert.setHeaderText("");
//        alert.setContentText("Do you like me?");
//
//        ButtonType one = new ButtonType("Yes");
//        ButtonType two = new ButtonType("No");
//        ButtonType three = new ButtonType("I don't know");
//        //do 4 przycisku dodajemy funkcjonalność - ma wyłączać (będzie po prawej odsunięty)
//        ButtonType buttonCancel = new ButtonType("I won't tell you", ButtonBar.ButtonData.CANCEL_CLOSE);
//
//        alert.getButtonTypes().setAll(one, two, three, buttonCancel); //kolejność przycisków
//
//
//        Optional<ButtonType> res = alert.showAndWait();
//        //musimy sprawdzić czy res nie jest 'nullem'
//        if (res.isPresent()) {
//            if ((res.get() == one)) {
//                System.out.println("Nice");
//            } else if (res.get() == two) {
//                System.out.println("I'm so sorry");
//            } else if (res.get() == three) {
//                System.out.println("Think about it again");}
//            else {
//                System.out.println("I think you need more time");
//            }
//        }
    }

    @FXML
        //okienko do przekazywania wartości
    void showDialogWindow3(ActionEvent event) {
        TextInputDialog tid = new TextInputDialog("");
        tid.setTitle("Your name");
        tid.setHeaderText("");
        tid.setContentText("Type your name");

        //String, ponieważ interesuje nas odebranie właśnie łańcucha znaków
        Optional <String> res = tid.showAndWait();
        if (res.isPresent()) {
            System.out.println("Hi " + res.get());
        }

        //drugi sposób na odebranie info
        res.ifPresent(name -> System.out.println("Hi " + name));
    }

}

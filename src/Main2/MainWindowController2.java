package Main2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController2 implements Initializable {

  public static  Stage window1;

    @FXML
   static Button buttonWindow1, buttonWindow2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //Pierwszy sposób na drugie okno
    public void openWindow1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("window1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        window1 = new Stage();
        window1.setTitle("Window 1");
        window1.setResizable(false);  //uniemożliwienie zmiany rozmiaru
        window1.setScene(scene);
        window1.show();

    }


    public void closeWindow1() {
        window1 = (Stage) window1.getScene().getWindow();
        window1.close();
    }


    // druga opcja otwierania okna (dodatkowa klasa)
    public void openWindow2() throws IOException {
        Window2 w2 = new Window2();
        w2.openWindow2();
    }


    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }

}

package Main2;

import javafx.application.Platform;
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

  public static  Stage stage;

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
        stage = new Stage();
        stage.setTitle("Window 1");
        stage.setResizable(false);  //uniemożliwienie zmiany rozmiaru
        stage.setScene(scene);
        stage.show();
        Button buttonWindow1 = new Button();
        buttonWindow1.setOnAction(Event -> MainWindowController2.closeWindow1());

    }


    public static void closeWindow1() {
        stage = (Stage) buttonWindow1.getScene().getWindow();
        stage.close();
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

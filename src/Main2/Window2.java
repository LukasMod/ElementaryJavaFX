package Main2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Window2 implements Initializable {

    Stage window2Stage;

    @FXML
    Button buttonClose;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    //metoda która bedzie otwierac nam okno 2 - drugi sposob
    public void openWindow2 () throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("window2.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            window2Stage = new Stage();
            window2Stage.setTitle("Window 2");
            window2Stage.initModality(Modality.APPLICATION_MODAL);  //okno staje się modalne
            //window2Stage.setResizable(false);  //uniemożliwienie zmiany rozmiaru
            window2Stage.setScene(scene);
            window2Stage.show();
        }
        //zamykanie okna
    public void closeWindow (){
        window2Stage = (Stage) buttonClose.getScene().getWindow();
        window2Stage.close();
        //pobierz id sceny, nastepnie dla tej sceny pobierz mi okno
        //w ten sposób przycisk wie, o które okno chodzi
    }


    }

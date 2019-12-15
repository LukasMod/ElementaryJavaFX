package Main3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController3 implements Initializable {

    @FXML
    Button buttonWindow3;

    @FXML
    TextField textField1, textField2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void openWindow() throws IOException {

        Stage pStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        StackPane stackPane = fxmlLoader.load(getClass().getResource("window.fxml").openStream());
        Window1Controller controller = (Window1Controller) fxmlLoader.getController();

        controller.setValue(textField1.getText() + " " + textField2.getText());

        Scene scene = new Scene(stackPane);
        pStage = new Stage();
        pStage.setTitle("Window");
        pStage.setResizable(false);
        pStage.setScene(scene);
        pStage.show();

    }


//    public void closeWindow() {
//        pStage = (Stage) pStage.getScene().getWindow();
//        pStage.close();
//    }

    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }

}

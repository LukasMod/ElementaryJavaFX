package MainSP6.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    public StackPane mainStackPane;

    @FXML
    public void initialize() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlFiles/MenuScreen.fxml"));
        Pane pane = null;

      //To poniżej psuje,  ... ?

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStackPane.getChildren().add(pane);

        // ... ?
    }
}

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
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/MainSP6/fxmlFiles/menuScreenWindow.fxml"));
        Pane pane = null;

        try {
           pane = loader2.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

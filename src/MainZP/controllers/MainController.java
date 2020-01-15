package MainZP.controllers;

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
        loadMenuScreen();
    }

    public void loadMenuScreen() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MenuScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //aby zmieniac pane'y, bedziemy sie tu odwolywac do innych okien np MenuScreen,AppScreen i je wstrzykiwać
        MenuController menuController = loader.getController();  //wyciąga referencje kontrolera
        menuController.setMainController(this);

        setScreen(pane);
    }

    //metoda ułatwiajaca zmiane pane'a
    public void setScreen(Pane pane) {
        mainStackPane.getChildren().clear(); //czysci okno
        mainStackPane.getChildren().add(pane); //dodaje kontener
    }
}
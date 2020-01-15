package MainZP.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {

    private MainController mainController;

    @FXML
    public void openApplication() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AppScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppController appController = loader.getController(); //przekazanie appControllera do MainControllera
        appController.setMainController(mainController);

        mainController.setScreen(pane);
    }
    public void openOptions() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/OptionsScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OptionsController optionsController = loader.getController();
        optionsController.setMainController(mainController);
        mainController.setScreen(pane);
    }

    public void exit() {
        Platform.exit();
        System.exit(0);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

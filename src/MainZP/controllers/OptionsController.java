package MainZP.controllers;

import javafx.fxml.FXML;

public class OptionsController {
    private MainController mainController; //niezbędne żeby w menuController się odwołać

    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

package Main2;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

public class MenuUtilities2 {
    public static MenuBar prepareMenu() {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem fileClose = new MenuItem("Close");
        fileClose.setGraphic(new ImageView("Main2/cancel.png"));
        fileClose.setOnAction(actionEvent -> MainWindowController2.closeProgram());


        fileMenu.getItems().add(fileClose);
        menuBar.getMenus().add(fileMenu);




        return menuBar;
    }
}

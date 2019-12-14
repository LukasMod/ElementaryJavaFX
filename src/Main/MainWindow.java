package Main;

import MenuUtil.MenuUtilities;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("MainWindow.fxml"));

        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);

        MainWindowController controller = (MainWindowController) loader.getController();
       // controller.setStage(primaryStage); //brakuje czegoś w klasie MainWindowController

        stackPane.getChildren().add(MenuUtilities.prepareMenu()); //dodaje menu (za pomocą javy)
        stackPane.setAlignment(Pos.TOP_LEFT); //umieszczamy menu bar w lewym górnym rogu

      /*   dodawanie pola tekstowego za pomocą Javy
       TextField txt = new TextField();
        txt.setId("text01");
        txt.setMaxWidth(400);
        txt.setMinWidth(200);
        StackPane.setMargin(txt, new Insets(120,10,10,10));
        txt.setDisable(true);   //wyłączenie pola tekstowego

        stackPane.getChildren().add(txt);
*/

        primaryStage.setHeight(600);
        primaryStage.setWidth(900);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        primaryStage.getIcons().add(new Image("/Main/money.png"));
        primaryStage.setOnCloseRequest((e) -> {MainWindowController.closeProgram();});
        primaryStage.setScene(scene);
        primaryStage.setTitle("Projekt okno");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

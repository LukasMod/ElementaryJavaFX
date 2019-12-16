package Main4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainWindow4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("mainWindow4.fxml"));

        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);


        stackPane.getChildren().add(MenuUtilities4.prepareMenu());
        stackPane.setAlignment(Pos.TOP_LEFT);

        primaryStage.getIcons().add(new Image("/Main4/money.png"));
        primaryStage.setOnCloseRequest((e) -> {
            MainWindowController4.closeProgram();
        });
        primaryStage.setHeight(600);
        primaryStage.setWidth(900);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Project window");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

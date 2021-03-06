package MainSP6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("fxmlFiles/mainScreenWindow.fxml"));
        StackPane stackPane = loader.load();

        Scene scene = new Scene(stackPane, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Flow Example");
        stage.show();

    }
}

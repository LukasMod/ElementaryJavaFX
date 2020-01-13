package Main7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Controller c = (Controller) loader.getController();
        c.setStage(stage);

        stage.setTitle("Dialog Windows lvl2");
        stage.setScene(new Scene(root));
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}

package Main5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();

        StackPane stackPaneTop = MainWindowController.stackPaneTop(); //tworzymy obiekt stackpane i wskazujemy lokalizacje
        borderPane.setTop(stackPaneTop);  // StackPane do BorderPane

        StackPane stackPaneLeft = MainWindowController.stackPaneLeft(); //tworzymy obiekt stackpane i wskazujemy lokalizacje
        BorderPane.setMargin(stackPaneLeft, new Insets(2, 2, 2, 2)); //marinesy całego stackPane
        borderPane.setLeft(stackPaneLeft);  // StackPane do BorderPane

        StackPane stackPaneBottom = MainWindowController.stackPaneBottom(); //tworzymy obiekt stackpane i wskazujemy lokalizacje
        BorderPane.setMargin(stackPaneBottom, new Insets(2, 2, 2, 2)); //marinesy całego stackPane
        borderPane.setBottom(stackPaneBottom);  // StackPane do BorderPane

        StackPane stackPaneCenter = MainWindowController.stackPaneCenter(); //tworzymy obiekt stackpane i wskazujemy lokalizacje
        BorderPane.setMargin(stackPaneCenter, new Insets(2, 2, 2, 2)); //marinesy całego stackPane
        borderPane.setCenter(stackPaneCenter);  // StackPane do BorderPane


        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Window - only Java code");
        primaryStage.setOnCloseRequest(windowEvent -> MainWindowController.closeProgram());
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

}

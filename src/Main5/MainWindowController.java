package Main5;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }

    private static MenuBar prepareMenu() {
        MenuBar menu = new MenuBar();
        Menu menuFile = new Menu("File");  //sekcja w menu
        MenuItem exitMenuItem = new MenuItem("Exit");

        exitMenuItem.setOnAction(actionEvent -> MainWindowController.closeProgram());  //wywołanie kliknięciem
        //dodajemy grafikę do pozycji w menu
        exitMenuItem.getStyleClass().add("exitMenuItemStyle");


        //składamy teraz naze klocki w odwrotnej kolejności
        menuFile.getItems().add(exitMenuItem);
        menu.getMenus().add(menuFile);

        return menu; //musi zwrócić nasz obiekt
    }

    public static StackPane stackPaneTop() {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_LEFT);  //orientacja
        stackPane.getChildren().add(MainWindowController.prepareMenu()); //dodaje menu do stackPane
        Button b1 = new Button("B1 Close");  //przycisk
        b1.setOnAction(actionEvent -> MainWindowController.closeProgram()); //przypisanie akcji do przycisku
        StackPane.setMargin(b1, new Insets(25, 0, 0, 2));  //umiejscowienie przycisku b1
        stackPane.getChildren().add(b1);  //dodanie przycisku
        //b1.getStyleClass().add("exitMenuItemStyle"); metoda jak dla Menu nie działa

        return stackPane;  //musi zwrócić nasz obiekt

    }

//deleted from Main:
//    public static StackPane stackPaneLeft() {
//        StackPane stackPane = new StackPane();
//        stackPane.setAlignment(Pos.TOP_LEFT);  //orientacja
//        //obrysowanie przycisku: kolor, styl, zaokrąglone rogi (promień zagięcia w pikselach),
//        stackPane.setBorder(new Border(new BorderStroke(Color.DARKGOLDENROD, BorderStrokeStyle.DASHED, new CornerRadii(5), BorderWidths.DEFAULT)));
//        stackPane.setPadding(new Insets(4, 4, 4, 4)); //wewnętrzne marginesy w stackPane
//
//        Button b1 = new Button("Button StackPane Left");  //przycisk
//        b1.setPrefWidth(150);
//        stackPane.getChildren().add(b1);  //dodanie przycisku
//
//        Button b2 = new Button("Button Small");  //przycisk
//        stackPane.getChildren().add(b2);  //dodanie przycisku
//        StackPane.setMargin(b2, new Insets(25, 0, 0, 2));  //umiejscowienie przycisku b1
//
//        return stackPane;  //musi zwrócić nasz obiekt
//    }

    public static StackPane stackPaneBottom() {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_LEFT);  //orientacja
        //obrysowanie przycisku: kolor, styl, zaokrąglone rogi (promień zagięcia w pikselach),
        stackPane.setBorder(new Border(new BorderStroke(Color.DARKORANGE, BorderStrokeStyle.DOTTED, new CornerRadii(1), BorderWidths.DEFAULT)));
        stackPane.setPadding(new Insets(4, 4, 4, 4)); //wewnętrzne marginesy w stackPane

        Button b1 = new Button("Button Bottom");  //przycisk
        b1.setPrefWidth(150);
        stackPane.getChildren().add(b1);  //dodanie przycisku

        MainWindowController controller = new MainWindowController();

        b1.getStyleClass().add("myButton"); //dodaje styl do przycisku
        b1.setGraphic(controller.loadImage());

        return stackPane;  //musi zwrócić nasz obiekt
    }

    //metoda wczytująca grafikę
    private ImageView loadImage() {
        Image icon = new Image(getClass().getResourceAsStream("../images/cancel.png")); // ../oznacza katalog niżej
        ImageView imageIcon = new ImageView(icon);
        return imageIcon;
    }

    public static StackPane stackPaneCenter() {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_LEFT);  //orientacja
        //obrysowanie przycisku: kolor, styl, zaokrąglone rogi (promień zagięcia w pikselach),
        stackPane.setBorder(new Border(new BorderStroke(Color.DARKORANGE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
        stackPane.setPadding(new Insets(4, 4, 4, 4)); //wewnętrzne marginesy w stackPane

        TextArea textArea = new TextArea();
        textArea.setWrapText(true); //zawijanie tekstu w polu tekstowym
        stackPane.getChildren().add(textArea);  //dodanie pola tekstowego

        return stackPane;  //musi zwrócić nasz obiekt
    }

}

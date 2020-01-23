package MainZP22;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private Tab1Controller tab1Controller;  //zmienna musi się nazywać fx::id z fxml + Controller!!
    @FXML
    private Tab2Controller tab2Controller;
//    @FXML
//    StackPane tab1;   //inny sposób odwołania
//    @FXML
//    StackPane tab2;

    @FXML
    public void change () {
        System.out.println("It is MainController");
//        System.out.println(tab1Controller);
//        System.out.println(tab2Controller);
//        System.out.println(tab1);
//        System.out.println(tab2);
        tab1Controller.setMessageTab1("Change message from MainController to Tab1");
        tab2Controller.setMessageTab2("Change message from MainController to Tab2");

    }

}

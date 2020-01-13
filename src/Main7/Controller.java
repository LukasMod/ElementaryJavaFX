package Main7;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    Stage stage;

    @FXML
    public Button b1, b2;
    @FXML
    TextField directoryPath, filePath;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    //wskazanie katalogu gdzie się znajduje pożądany plik/folder

    @FXML
    void showDialogWindowDirectory() { //okno dialogowe do wskazania katalogu

        try {
            DirectoryChooser dc = new DirectoryChooser();
            File selectedDir = dc.showDialog(getStage());
            //teraz musimy odczytać to co pobraliśmy. getStage, bo Stage jest właścicielem okna
            directoryPath.setText(selectedDir.toString());

        } catch (Exception e) {
//nic nie robimy w wyjątku
        }
    }

    public void showDialogWindowFile() { //okno dialogowe do wskazania pliku
try {

    FileChooser fc = new FileChooser();
    File selectedFile = fc.showOpenDialog(getStage()); //showOpen, ponieważ otwieramy do odczytu
    filePath.setText(selectedFile.toString());
    System.out.println(selectedFile.getName());  //zwraca TYLKO nazwę pliku


} catch (Exception e){
    //nic nie robimy w wyjątku
}




    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


}

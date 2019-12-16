package Main4;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController4 implements Initializable {

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> lastnameColumn;
    //wskazanie tabelek w kontrolerze ^^, następnie trzeba zainicjować

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //musimy "nauczyć" naszą tabelkę, co jest na co mapowane - co gdzie ma być wpisane
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        //na koniec pobieramy dane do tabeli
        tableView.setItems(downloadPerson());

    }

    //nasza "baza danych" - póki nie znamy baz
    public ObservableList<Person> downloadPerson() {
        ObservableList<Person> personList = FXCollections.observableArrayList();
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Stefan", "Burczymucha"));
        personList.add(new Person("Pingwin", "Szeregowy"));
        personList.add(new Person("Tadeusz", "Nowak"));
        return personList;
    }


    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }

}

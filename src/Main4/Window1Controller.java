package Main4;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Window1Controller implements Initializable {

    Stage stage; //potrzebny aby wskazać odpowiedni Stage funkcji
    TableView<Person> tableToChange; //zmienna pomocnicza
    int tabIndex = -1;

    @FXML private TextField nameEdit;
    @FXML private TextField lastnameEdit;
    @FXML private Button buttonSave;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setField(Person person, int rowIndex, TableView<Person> tableView) {
        tableToChange = tableView;  //odbieramy tabelkę, żeby się po niej poruszać
        //poniewaz mamy zmienna globalną, a chcemy na niej operować, bardziej eleganckie niż operacja na globalnej
        nameEdit.setText(person.getName());
        lastnameEdit.setText(person.getLastname());
        //indeks słuzy do przeslania np. do przeslania indeksu z tabeli z bazy danych
        tabIndex = rowIndex; //to przychodzić będzie jako numer wiersza z tabelki, ale można to powiązać z bazą danych

    }

    public void saveAndClose () {

        System.out.println(tabIndex); //drukuje w konsoli numer indeksu wybranego wiersza

        //bierzemy tableToChange, getItems, get(tabIndex) - pobieramy z tabelki tableToChange index wiersza do zmiany
        tableToChange.getItems().get(tabIndex).setName(nameEdit.getText());
        tableToChange.getItems().get(tabIndex).setLastname(lastnameEdit.getText());
        MainWindowController4 m = new MainWindowController4();
        m.reloadTable(tableToChange, tabIndex);


        stage = (Stage) buttonSave.getScene().getWindow(); //pozwoli zamknąć właściwe okno
        stage.close();
    }
    }


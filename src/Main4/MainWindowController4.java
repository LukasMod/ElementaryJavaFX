package Main4;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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

    @FXML
    private Label labelChosenPerson2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //musimy "nauczyć" naszą tabelkę, co jest na co mapowane - co gdzie ma być wpisane
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        //na koniec pobieramy dane do tabeli
        tableView.setItems(downloadPerson());
        //getClickedRow();
        getSelectedCell();
    }

    public void getClickedRow() {
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount() > 0) { //zlicza kliknięcia
                    if (tableView.getSelectionModel().getSelectedIndex() >= 0) {  //sprawdza czy tabela nie jest pusta w tym miejscu (np. nagłówek)
                        labelChosenPerson2.setText(tableView.getSelectionModel().getSelectedItem().getName()
                                + " " + tableView.getSelectionModel().getSelectedItem().getLastname());
                    }
                }
            }
        });
    }

    public void getSelectedCell(){
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); //tylko pojedyncza komorka zostanie zaznaczona po kliknieciu
        tableView.getSelectionModel().setCellSelectionEnabled(true); //zaznacza komórkę, którą będziemy klikać
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount() > 0) {
                    if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                        //odczytuje coś w rodzaju indeksu (pozycji komórki) tabeli. Na końcu '0', ponieważ odczytuej tylko 1 wiersz
                        TablePosition position = tableView.getSelectionModel().getSelectedCells().get(0);
                        //pobieramy numer wiersza
                        int row = position.getRow();
                        //odkrywamy co sie kryje pod numerem wiersza
                        //sięgnij po dane, ale z konkretnego wiersza i przypisujemy do osoby numer
                        Person p = tableView.getItems().get(row);
                        //bierzemy z pozycji kolumnę
                        TableColumn tableColumn = position.getTableColumn();
                        //z przecięcia kolumny i wiersza odczytujemy wartość i wrzucamy do łańcucha
                        String data = tableColumn.getCellObservableValue(p).getValue().toString();
                        labelChosenPerson2.setText(data);
                    }
                }
            }
        });
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

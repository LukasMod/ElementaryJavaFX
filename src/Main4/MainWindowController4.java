package Main4;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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

    @FXML
    private TextField nameInputText, lastnameInputText;
    @FXML
    private Button buttonAdd, buttonDelete;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //musimy "nauczyć" naszą tabelkę, co jest na co mapowane - co gdzie ma być wpisane
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        //na koniec pobieramy dane do tabeli
        tableView.setItems(downloadPerson());
        getClickedRow();
//        getSelectedCell();

        //włączamy obsługę dwukliknięcia (metoda edycji)
        //wskazujemy tabelkę, pozwalamy na edycję tabelki
        tableView.setEditable(true);

        //bierzemy kolumnę,wywoujemy setCellFactory, przekazujemy metodę
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());


    }

    //dodaje osobę wpisana w pola do tabelki
    public void addRowToTable() {
        //tworzenie obiektu wraz z wartościami pól
        Person newPerson = new Person(nameInputText.getText(), lastnameInputText.getText());
        //dodanie nowego obiektu do tabelki
        tableView.getItems().add(newPerson);
        //czyszczenie wartości w polach
        nameInputText.clear();
        lastnameInputText.clear();
    }

    //usuwanie wiersza
    public void deleteRow() {
        ObservableList<Person> choosenPerson, allPeople;
        try {  //potrzebne, aby nie wywalało wyjątku o ewentualnym braku wiersza
            //pobieramy do observablelist (ktora przechowuje obiekty Person)
            allPeople = tableView.getItems();
            if (allPeople.size() != 0) { //jesli tabelka nie jest pusta
                //sprawdz co zostało kliknite i przypisz zawartość wiersza
                choosenPerson = tableView.getSelectionModel().getSelectedItems();
                //weź wybrana osobę, przejdź sie po wszystkich osobach i jeśli dopasujesz - usuń
                //inne tłumaczenie:
                //wykonaj for each, znajdz wybrana osobe we wszystkich osobach,
                // i jesli wybrana osoba bedzie pasowala ze wszystkimi osobami - wywal z listy
                choosenPerson.forEach(allPeople::remove);
            }
        } catch (Exception e) {
            //tabelka jest pusta - nic nie rób
        }

    }

    //klikniecie i odczytanie zawartości całego wiersza
    public void getClickedRow() {
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() > 0) { //zlicza kliknięcia
                    if (tableView.getSelectionModel().getSelectedIndex() >= 0) {  //sprawdza czy tabela nie jest
                        // pusta w tym miejscu (np. nagłówek)
                        labelChosenPerson2.setText(tableView.getSelectionModel().getSelectedItem().getName()
                                + " " + tableView.getSelectionModel().getSelectedItem().getLastname());
                    }
                }
            }
        });
    }

    public void getSelectedCell() {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); //tylko pojedyncza komorka zostanie
        // zaznaczona po kliknieciu
        tableView.getSelectionModel().setCellSelectionEnabled(true); //zaznacza komórkę, którą będziemy klikać
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() > 0) {
                    if (tableView.getSelectionModel().getSelectedIndex() >= 0) {
                        //odczytuje coś w rodzaju indeksu (pozycji komórki) tabeli. Na końcu '0',
                        // ponieważ odczytuje tylko 1 wiersz
                        TablePosition position = tableView.getSelectionModel().getSelectedCells().get(0);
                        //pobieramy numer wiersza
                        int row = position.getRow();
                        //odkrywamy co sie kryje pod numerem wiersza
                        //sięgnij po dane, ale z konkretnego wiersza i przypisujemy do osoby numer
                        Person p = tableView.getItems().get(row);
                        //bierzemy z pozycji kolumnę
                        TableColumn tableColumn = position.getTableColumn();
                        //z przecięcia kolumny i wiersza odczytujemy wartość (obiektu - Person)
                        // i wrzucamy do łańcucha, przypisanie do zmiennej
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

    //obsługa podwójnego klinięcia i edycji komórki
    public void editCellName(TableColumn.CellEditEvent cellEditEvent) {
        Person personName = tableView.getSelectionModel().getSelectedItem(); //zwraca obiekt (osobę)
        //odbieramy event, to nowa wartość i rzutujemy na String
        personName.setName(cellEditEvent.getNewValue().toString());

        //dodajemy funkcjonalność, wypisuje w konsoli tabelę/wiersz po zmianie
        showTableAfterChange();
      //  showRowAfterChange(personName);

    }

    public void editCellLastname(TableColumn.CellEditEvent cellEditEvent) {
        Person personLastname = tableView.getSelectionModel().getSelectedItem();
        personLastname.setLastname(cellEditEvent.getNewValue().toString());

        //dodajemy funkcjonalność, wypisuje w konsoli tabelę/wiersz po zmianie
       // showTableAfterChange();
        showRowAfterChange(personLastname);

    }

    private void showTableAfterChange() {

        ObservableList<Person> personList = tableView.getItems();
        //teraz chciałbym osoby po zmianie wyświetlić
        for (Person p : personList) {
            System.out.println(p.getName() + " " + p.getLastname());
            //tutaj można dodać zapis do pliku. ale w tym przykładzie pokazujemy WSZYSTKIE wyniki (stąd FOR)
        }
    }

    private void showRowAfterChange(Person person) {  //musi być argument, bo już nie chcemy całości przeszukiwać
        System.out.println(person.getName() + " " + person.getLastname());

    }


    //Kończy działanie programu
    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }

}

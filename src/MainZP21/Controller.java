package MainZP21;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private ComboBox<Person> comboBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    //inicjujemy pierwszą listę
    private ObservableList<Person> personObservableList;
    //inny sposób dodania listy do comboBoxa
    private ListProperty<Person> listProperty;

    private Person person;  // w celu rozbudowy metody addPerson

    @FXML
    public void initialize() {

        //przekazywanie obiektów do listy
        List<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("John", "Rambo"));
        arrayList.add(new Person("James", "Bond"));
        arrayList.add(new Person("Indiana", "Jones"));
        arrayList.add(new Person("Robin", "Hood"));

        //dodanie utworzonej listy do ObservableList i dodanie do comboBoxa

//        personObservableList = FXCollections.observableArrayList(arrayList);
//        comboBox.getItems().addAll(personObservableList);

        // ^^^^ dodatkowo wykorzystuje przeciążenie toString z Person, aby ładnie wyświetalać w ComboBoxie
        //moglibyśmy też zrobić  comboBox.getItems().addAll(arrayList);
        //ale tracimy dostęp do metod, w tym bindowania

        //inna metoda z ListProperty
        listProperty = new SimpleListProperty<>();
        personObservableList = FXCollections.observableArrayList(arrayList);
        listProperty.set(personObservableList);
        comboBox.itemsProperty().bindBidirectional(listProperty); //zwykłej arrayListy bym nie mógł dodać
        //dzięki temu doszły nowe możliwości
        //  comboBox.getItems().addAll(personObservableList);  //opcja bez bindowania, nie dodaje z automatu do ComboBoxa

        personObservableList.addListener(this::onChange);
    }

    @FXML
    public void addPerson() {

        person = new Person(nameTextField.getText(), surnameTextField.getText());
        personObservableList.add(person);
        System.out.println(personObservableList);

    }

    @FXML
    public void deletePerson() {

        Person person = comboBox.getSelectionModel().getSelectedItem();
        personObservableList.remove(person);
        System.out.println(personObservableList);

    }

    // dodajemy Listenera
    private void onChange(Change change) {
        //sprawdza czy coś się usunęło lub zostało dodane

        while (change.next()) {
            if (change.wasRemoved()) {
                System.out.println("Something was deleted");
            } else if (change.wasAdded()) {
                System.out.println("Something was added");
            }
        }


    }

}

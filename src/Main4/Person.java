package Main4;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    private SimpleStringProperty name, lastname;   //bardzo ułatwia zmapowanie Stringów

    public Person(String name, String lastname) {
        this.name = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    @Override
    public String toString() {    //potrzebne aby wyświetlić wartość pobranego wiersza
        return name + " " + lastname;
    }
}

package MainZP17;

import javafx.beans.property.*;

public class Person {

    private StringProperty propertyTextField = new SimpleStringProperty(this, "nameProperty", "Jon Snow");
    private IntegerProperty integerProperty = new SimpleIntegerProperty(1111);
    private ReadOnlyStringWrapper propertyWrapper = new ReadOnlyStringWrapper(this, "readOnly", "Only Read");
    private ReadOnlyStringProperty readOnlyStringProperty = propertyWrapper.getReadOnlyProperty();

    public Person() {

        propertyWrapper.set("Still can change value");
        readOnlyStringProperty.get();  //nie ma metody set

    }


    public StringProperty getPropertyTextField() {
        return propertyTextField;
    }

    public void setPropertyTextField(StringProperty propertyTextField) {
        this.propertyTextField = propertyTextField;
    }


    public IntegerProperty getIntegerProperty() {
        return integerProperty;
    }

    public void setIntegerProperty(int integerProperty) {
        this.integerProperty.set(integerProperty);
    }
//    private String name = "Jon";
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}

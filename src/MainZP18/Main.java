package MainZP18;

import javafx.beans.binding.*;
import javafx.beans.property.*;

public class Main {

    public static void main(String[] args) {
    bindings();
    }

    public static void bindings() {
        DoubleProperty a = new SimpleDoubleProperty(3.0);
        IntegerProperty b = new SimpleIntegerProperty(4);

        System.out.println("COUNTING");
        System.out.println(a.doubleValue() + "   and   " + b.intValue());

        NumberBinding resultAdd = a.add(b);
        System.out.println("add  " + resultAdd.intValue());

        NumberBinding resultSub = a.subtract(b);
        System.out.println("subtract  " + resultSub.longValue());

        DoubleBinding resultDiv = a.divide(b);
        System.out.println("divide  " + resultDiv.doubleValue());

        NumberBinding resultMultiply = a.multiply(b);
        System.out.println("multiply  " + resultMultiply.longValue());

        NumberBinding resultNegate = a.negate();
        System.out.println("negation of 'a'  " + resultNegate.intValue());

        System.out.println("\nCONDITIONS");

        BooleanBinding resultEqual = a.isEqualTo(b);
        System.out.println("Is 'a' equals to 'b'? "  + resultEqual.get());
        System.out.println("Czy A jest nierówna B: " + a.isNotEqualTo(b).get());
        System.out.println("Czy A większa niż B: " + a.greaterThan(b).get());
        System.out.println("Czy A większa lub równa niż B: " + a.greaterThanOrEqualTo(b).get());
        System.out.println("Czy A jest mniejsza niż B: " + a.lessThan(b).get());
        System.out.println("Czy A jest mniejsza lub równa B: " + a.lessThanOrEqualTo(b).get());

        System.out.println("\n działania na stringach");

        StringProperty s1 = new SimpleStringProperty("Test ");
        StringProperty s2 = new SimpleStringProperty("is ");
        StringProperty s3 = new SimpleStringProperty("great");

        StringExpression se = (s1).concat(s2).concat(s3);
        System.out.println(se.get());
        System.out.println("\n CLASS WHEN");
        StringBinding resultWhen = new When(a.lessThan(b)).then("Smaller").otherwise("Bigger");
        System.out.println(resultWhen.get());

        BooleanBinding resultBoolean = new When(a.lessThan(b).and(b.lessThan((10)))).then(true).otherwise(false);
        System.out.println("Wynik spawdzenia: " + resultBoolean.get());

//        System.out.println("\nFormater");
//        DoubleProperty longDouble = new SimpleDoubleProperty(2.33423432423);
//        StringExpression output = Bindings.format("Format liczny double: (%.2f)", longDouble);
//        System.out.println(output.get());
    }
}

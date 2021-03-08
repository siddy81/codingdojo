package task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clothing extends Product {
  /*  Schreiben Sie eine Unterklasse Clothing, die die Klasse Product erweitert.
  Die Unterklasse muss über zusätzliche
    Attribute für die Größe (int) und das Material (String) haben. Die neuen Attribute sollen im
    Konstruktor initialisiert werden, wie die anderen Attribute name, description und price, sowie in der
    Methode toString() die Ausgabe übersteuern.*/

    private int size;
    private String material;
}

package task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String name;
    private String description;
    private BigDecimal price;

    public final BigDecimal getPriceWithTax() {
        return BigDecimal.valueOf(1.19).multiply(price).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

    public String toString() {
        return name + " _ " + description + " _ " + price + " EUR";
    }
}
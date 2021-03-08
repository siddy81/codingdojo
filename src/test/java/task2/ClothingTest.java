package task2;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class ClothingTest {

    Clothing tshirt;

    @BeforeMethod
    public void setUp() {
        tshirt = Clothing.builder()
                .size(10)
                .price(BigDecimal.valueOf(25.1680))
                .material("Baumwolle")
                .name("T-Shirt")
                .description("Es ist ein tolles T-Shirt")
                .build();
    }

    @Test
    public void firstTestAfterSetup() {
        Assert.assertEquals(tshirt.getSize(), 10);
        Assert.assertEquals(tshirt.getPrice().doubleValue(), 25.168);
        Assert.assertEquals(tshirt.getPriceWithTax(), BigDecimal.valueOf(29.95));
        Assert.assertEquals(tshirt.getMaterial(), "Baumwolle");
        Assert.assertEquals(tshirt.getName(), "T-Shirt");
        Assert.assertEquals(tshirt.getDescription(), "Es ist ein tolles T-Shirt");
        Assert.assertEquals(tshirt.toString(), "T-Shirt _ Es ist ein tolles T-Shirt _ 25.168 EUR");

    }

    @Test
    public void testAfterUsingSetter() {
        tshirt.setSize(11);
        Assert.assertEquals(tshirt.getSize(), 11);

        tshirt.setMaterial("tolle Baumwolle");
        Assert.assertEquals(tshirt.getMaterial(), "tolle Baumwolle");

        tshirt.setPrice(BigDecimal.valueOf(10.0420));
        Assert.assertEquals(tshirt.getPrice(), BigDecimal.valueOf(10.0420));

        tshirt.setPrice(BigDecimal.valueOf(10.0420));
        Assert.assertEquals(tshirt.getPriceWithTax(), BigDecimal.valueOf(11.95));

        tshirt.setMaterial("Seide");
        Assert.assertEquals(tshirt.getMaterial(), "Seide");

        tshirt.setName("Pulli");
        Assert.assertEquals(tshirt.getName(), "Pulli");

        tshirt.setDescription("abc");
        Assert.assertEquals(tshirt.getDescription(), ("abc"));

        Assert.assertEquals(tshirt.toString(), "Pulli _ abc _ 10.042 EUR");
    }

}
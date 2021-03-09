package task3;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Base64;

public class ConvertingDataTest {

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"A", Base64.getEncoder().encodeToString("A".getBytes())},
                {"AB", Base64.getEncoder().encodeToString("AB".getBytes())},
                {"test input", Base64.getEncoder().encodeToString("test input".getBytes())},
                {"https://www.bundesdruckerei.de/de/maurer-electronics-hamburg", Base64.getEncoder().encodeToString("https://www.bundesdruckerei.de/de/maurer-electronics-hamburg".getBytes())},
                {"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. ", Base64.getEncoder().encodeToString("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. ".getBytes())}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testEncodeToBase64(String inputString, String expectedString) {
        Assert.assertEquals(ConvertingData.stringToBase64(inputString), expectedString);
    }

    @Test(dataProvider = "dataProvider")
    public void testDecodeFromBase64(String expectedString, String inputString) {
        Assert.assertEquals(ConvertingData.base64ToString(inputString), expectedString);
    }



}
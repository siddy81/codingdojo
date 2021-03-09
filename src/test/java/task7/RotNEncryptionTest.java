package task7;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RotNEncryptionTest {

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {0,"Hello, World","Hello, World"},
                {3,"A","D"},
                {3,"Hello, World","Khoor, Zruog"},
                {13,"Hello, World","Uryyb, Jbeyq"},
                {13,"W","J"},

        };
    }

    @Test(dataProvider = "dataProvider")
    public void testCipher(int n, String inputString, String expectedString) {
        Assert.assertEquals(RotNEncryption.cipher(n, inputString), expectedString);
    }

    @Test(dataProvider = "dataProvider")
    public void testDecipher(int n, String expectedString, String inputString) {
        Assert.assertEquals(RotNEncryption.decipher(n, inputString), expectedString);
    }
}
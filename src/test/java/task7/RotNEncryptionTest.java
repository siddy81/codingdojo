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
                {13,"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
                        "Yberz vcfhz qbybe fvg nzrg, pbafrgrghe fnqvcfpvat ryvge, frq qvnz abahzl rvezbq grzcbe vaivqhag hg ynober rg qbyber zntan nyvdhlnz reng, frq qvnz ibyhcghn. Ng ireb rbf rg npphfnz rg whfgb qhb qbyberf rg rn erohz. Fgrg pyvgn xnfq thoretera, ab frn gnxvzngn fnapghf rfg Yberz vcfhz qbybe fvg nzrg. Yberz vcfhz qbybe fvg nzrg, pbafrgrghe fnqvcfpvat ryvge, frq qvnz abahzl rvezbq grzcbe vaivqhag hg ynober rg qbyber zntan nyvdhlnz reng, frq qvnz ibyhcghn. Ng ireb rbf rg npphfnz rg whfgb qhb qbyberf rg rn erohz. Fgrg pyvgn xnfq thoretera, ab frn gnxvzngn fnapghf rfg Yberz vcfhz qbybe fvg nzrg."},

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
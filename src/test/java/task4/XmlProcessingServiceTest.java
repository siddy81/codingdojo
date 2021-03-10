package task4;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlProcessingServiceTest {

    private static final String givenXml = "<?xml version = \"1.0\"?>\n" +
            "<dojo>\n" +
            "   <codingDojo task = \"1\">\n" +
            "        <taskName>Objects</taskName>\n" +
            "     \n" +
            "   </codingDojo>\n" +
            "   \n" +
            "   <codingDojo task = \"2\">\n" +
            "      <taskName>Inheritance</taskName>\n" +
            "     \n" +
            "   </codingDojo>\n" +
            "   \n" +
            "   <codingDojo task = \"3\">\n" +
            "         <taskName>Converting Data</taskName>      \n" +
            "   </codingDojo>\n" +
            "   \n" +
            "   <codingDojo task = \"4\">\n" +
            "         <taskName>XML Processing</taskName>\n" +
            "   </codingDojo> \n" +
            "</dojo>";

    XmlProcessingService xmlProcessing;

    @BeforeMethod
    public void init() {
        xmlProcessing = new XmlProcessingService();
    }

    @Test
    public void testReadXML() throws ParserConfigurationException, SAXException, IOException {

        XmlResponse xmlResponse = xmlProcessing.parseXml(givenXml);

        Assert.assertNotNull(xmlResponse);
        NodeList dojo = xmlResponse.getXmlDocument().getElementsByTagName("dojo");
        NodeList dojoTasks = xmlResponse.getXmlDocument().getElementsByTagName("codingDojo");

        Assert.assertEquals(dojo.getLength(), 1);
        Assert.assertEquals(dojoTasks.getLength(), 4);

        Assert.assertEquals(dojoTasks.item(0).getChildNodes().item(1).getNodeName(), "taskName");
        Assert.assertEquals(dojoTasks.item(0).getChildNodes().item(1).getTextContent(), "Objects");
        Assert.assertEquals(dojoTasks.item(1).getChildNodes().item(1).getTextContent(), "Inheritance");
        Assert.assertEquals(dojoTasks.item(2).getChildNodes().item(1).getTextContent(), "Converting Data");
        Assert.assertEquals(dojoTasks.item(3).getChildNodes().item(1).getTextContent(), "XML Processing");

    }
}
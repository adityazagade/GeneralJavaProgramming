import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class sampleTransformer {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Test/src/main/resources/test.xml"));
            // ...
            StreamSource styleSource = new StreamSource(new File("Test/src/main/resources/test1.xsl"));
            TransformerFactory factory1 = TransformerFactory.newInstance();
            Transformer transformer = factory1.newTransformer(styleSource);
            Source text = new DOMSource(document);
            StringWriter writer = new StringWriter();
            StreamResult rslt = new StreamResult(writer);
            transformer.transform(text, rslt);
            String jsonString = writer.toString();
            jsonString = jsonString.replace("\\", "\\\\");
            System.out.println(jsonString);
        } catch (TransformerException | ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

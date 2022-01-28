import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

public class XML_to_JSON {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String a = "<RemoteAudits version=\"1.0\" sessionId=\"505gw3RVEMUvWvUNtrlwJ4d1556EJUX1mllAomTspol3\" foreign-name=\"http://10.85.107.31:8080\">" +
                "<Audits v=\"1.0\">" +
                "<FileTransfer type=\"42\">C:\\Users\\ksharma\\OneDrive - PTC\\Desktop\\file_transfer_remote_session\\file_upload_kunal\\temp_to_delete\\folder_upload</FileTransfer>" +
                "</Audits>" +
                "</RemoteAudits>";

        String b = "<RemoteAudits version=\"1.0\" sessionId=\"505gw3RVEMUvWvUNtrlwJ4d1556EJUX1mllAomTspol3\" foreign-name=\"http://10.85.107.31:8080\">" +
                "<Audits v=\"1.0\">" +
                "<FileTransfer type=\"40\">C:\\Users\\ksharma\\OneDrive - PTC\\Desktop\\file_transfer_remote_session\\file_upload_kunal\\temp_to_delete</FileTransfer>" +
                "</Audits>" +
                "</RemoteAudits>";

        String c = "<RemoteAudits version=\"1.0\" sessionId=\"505gw3RVEMUvWvUNtrlwJ4d1556EJUX1mllAomTspol3\" foreign-name=\"http://10.85.107.31:8080\">" +
                "<Audits v=\"1.0\">" +
                "<FileTransfer type=\"40\">C:\\Users\\ksharma\\OneDrive - PTC\\Desktop\\file_transfer_remote_session\\file_upload_kunal\\temp_to_delete</FileTransfer>" +
                "</Audits>" +
                "</RemoteAudits>";

        String d = "<RemoteAudits version=\"1.0\" sessionId=\"7b0156b0-1b49-4e01-8e82-4e163beb5f82\" foreign-name=\"http://localhost:8080\">" +
                "    <Audits>" +
                "        <SessionInfo type=\"16\">1614699415218</SessionInfo>" +
                "        <SessionInfo type=\"17\">1614699527545</SessionInfo>" +
                "        <SessionInfo type=\"23\">1</SessionInfo>" +
                "        <SessionInfo type=\"9\">127.0.0.1</SessionInfo>" +
                "        <SessionInfo type=\"15\">127.0.0.1</SessionInfo>" +
                "    </Audits>" +
                "</RemoteAudits>";

        String e = "<RemoteAudits version=\"1.0\" sessionId=\"b182d4a2-76f7-43ee-bf18-e58232f06178\" foreign-name=\"http://localhost:8080\">" +
                "<Audits>" +
                "<General type=\"0\">Session determined to be inactive and will be terminated</General>" +
                "</Audits>" +
                "</RemoteAudits>";
        
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        JsonArray genArr = new JsonArray();
        JsonArray sesArr = new JsonArray();
        JsonArray ftArr = new JsonArray();

        list.forEach(s -> {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                InputSource inputSource = new InputSource(new StringReader(s));
                Document document = builder.parse(inputSource);
                // ...
                StreamSource styleSource = new StreamSource(new File("Test/src/main/resources/convertor.xsd"));
                TransformerFactory factory1 = TransformerFactory.newInstance();
                Transformer transformer = factory1.newTransformer(styleSource);
                Source text = new DOMSource(document);
                StringWriter writer = new StringWriter();
                StreamResult rslt = new StreamResult(writer);
                transformer.transform(text, rslt);
                String jsonString = writer.toString();
                jsonString = jsonString.replace("\\", "\\\\");
//                System.out.println(jsonString);

                JsonParser parser = new JsonParser();
                JsonObject o = parser.parse(jsonString).getAsJsonObject();
//                System.out.println(o.keySet().size());

                o.keySet().forEach(s1 -> {
                    switch (s1) {
                        case "FileTransfer": {
                            ftArr.add(o.get(s1));
                            break;
                        }
                        case "SessionInfo": {
                            sesArr.add(o.get(s1));
                            break;
                        }
                        case "General":
                        default: {
                            genArr.add(o.get(s1));
                            break;
                        }
                    }
                });
            } catch (TransformerException | ParserConfigurationException | IOException | SAXException exp) {
                exp.printStackTrace();
            }
        });

        JsonObject gasInfo = new JsonObject();
        if (genArr.size() > 0) {
            JsonObject generalAudit = new JsonObject();
            generalAudit.add("remoteSessions", genArr);
            gasInfo.add("generalAudit", generalAudit);
        }
        if (sesArr.size() > 0) {
            JsonObject audit = new JsonObject();
            audit.add("remoteSessions", sesArr);
            gasInfo.add("audit", audit);
        }
        if (ftArr.size() > 0) {
            JsonObject fileTransferAudit = new JsonObject();
            fileTransferAudit.add("remoteSessions", ftArr);
            gasInfo.add("fileTransferAudit", fileTransferAudit);
        }
//                System.out.println(o.toString());
//                if(s.contains("<FileTransfer") && s.contains("</FileTransfer>")) {
//                    System.out.println();
//                }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(gasInfo.toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);

    }
}

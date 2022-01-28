import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import model.AuditEntry;
import model.RemoteAuditData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Testing {
    public final List<RemoteAuditData> storage = new ArrayList<>();

    public static void main(String[] args) {
        Testing t = new Testing();
        String data1 = "<Audits v=\"1.0\">" + "<FileTransfer type=\"2\">C:\\Users\\ksharma\\OneDrive - PTC\\Desktop\\file_transfer_remote_session\\file_upload_kunal\\temp_to_delete\\folder_upload</FileTransfer>" + "</Audits>";
        String data2 = "<RemoteAudits version=\"1.0\" sessionId=\"b182d4a2-76f7-43ee-bf18-e58232f06178\" foreign-name=\"http://localhost:8080\"><Audits><General type=\"0\">Session determined to be inactive and will be terminated</General></Audits></RemoteAudits>";
        DOMParser parser = new DOMParser();
        try {
            parser.parse(new InputSource(new StringReader(data1)));
        } catch (SAXException | IOException saxException) {
            saxException.printStackTrace();
        }
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();

        System.out.println(root.getLocalName());
        System.out.println(root.getTagName());
        System.out.println(root.getNodeName());

        t.addAudit("b182d4a2-76f7-43ee-bf18-e58232f06178", "1.0", root);
//        t.addAudit(data2);
        System.out.println(t.storage.size());
    }

    public void addAudit(String serverSessionId, String version, Element element) {
        //Element element has to be Audits elem
        if (element.getNodeName() == "Audits") {

//        NodeList auditList = element.getElementsByTagName("Audits");
//        if (auditList.getLength() > 0) {
            String foreignName = "http://localhost:8080";
//            for (int i = 0; i < auditList.getLength(); i++) {
//                Node n = auditList.item(i);
            Node n = element;
            NodeList tagList = n.getChildNodes();
            if (tagList.getLength() > 0) {
                RemoteAuditData remoteAuditData = new RemoteAuditData(serverSessionId, foreignName, version);
                String elemType;
                for (int k = 0; k < tagList.getLength(); k++) {
                    int type = Integer.parseInt(((Element) tagList.item(k)).getAttribute("type"));
                    String value = tagList.item(k).getTextContent();
                    elemType = tagList.item(k).getNodeName();
                    System.out.println(String.format("%s %s %s", type, elemType, value));
                    remoteAuditData.addAuditEntry(new AuditEntry(type, value));
                    remoteAuditData.setAuditType(elemType);
                }
                //needs to be synchronized.
                storage.add(remoteAuditData);
            }
        }
    }
//        }
//    }

    public void addAudit(String data) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(data));
            Document document = builder.parse(inputSource);
            Element remoteAuditElement = document.getDocumentElement();
            String sessionId = remoteAuditElement.getAttribute("sessionId");
            String version = remoteAuditElement.getAttribute("version");

            NodeList auditNodeList = document.getElementsByTagName("Audits");
            for (int i = 0; i < auditNodeList.getLength(); i++) {
                addAudit(sessionId, version, (Element) auditNodeList.item(i));
//            addAudit(sessionId, version, remoteAuditElement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
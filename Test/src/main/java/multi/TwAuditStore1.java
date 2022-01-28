package multi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import model.AuditEntry;
import model.RemoteAuditData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TwAuditStore1 {
    private final ArrayList<RemoteAuditData> transferred = new ArrayList<>();
    private final List<RemoteAuditData> storage = new ArrayList<>();
    private final TwPlatform platform;

    public TwAuditStore1(TwPlatform platform) {
        this.platform = platform;
    }

    public void addAudit(String data) {
        System.out.println("addAudit(String data) called in " + Thread.currentThread().getName());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(data));
            Document document = builder.parse(inputSource);
            Element remoteAuditElement = document.getDocumentElement();
            String sessionId = remoteAuditElement.getAttribute(RemoteAuditor.SESSION_ID_ATTRIBUTE);
            String version = remoteAuditElement.getAttribute(RemoteAuditor.VERSION_ATTRIBUTE);

            NodeList auditNodeList = remoteAuditElement.getElementsByTagName(RemoteAuditor.AUDITS_ELEMENT);
            for (int i = 0; i < auditNodeList.getLength(); i++) {
                addAudit(sessionId, version, (Element) auditNodeList.item(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAudit(String serverSessionId, String version, Element element) {
        //Element element has to be Audits elem
        if (element.getNodeName().equals(RemoteAuditor.AUDITS_ELEMENT)) {
            String foreignName = "localhost:8080";
            NodeList tagList = element.getChildNodes();
            if (tagList.getLength() > 0) {
                RemoteAuditData remoteAuditData = new RemoteAuditData(serverSessionId, foreignName, version);
                String elemType;
                for (int k = 0; k < tagList.getLength(); k++) {
                    if (tagList.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        int type = Integer.parseInt(((Element) tagList.item(k)).getAttribute(RemoteAuditor.MESSAGE_TYPE_ATTRIBUTE));
                        String value = tagList.item(k).getFirstChild().getNodeValue();
//                        String value = tagList.item(k).getTextContent();
                        elemType = (tagList.item(k)).getNodeName();
                        remoteAuditData.addAuditEntry(new AuditEntry(type, value));
                        remoteAuditData.setAuditType(elemType);
                    }
                }
                synchronized (this.storage) {
                    System.out.println("Adding to Storage: size before " + storage.size() + " :Thread: " + Thread.currentThread().getName());
                    this.storage.add(remoteAuditData);
                    this.platform.interrupt(); // Kick off an update...
                    System.out.println("Adding to Storage: size after " + storage.size() + " :Thread: " + Thread.currentThread().getName());
                }
            }
        }
    }

    public void flushStorage() {
//        System.out.println("Flushing storage: size= " + this.storage.size());
//        synchronized (this) {
//            if (this.storage.size() > 0) {
//                if (this.platform.sendDataToPlatform(this)) {
//                    this.storage.clear();
//                    this.transferred.clear();
//                } else {
//                    System.out.println("Flushing storage FAILED: size= " + this.storage.size());
//                }
//            }
//        }
    }

    public void removeTransferred() {
        System.out.println("Remove from storage: size= " + this.storage.size());
        synchronized (this) {
            if (this.storage.size() > 0) {
                this.storage.removeAll(transferred);
                transferred.clear();
            }
        }
    }

    public void clearTransferred() {
        synchronized (this.transferred) {
            transferred.clear();
        }
    }

    public boolean isEmpty() {
        return this.storage.isEmpty();
    }

    public JsonObject markTransferredAndGetJson(int sizeLimit) {
//        try {
        synchronized (this.transferred) {
            System.out.println("start making json " + Thread.currentThread().getName());
            JsonArray generalArr = new JsonArray();
            JsonArray sessionInfoArr = new JsonArray();
            JsonArray fileTransferArr = new JsonArray();
            int size = 0;
            synchronized (this.storage) {
                System.out.println("before iter began " + storage.size());
                for (RemoteAuditData remoteAuditData : storage) {
                    System.out.println("size " + storage.size());
                    JsonObject auditDataJson = remoteAuditData.toJson();
                    if (size + auditDataJson.toString().length() > sizeLimit) {
                        break;
                    }
                    transferred.add(remoteAuditData);
                    String auditType = remoteAuditData.getAuditType();
                    switch (auditType) {
                        case RemoteAuditor.SESSION_INFO_ELEMENT: {
                            sessionInfoArr.add(auditDataJson);
                            break;
                        }
                        case RemoteAuditor.FILE_TRANSFER: {
                            fileTransferArr.add(auditDataJson);
                            break;
                        }
                        case RemoteAuditor.GENERAL_ELEMENT:
                        default: {
                            generalArr.add(auditDataJson);
                            break;
                        }
                    }
                }
            }
            JsonObject auditData = new JsonObject();
            auditData.add(RemoteAuditor.GENERAL_ELEMENT, generalArr);
            auditData.add(RemoteAuditor.SESSION_INFO_ELEMENT, sessionInfoArr);
            auditData.add(RemoteAuditor.FILE_TRANSFER, fileTransferArr);
            System.out.println("End making json " + Thread.currentThread().getName());
            return auditData;
        }
//        } catch (Exception e) {
//            System.out.println("size in Exception" + storage.size());
//            e.printStackTrace();
//        }
//        return new JsonObject();
    }

}

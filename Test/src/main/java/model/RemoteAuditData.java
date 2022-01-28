package model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class RemoteAuditData {
    private final String sessionId;
    private final String foreignName;
    private final String auditVersion;
    private String auditType;
    private final List<AuditEntry> auditEntries = new ArrayList<>();

    public RemoteAuditData(String sessionId, String foreignName, String auditVersion) {
        this.sessionId = sessionId;
        this.foreignName = foreignName;
        this.auditVersion = auditVersion;
    }

    public void addAuditEntry(AuditEntry record) {
        auditEntries.add(record);
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getAuditType() {
        return auditType;
    }

    public JsonObject toJson() {
        JsonObject obj = new JsonObject();
        obj.addProperty(TwConstants.TW_AUDIT_SESSION_ID, sessionId);
        obj.addProperty(TwConstants.TW_AUDIT_AUDIT_VERSION, auditVersion);
        obj.addProperty(TwConstants.TW_AUDIT_FOREIGN_NAME, foreignName);
        JsonArray auditRecordsArr = new JsonArray();
        auditEntries.forEach(auditEntry -> auditRecordsArr.add(auditEntry.toJson()));
        obj.add(TwConstants.TW_AUDIT_AUDIT_RECORDS, auditRecordsArr);
        return obj;
    }
}

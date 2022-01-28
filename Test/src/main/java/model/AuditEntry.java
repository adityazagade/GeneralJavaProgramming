package model;

import com.google.gson.JsonObject;

public class AuditEntry {
    private final int type;
    private final String value;

    public AuditEntry(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public JsonObject toJson() {
        JsonObject obj = new JsonObject();
        obj.addProperty(TwConstants.TW_AUDIT_TYPE, type);
        obj.addProperty(TwConstants.TW_AUDIT_VALUE, value);
        return obj;
    }
}

package model;

public interface TwConstants {

    String TW_CONTENT_JSON = "application/json";
    String TW_APP_KEY_HEADER = "appKey";

    String TW_REGISTER_URI = "/Thingworx/Subsystems/RemoteAccessSubsystem/Services/RegisterExternalRemoteAccessServer";
    String TW_UNREGISTER_URI = "/Thingworx/Subsystems/RemoteAccessSubsystem/Services/UnregisterExternalRemoteAccessServer";
    String TW_UPDATE_URI = "/Thingworx/Subsystems/RemoteAccessSubsystem/Services/UpdateExternalRemoteAccessServerStatus";

    String TW_RAS_PARAMETERS = "rasParameters";
    String TW_RA_SERVER_NAME = "raServerName";
    String TW_RA_DESCRIPTION = "raDescription";
    String TW_RA_TYPE = "raServerType";
    String TW_CATEGORY = "category";
    String TW_HOSTNAME = "hostName";
    String TW_EXTERNAL_HOSTNAME = "externalHostName";
    String TW_ALTERNATE_HOST_NAME = "alternateHostName";
    String TW_PORT = "port";
    String TW_SSL_PORT = "sslPort";
    String TW_DIRECT_PORT = "directPort";
    String TW_DIRECT_SSL_PORT = "directSslPort";
    String TW_TIMEZONE = "timezoneName";
    String TW_MAX_SESSIONS = "maxSessions";
    String TW_VERSION = "version";
    String TW_TOKEN = "token";

    String TW_RA_TYPE_GAS = "GAS";

    String TW_CURRENT_SESSIONS_COUNT = "currentNumberOfSessions";

    String TW_REMOTE_AUDITS = "remote-audits";
    String TW_AUDIT_SESSION_ID = "session-id";
    String TW_AUDIT_CATEGORY = "category";
    String TW_AUDIT_CATEGORY_ID = "category-id";
    String TW_AUDIT_TYPE = "type"; // Additional Implementation required; Send Empty String now..
    String TW_AUDIT_TYPE_ID = "type-id";
    String TW_AUDIT_DATA = "audit-data";
    // Blow are for Session Info
    String TW_AUDIT_START_TIME = "start-time";
    String TW_AUDIT_END_TIME = "end-time";
    String TW_AUDIT_END_REASON = "end-reason"; // Additional Implementation required; Send Empty String now..
    String TW_AUDIT_END_REASON_ID = "end-reason-id";
    String TW_AUDIT_DATA_TX = "data-transferred";
    String TW_AUDIT_DATA_TX_TIME = "data-transferred-time";
    String TW_AUDIT_PORTS_USED = "ports-used";
    String TW_AUDIT_USER_IP = "user-ip";
    String TW_AUDIT_EDGE_IP = "edge-ip";

    String TW_AUDIT_VALUE = "value";
    String TW_AUDIT_AUDIT_RECORDS = "auditRecords";
    String TW_AUDIT_AUDIT_VERSION = "version";
    String TW_AUDIT_FOREIGN_NAME = "foreign-name";
}

import java.security.KeyStore;

/**
 * This class represents the SSL Configuration for a secure remote session.
 */
public class SSLInfo {

    private KeyStore keyStore;
    private String keyStoreType = "JKS";
    private String keyPhrase = "changeit";
    private String algorithm = "SunX509";
    private String protocol = "TLSv1.2";
    private Boolean serverAuthRequired = false;

    /**
     * Creates SSL parameters object. It uses certificates provided by the user to validate server.
     * If the KeyStore is provided but server authentication is disabled, the SDK Core will
     * use the default implementation of KeyStore, provided by the underlying virtual machine
     * (e.g JVM or DELVIK). Make sure you put the self-signed server certificate in the keyStore
     * for validation.
     *
     * @param keyStore           {@link KeyStore} Object, if null, default keyStore will be used. Make sure to load keyStore (if external) before sending to SDK if required.
     * @param type               the type of keyStore, "JKS" or "BKS"
     * @param password           the password of keyStore if external KeyStore is used
     * @param algorithm          the algorithm used by KeyStore to trust client, by default value is "SunX509"
     * @param protocol           the protocol used by SSL, by default gave is "TLSv1.2"
     * @param serverAuthRequired if server authentication is requested; by default the value is false.
     */
    public SSLInfo(KeyStore keyStore, String type, String password, String algorithm, String protocol, Boolean serverAuthRequired) {

        this.keyStore = keyStore;
        this.keyStoreType = type;
        this.keyPhrase = password;
        this.algorithm = algorithm;
        this.protocol = protocol;
        this.serverAuthRequired = serverAuthRequired;
    }


    /**
     * Creates SSL parameters object. This will disable server authentication and trust all the servers.
     * This should be used carefully as it not wise to disable server authentication in production.
     * (The statement is true for self-signed certificates).
     *
     * @param type      the type of keyStore, "JKS" or "BKS"
     * @param algorithm the algorithm used by KeyStore to trust a client, by default value is "SunX509"
     * @param protocol  the protocol used; by default the protocol is "TLSv1.2"
     */
    public SSLInfo(String type, String algorithm, String protocol) {

        this.keyStoreType = type;
        this.algorithm = algorithm;
        this.protocol = protocol;
    }

    /**
     * This uses Java's default keyStore with server authentication disabled
     */
    public SSLInfo() {

    }

    /**
     * Gets a type of key store. This key store will be used for authentication and integrity
     * <p>
     * If not used method {@link SSLInfo#setType(String)} the default value  "JKS"
     * <p>For Android, the value is "BKS"</p>
     *
     * @return keyStore type
     */
    public String getType() {
        return this.keyStoreType;
    }

    /**
     * Gets the key manager type
     * <p>
     * If not used method {@link SSLInfo#setAlgorithm(String)} default value is "SunX509".
     *
     * <p>Note: For Android, the value is "X509"</p>
     *
     * @return algorithm
     */
    public String getAlgorithm() {
        return this.algorithm;
    }

    /**
     * Gets the pass phrase of key store
     *
     * @return key store pass phrase
     */
    public String getKeyPhrase() {
        return this.keyPhrase;
    }

    /**
     * Gets the SSL protocol
     * <p>
     * By default, the value is "TLSv1.2"
     *
     * @return protocol name
     */
    public String getProtocol() {
        return this.protocol;
    }

    /**
     * Sets the server authentication requirement during SSL negotiation .
     * <p>
     * If this method is not set, during ssl negotiation the server certificate will be
     * trusted by default.
     *
     * @param sslAuthentication if true, the server authentication is enabled. if false, the server
     *                          authentication is disabled.
     */
    public void setServerAuthentication(Boolean sslAuthentication) {
        this.serverAuthRequired = sslAuthentication;
    }

    /**
     * Sets external keyStore initialized object. If this method is not set
     * and {@link SSLInfo#setServerAuthentication(Boolean)} is enabled, then
     * default jsse or android default keyStore will be used.
     *
     * <pre>If certificate is self-signed, put it in the keyStore</pre>
     *
     * <pre>{@link KeyStore} should be loaded before passing to SDK. </pre>
     *
     * @param keyStore set keystore
     */
    public void setKeyStore(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    /**
     * Gets the KeyStore object
     *
     * @return {@link KeyStore} object
     */
    public KeyStore getKeyStore() {
        return this.keyStore;
    }

    /**
     * Gets server authentication setting
     *
     * @return true if enabled; false if disabled.
     */
    public Boolean getServerAuthRequired() {
        return this.serverAuthRequired;
    }

    /**
     * Sets KeyStore type, like JKS, BKS
     *
     * @param type key store type
     * @throws IllegalStateException if type is empty or null.
     */
    public void setType(String type) {
        this.keyStoreType = type;
    }

    /**
     * Sets algorithm for key management.
     *
     * @param algorithm algorithm name
     * @throws IllegalStateException if type is empty or null.
     */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Sets key passphrase for keyStore type
     *
     * @param keyPhrase pass phrase
     */
    public void setKeyPhrase(String keyPhrase) {
        this.keyPhrase = keyPhrase;
    }

    /**
     * Sets preferred protocol for ssl communication
     *
     * @param protocol protocol name
     * @throws IllegalStateException if type is empty or null.
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}

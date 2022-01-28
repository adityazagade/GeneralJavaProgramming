import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Logger;

/**
 *
 */
public class CustomX509TrustManager implements X509TrustManager {

  private final static Logger logger = Logger.getLogger(CustomX509TrustManager.class.getName());
  private SSLInfo sslInfo;

  X509TrustManager pkixTrustManager;

  public CustomX509TrustManager(SSLInfo sslInfo) throws Exception {

    this.sslInfo = sslInfo;

    TrustManagerFactory tmf = TrustManagerFactory.getInstance(sslInfo.getAlgorithm());
    if (!sslInfo.getServerAuthRequired()) {

      KeyStore keyStore = null;

      if (sslInfo.getKeyStore() != null) {
        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      }

      tmf.init(keyStore);
      return;
    }

    tmf.init(sslInfo.getKeyStore());
    TrustManager tms [] = tmf.getTrustManagers();

    for (int i = 0; i < tms.length; i++) {
      if (tms[i] instanceof X509TrustManager) {
        pkixTrustManager = (X509TrustManager) tms[i];
        return;
      }
    }
  }

  public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    if (sslInfo.getServerAuthRequired()) {
      try {
        pkixTrustManager.checkClientTrusted(chain, authType);
      } catch (CertificateException excep) {
        // do any special handling here, or rethrow exception.
      }
    }else {
      logger.finer("**** checkClientTrusted:Client Certificate:");
    }
  }

  /*
   * Delegate to the default trust manager.
   */
  public void checkServerTrusted(X509Certificate[] chain, String authType)
    throws CertificateException {
    if (sslInfo.getServerAuthRequired()) {
      try {
        pkixTrustManager.checkServerTrusted(chain, authType);
      } catch (CertificateException excep) {
        System.out.println(excep.getMessage());
      }
    }else {
      logger.finer("**** checkServerTrusted:Server Certificate:");
    }
  }

  /*
   * Merely pass this through.
   */
  public X509Certificate[] getAcceptedIssuers() {
    if (sslInfo.getServerAuthRequired()) {
      return pkixTrustManager.getAcceptedIssuers();
    }
    return null;
  }
}
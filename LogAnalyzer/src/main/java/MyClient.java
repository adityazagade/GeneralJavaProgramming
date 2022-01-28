import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.sql.SQLOutput;

public class MyClient {
    public static void main(String[] args) {
//        System.setProperty("javax.net.ssl.trustStore","C:/ThingWorx/ACAClient/cacerts");
        try {
            SSLSocket sslSocket;

//             SSLContext sslContext = getSSLContext();
//             SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            SSLContext sslContext = getSSLContextLikeACA();
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

//            SSLSocketFactory sslSocketFactory =
//                    (SSLSocketFactory)SSLSocketFactory.getDefault();

            sslSocket = (SSLSocket) sslSocketFactory.createSocket("dev.gas.com", 13444);
            sslSocket.addHandshakeCompletedListener(handshakeCompletedEvent -> {
                System.out.println("Handshake finished!");
            });
            sslSocket.startHandshake();
            DataOutputStream dout = new DataOutputStream(sslSocket.getOutputStream());
            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
            sslSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static SSLContext getSSLContextLikeACA() throws Exception {
        SSLInfo sslInfo = new SSLInfo();
        sslInfo.setServerAuthentication(true);
        TrustManager[] trustManager = new TrustManager[] {new CustomX509TrustManager(sslInfo)};
        SSLContext sslContext = SSLContext.getInstance("TLSv1");
        sslContext.init(null, trustManager, null);
        return sslContext;
    }

    private static SSLContext getSSLContext() {
        try {
            TrustManager[] trustManager = null;
//            trustManager = new TrustManager[]{
//                    new X509TrustManager() {
//                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                            return new X509Certificate[0];
//                        }
//
//                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
//                        }
//
//                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
//                        }
//                    }
//            };
//
//            SSLContext sslContext = null;
//            assert sslContext != null;
            SSLContext sslContext = SSLContext.getInstance("TLSv1");
            sslContext.init(null, trustManager, null);
            return sslContext;
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }
}
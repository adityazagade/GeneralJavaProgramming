import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class ProvidingProvider {
    public static void main(String[] args) {
        // Setup Unlimited Strength Jurisdiction Policy Files
        // Looks like unlimited key strength is already enabled in some update of java 1.8.x
        int maxKeySize = 0;
        try {
            maxKeySize = javax.crypto.Cipher.getMaxAllowedKeyLength("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("Max Key Size for AES : " + maxKeySize);

        //adding a bouncy castle provider
        Security.addProvider(new BouncyCastleProvider());
        //you can also register it in java.security file.
        // C:\Program Files\Java\jdk1.8.0_271\jre\lib\security\java.security
        /*
        *
        * security.provider.1=sun.security.provider.Sun
        * security.provider.2=sun.security.rsa.SunRsaSign
        * security.provider.3=sun.security.ec.SunEC
        * */

    }
}

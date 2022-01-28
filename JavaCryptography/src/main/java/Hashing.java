import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hashing {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("One way only!");
        hashText("The quick brown fox jumped over the lazy dog");

        // hash it again, its deterministic
        System.out.println("deterministic");
        hashText("The quick brown fox jumped over the lazy dog");

        //pseudorandom
        // new digest looks nothing like the old digest
        hashText("The quick brown fox jumped ouer the lazy dog");

        //hash is always fixed length
        hashText("Hi there");
    }

    public static void hashText(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] digest = messageDigest.digest(s.getBytes());
        System.out.println("Input " + s);
        System.out.println("Digest:" + printByteArray(digest));
    }

    private static String printByteArray(byte[] digest) {
        return Base64.getEncoder().encodeToString(digest);
    }
}

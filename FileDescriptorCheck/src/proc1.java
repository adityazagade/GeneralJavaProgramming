import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class proc1 {
    public static void main(String[] args) {
        try {
            File f = new File(args[0]);
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

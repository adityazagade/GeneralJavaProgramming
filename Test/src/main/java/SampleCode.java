import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SampleCode {

    public static void main(String[] args) throws IOException {
        String aString = "File contents";
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outfilename.txt"), "UTF-32"));
        try {
            out.write(aString);
        } finally {
            out.close();
        }

    }
}
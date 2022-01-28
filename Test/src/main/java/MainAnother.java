import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class MainAnother {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\dev\\user_install_dir\\scm\\uploads\\1\\122_1632981172011.tar.gz");
            FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
            try {
                FileLock lock = channel.lock();
                System.out.println("file resource locked");
                Thread.sleep(600000);
                lock.release();
            } catch (OverlappingFileLockException e) {
                // File is already locked in this thread or virtual machine
                e.printStackTrace();
            }
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

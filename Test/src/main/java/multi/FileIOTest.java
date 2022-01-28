package multi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {
    public static void main(String[] args) {
        if (args.length > 0) {
            Thread t1 = new Thread(() -> {
                FileWriter fw = null;
                try {
                    System.out.println("Thread t1 running");
                    String path = args[1];
                    File f1 = new File(path);
                    fw = new FileWriter(f1);
                    fw.write("Some test string");
                    fw.close();
                } catch (IOException e) {
                    System.out.println("Error writing into file in t1");
                    e.printStackTrace();
                } finally {
                    if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException e) {
                            System.out.println("Error closing the file resource");
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread t2 = new Thread(() -> {
                // delete the file that we just created
                try {
                    String path = args[1];
                    File f2 = new File(path);
                    System.out.println("File deleted: " + f2.delete());
                } catch (Exception e) {
                    System.out.println("Error deleting file from t2");
                    e.printStackTrace();
                }
            });

            try {
                t1.start();
                System.out.println("Main Program: Sleeping for " + args[0] + " seconds");
                Thread.sleep(Long.parseLong(args[0]) * 1000);
                t2.start();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }
    }
}

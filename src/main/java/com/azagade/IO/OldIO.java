package com.azagade.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class OldIO {

    public static void main(String[] args) throws IOException {

        // this class is used to demonstrate how IO worked before java 7.
        URL url = new URL("http://abc.com");
        System.out.println(url.getPort());

        // 1) Let us start with reading byte stream from a file. There is an abstract class Inputstream and OutputStream and all its subclasses read byte stream.
        // FileInputStream and FileOutputStream.
        // Let is first read from file xanadu.txt/
        FileInputStream fis = null;
        // Let us write it back to file.
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "xanadu.txt");
            fos = new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/" + "xanaduOut.txt");
            int c;
            while ((c = fis.read()) != -1) {
//                System.out.println(c);
                fos.write(c);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }

        //let us try to write a japanese character using fileOutputStream
        try {
            fos = new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/" + "JapaneseTextOutput.txt");
            byte[] c = "片仮名".getBytes();
            fos.write(c);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }

        // let us read what we just wrote in JapaneseTextOutput
        try {
            fis = new FileInputStream(getPath("JapaneseTextOutput.txt"));
            int c;
            while ((c = fis.read()) != -1) {
                ByteBuffer b = ByteBuffer.allocate(4);
                b.putInt(c);
                String string = new String(b.array());
//                System.out.println(Arrays.toString(string.toCharArray()));
                System.out.println(string);
//                System.out.println(Arrays.toString(b.array()));..
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        // you would see that the characters are weirdly printed.

    }

    static String getPath(String fileName) {
        return System.getProperty("user.dir") + "/src/main/resources/" + fileName;
    }
}

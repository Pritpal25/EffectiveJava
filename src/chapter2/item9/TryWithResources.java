package chapter2.item9;

import java.io.*;

public class TryWithResources {
    private static final int BUFF = 8 * 1024;

    public static void copy(String src, String dst) {
        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFF];
            int n;
            while((n = in.read(buf)) >= 0) {
                out.write(buf, 0 , n);
            }
        } catch (IOException ex) {
            return;
        }
    }

    public static void main(String[] args) {
        copy(args[0], args[1]);
    }

}

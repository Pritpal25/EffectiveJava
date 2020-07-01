package chapter2.item9;

import java.io.*;

public class TryWithFInally {
    private static final int BUFF = 8 * 1024;

    public static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFF];
                int n;

                while((n = in.read(buf)) >= 0) {
                    System.out.println(n);
                    out.write(buf, 0, n);
                }
                System.out.println(n);

            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        copy(args[0], args[1]);
    }
}

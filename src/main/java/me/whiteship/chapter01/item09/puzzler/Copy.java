package me.whiteship.chapter01.item09.puzzler;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    // 코드 9-2 자원이 둘 이상이면 try-finally 방식은 너무 지저분하다! (47쪽)
    // IOException이 아니라면 만약에 close를 하닥 RuntimeException이 발생하면?
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        } finally {
            try {
                out.close(); // RuntimeException이 발생하면 여기서 끝나서 뒤가 더 이상 진행되지 않는다.
            } catch (IOException e) {
                // TODO 이렇게 하면 되는거 아닌가?
            }

            try {
                in.close();
            } catch (IOException e) {
                // TODO 안전한가?
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}

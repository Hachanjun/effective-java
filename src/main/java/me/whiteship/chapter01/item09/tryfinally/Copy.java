package me.whiteship.chapter01.item09.tryfinally;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    // 코드 9-2 자원이 둘 이상이면 try-finally 방식은 너무 지저분하다! (47쪽)
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close(); // 여기서 에러가 발생해도 in은 close() 하려고 시도한다.
            }
        } finally {
            in.close();
        }
    }
    // 아래는 아주 위험한 소스이다. 자원 리소스가 leak(구멍)이 생길 수 있다.
    // 
    static void copy2(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
        try {
        	byte[] buf = new byte[BUFFER_SIZE];
        	int n;
        	while ((n = in.read(buf)) >= 0)
        		out.write(buf, 0, n);
        } finally {
            in.close(); // 여기서 에러가 발생 시 out은 close() 안 된다.
            out.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}

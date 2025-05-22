package me.whiteship.chapter01.item09.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    // 코드 9-1 try-finally - 더 이상 자원을 회수하는 최선의 방책이 아니다! (47쪽)
    // 이 경우에는 모든 에러를 다 확인할 수 있다.
    static String firstLineOfFile(String path) throws IOException {
        try(BufferedReader br = new BadBufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
    
    // 이렇게 작성할 경우의 또 다른 문제점은 가장 나중에 발생한 예외만 보인다.
    // 즉 현재 예제에서는 StreamCorruptedException
    static String firstLineOfFile2(String path) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(path));
    	try {
    		return br.readLine();
    	} finally {
    		br.close();
		}
    }

    public static void main(String[] args) throws IOException {
        System.out.println(firstLineOfFile("pom.xml"));
    }
}

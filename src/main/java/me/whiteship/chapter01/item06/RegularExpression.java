package me.whiteship.chapter01.item06;

import java.util.regex.Pattern;

public class RegularExpression {

	// Pattern : 캐시해서 사용 
    private static final Pattern SPLIT_PATTERN = Pattern.compile(",");

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int j = 0; j < 10000; j++) {
            String name = "keesun,whiteship";
            // split 사용 시 한 글자일 때는 오히려 split 사용이 더 빠르다.(내부적으로 구현되어 있음(FastPath))
            name.split(",");
//            SPLIT_PATTERN.split(name);
        }
        System.out.println(System.nanoTime() - start);
    }
}

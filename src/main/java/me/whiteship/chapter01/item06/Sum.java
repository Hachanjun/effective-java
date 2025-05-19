package me.whiteship.chapter01.item06;

public class Sum {
    private static long sum() {
        // TODO Long을 long으로 변경하여 실행해 보세요.
        // 기본 타입을 래퍼 타입으로 변경할 때 오토 박싱이 일어나고(인스턴스가 생성) 래퍼 타입인 대문자 Integer, 대문자 Long, 대문자 Boolean을 소문자로 시작하는 기본 타입으로 변환하는 과정을 언박싱이라고 한다.
        // 이 오토 박싱 언박싱을 런타임의 JVM 자동으로 처리
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        long x = sum();
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000. + " ms.");
        System.out.println(x);
    }
}

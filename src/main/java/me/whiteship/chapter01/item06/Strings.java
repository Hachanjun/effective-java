package me.whiteship.chapter01.item06;

public class Strings {

    public static void main(String[] args) {
        String hello = "hello";

        //TODO 이 방법은 권장하지 않습니다.
        // JVM은 내부적으로 문자열을 풀에서 캐싱하고 있다.
        // 일종의 해시 맵에 한 번 만들어진 문자열들을 다 담아놓고 또 어디선가 동일한 문자열을 참조하려고 하면 그 동일한 문자열을 새로 만드는게 아니라
        // 이미 만들어 놓은 그 컨스턴트 풀 상수들의 풀에서 그 동일한 문자를 참조하는 방법으로 문자를 재사용하기 때문에 new String으로 하면 강제적으로 새로운 문자를 만들게 된다.
        // 같은 문자열이지만 다른 인스턴스(객체)이다.
        String hello2 = new String("hello");

        String hello3 = "hello";

        System.out.println(hello == hello2);
        System.out.println(hello.equals(hello2));
        System.out.println(hello == hello3);
        System.out.println(hello.equals(hello3));
    }
}

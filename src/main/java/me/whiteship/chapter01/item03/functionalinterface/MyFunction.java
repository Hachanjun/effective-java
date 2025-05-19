package me.whiteship.chapter01.item03.functionalinterface;

// 커스텀을 하고 싶은 경우 인터페이스 안에 메소드 선언이 오직 하나만 있으면 된다.
@FunctionalInterface
public interface MyFunction {

    String valueOf(Integer integer);

    static String hello() {
        return "hello";
    }
}

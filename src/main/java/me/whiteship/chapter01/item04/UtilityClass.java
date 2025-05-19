package me.whiteship.chapter01.item04;

import org.springframework.context.annotation.AnnotationConfigUtils;

public class UtilityClass {

    /**
	 * abstract로 하면 상속을 받아 인스턴스를 만들 수 있으며 abstract 클래스는 혼동을 줄 수 있다. (상속을 받아야하는 클래스인가라고 생각할 수 있다.)
	 * 단점 : 왜 못 쓰는 코드를 만들어야 하나? 문서화해라 
	 * 이 클래스는 인스턴스를 만들 수 없습니다. 
     */
//    private UtilityClass() {
//        throw new AssertionError();
//    }

    public static String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        String hello = UtilityClass.hello();

        // 인스턴스를 만든 후 호출할 수도 있지만 권장하지 않는다.
        // 인스턴스 메서도인지 정적 메서드인지 헷갈리게 한다.
        // private으로 하더라도 내부에서는 인스턴스를 만들 수 있다. 이것까지 막고 싶다면 throw new AssertionError();
        UtilityClass utilityClass = new UtilityClass();
        utilityClass.hello();
    }
}

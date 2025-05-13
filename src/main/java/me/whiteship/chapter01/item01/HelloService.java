package me.whiteship.chapter01.item01;

// 인터페이스와 정적 메서드
// 자바 8과 9에서 주요 인터페이스의 변화
// 기본 메소드(default method)와 정적 메소드를 가질 수 있다.
// 기본 메소드
// 인터페이스에서 메소드 선언 뿐 아니라, 기본적인 구현체까지 제공할 수 있다.
// 기존의 인터페이스를 구현하는 클래스에 새로운 기능을 추가할 수 있다.
// 정적 메소드
// 자바 9부터 private static 메소드도 가질 수 있다.
// 단, private 필드는 아직 선언할 수 없다. 
// private과 default 메소드 덕분에 기존의 api들의 기능이 풍부해졌다.
// 인터페이스와 불가 동반 클래스를 둘 이유가 없다. > 인스턴스를 만들 수 없도록 설계된 클래스는 final로 선언하고 private 생성자를 사용해야 하므로, 굳이 인터페이스와 함께 사용할 이유가 없다. 상속이 가능하면 하위 클래스에서 상위 클래스의 인스턴스를 우회적으로 만들 수 있기 때문에, 이를 방지하려면 상속 자체를 막아야 한다.
// 
public interface HelloService {

    String hello();

    static String hi() {
        prepareMessage();
        return "hi";
    }

    static private void prepareMessage() {
    }

    static String hi1() {
        prepareMessage();
        return "hi";
    }

    static String hi2() {
        prepareMessage();
        return "hi";
    }

    // 인스턴스 메소드(기본 구현체)
    default String bye() {
        return "bye";
    }
}

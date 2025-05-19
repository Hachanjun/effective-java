package me.whiteship.chapter01.item04;

// abstract로 만들어도 상속을 받아 인스턴스를 생성할 수 있다.
public class DefaultUtilityClass extends UtilityClass {

    public static void main(String[] args) {
        DefaultUtilityClass utilityClass = new DefaultUtilityClass();
        utilityClass.hello();
    }
}

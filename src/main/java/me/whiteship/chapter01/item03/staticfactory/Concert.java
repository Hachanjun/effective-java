package me.whiteship.chapter01.item03.staticfactory;

import java.util.function.Supplier;

// 정적 팩터리 메서드를 함수형 인터페이스인 Supplier로 사용하는 방법
// 정적 팩터리 메서드 : 객체 생성시 new 대신 getInstance() 등의 메서드로 생성
// 함수형 인터페이스(Supplier<T>) : 추상 메서드가 1개인 인터페이스, 함수형 인터페이스는 람다나 메서드 참조를 인자로 받을 수 있는 인터페이스
public class Concert {
	
	// 공급자 (자바 8에서 도입)
	// 자바 8 이후 부터 Supplier 인터페이스만 만족을 하면 어떠한 메서드든 Supplier function 타입으로 사용할 수 있다.
    public void start(Supplier<Singer> singerSupplier) {
        Singer singer = singerSupplier.get(); // Elvis.getInstance() 호출과 동일
        singer.sing();
    }

    public static void main(String[] args) {
        Concert concert = new Concert();
        // 인자 없는 메서드를 호출해서 무언가를 리턴해준다.
        // 정적 메서드 참조(Elvis::getInstance)를 공급자로 사용할 수 있다.
        // (Elvis::getInstance) 람다식으로 변경하면 () -> Elvis.getInstance() 즉, 매개변수 없이 호출하면 Elvis 인스턴스를 리턴하는 함수(Supplier<Elvis> 타입)
        concert.start(Elvis::getInstance); // 정적 메서드 참조를 Supplier로 전달 -> Elvis.getInstance()를 함수처럼 전달한 것
    }
}

//Supplier<T>란 매개변수 없이 호출할 수 있고, T 타입의 결과를 리턴해주는 함수
//@FunctionalInterface -> 컴파일러가 추상 메서드가 정확히 1개인지 확인
//public interface Supplier<T> {
//    T get();
//}
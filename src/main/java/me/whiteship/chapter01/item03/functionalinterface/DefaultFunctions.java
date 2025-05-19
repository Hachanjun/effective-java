package me.whiteship.chapter01.item03.functionalinterface;


import me.whiteship.chapter01.item03.methodreference.Person;

// 자바가 기본으로 제공하는 함수형 인터페이스
import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctions {

    public static void main(String[] args) {
    	// Function : 첫 번째 변수를 받고 두 번째 변수를 리턴한다.
        Function<Integer, String> intToString = Object::toString;
        // Supplier : 파라미터가 없고 리턴만 있다.
        // 선언하는 타켓 타입에 따라 각기 다른 생성자를 참조할 수 있다.
        // 기본 생성자를 호출하는 방법
        Supplier<Person> personSupplier = Person::new;
        // 파라미터가 있는 생성자를 호출하는 방법
        Function<LocalDate, Person> personFunction = Person::new;
        // Consumer : void, 파라미터는 있지만 리턴이 없다.
        Consumer<Integer> integerConsumer = System.out::println;
        // Predicate : 파라미터를 받아서 boolean을 리턴한다.
        Predicate<Person> predicate;
    }
}

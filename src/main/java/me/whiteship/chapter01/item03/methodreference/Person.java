package me.whiteship.chapter01.item03.methodreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Person {

    LocalDate birthday;

    // 비어있는 생성자가 있을 경우 이걸 참조하고 싶을 때는?
    public Person() {

    }

    // 생성자 레퍼런스
    public Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    // static 메서드 레퍼런스
    // Comparator 인터페이스가 제공해야 하는 메서드와 일치하기 때문에 메서드 레퍼런스로 Comparator 자리에 static한 메서드를 참조로 넣어줄 수 있다.
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
    
    // 인스턴스 메서드 1 -> 인스턴스를 통해서 접근해야한다.
    // public int compareByAge(Person a, Person b) {
    //    return a.birthday.compareTo(b.birthday);
    //} 
    
    // 인스턴스 메서드 2 -> 인스턴스 메서드로 메서드 레퍼런스를 제공하고 싶지만 임의 객체에 메서드 레퍼런스 참조하는 방법
    // 임의 객체에 대한 메서드 레퍼런스는 첫 번째 인자가 자기 자신이다.(본인 인스턴스) -> 임의 객체 메서드 레퍼런스인 경우에만! 
    // 어떤 값이 넘어오든 첫 번째 인자 즉 자기 자신과 비교한다.
    // public int compareByAge(Person b) {
    //    return this.birthday.compareTo(b.birthday);
    //} 

    public static void main(String[] args) {
    	// 날짜만 가지고 Person을 만든다고 했을 경우(생성자 레퍼런스)
    	List<LocalDate> dates = new ArrayList<>();
    	dates.add(LocalDate.of(1982, 7, 15));
    	dates.add(LocalDate.of(1982, 7, 15));
    	dates.add(LocalDate.of(1982, 7, 15));
    	// 날짜를 가지고 Person으로 변경 stream으로 LocalDate 마다 Person으로 만든다.
    	dates.stream().map(d -> {
    		// 이 부분은 메서드 콜을 하나만 한 것(메서드 레퍼런스)
    		return new Person(d);
    	}).collect(Collectors.toList());
    	// 이렇게 변경 가능
    	// Person:new는 무조건 파라미터가 있는 생성자를 참조한다.(LocalDate를 전달하니까 컴파일러가 바로 알 수 있다.)
    	dates.stream().map(Person::new).collect(Collectors.toList());
    
        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1982, 7, 15)));
        people.add(new Person(LocalDate.of(2011, 3, 2)));
        people.add(new Person(LocalDate.of(2013, 1, 28)));
        // 인스턴스 메서드 1 참조
        // Person person = new Person();
        // people.sort(person::compareByAge);
        
        // 인스턴스 메서드 2 참조
        // 클래스 이름으로 참조
        // people.sort(Person::compareByAge);

        // 익명 내부 클래스(이름 없는 클래스)
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.birthday.compareTo(b.birthday);
            }
        });
        // 익명 내부 클래스를 람다식으로 변경
        people.sort((p1, p2) -> p1.birthday.compareTo(p2.birthday));
        // 람다식이 오로지 메서드 하나만 호출하는 경우 라면 메서드 레퍼런스로 사용할 수 있다.
        people.sort((p1, p2) -> Person.compareByAge(p1, p2));
        // 아래처럼 변경 가능 (메서드를 참조하는 방법, 람다식을 만드는 방법)
        people.sort(Person::compareByAge);
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

}

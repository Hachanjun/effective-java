package me.whiteship.chapter02.item13.treeset;

import me.whiteship.chapter02.item13.PhoneNumber;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
//        TreeSet<Integer> numbers = new TreeSet<>();
//        numbers.add(10);
//        numbers.add(4);
//        numbers.add(6);

    	// 에러 발생 -> Comparable 구현했다고 생각해서 Comparable로 변환하려고 하는데 Comparable을 구현하지 않아서 캐스팅 오류
//    	TreeSet<PhoneNumber> numbers = new TreeSet<>();
//    	numbers.add(new PhoneNumber(123, 456, 780));
//    	numbers.add(new PhoneNumber(123, 456, 7890));
//    	numbers.add(new PhoneNumber(123, 456, 789));

    	// Comparable을 구현하지 않더라도 사용하는 방법
        TreeSet<PhoneNumber> numbers = new TreeSet<>(Comparator.comparingInt(PhoneNumber::hashCode));
        Set<PhoneNumber> phoneNumbers = Collections.synchronizedSet(numbers);
        phoneNumbers.add(new PhoneNumber(123, 456, 780));
        phoneNumbers.add(new PhoneNumber(123, 456, 7890));
        phoneNumbers.add(new PhoneNumber(123, 456, 789));

        for (PhoneNumber number : numbers) {
            System.out.println(number);
        }
    }
}

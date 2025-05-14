package me.whiteship.chapter01.item02.freeze;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;

    private final int birthYear;

    // 참조 객체의 경우에는 해당 객체들이 불변인 것이 아니다.(List를 못 바꾸는 것이 아니다.)
    // person.kids = new ArrayList<>(); 새롭게 할당을 못 한다는 것이다. 
    private final List<String> kids;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.kids = new ArrayList<>();
    }

    public static void main(String[] args) {
        Person person = new Person("keesun", 1982);

    }
}

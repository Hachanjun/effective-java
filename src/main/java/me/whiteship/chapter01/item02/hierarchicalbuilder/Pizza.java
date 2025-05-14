package me.whiteship.chapter01.item02.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// 코드 2-4 계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴 (19쪽)

// 참고: 여기서 사용한 '시뮬레이트한 셀프 타입(simulated self-type)' 관용구는
// 빌더뿐 아니라 임의의 유동적인 계층구조를 허용한다.

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    // 추상 클래스의 추상 빌더를 만들고 타입에는 빌더 자신의 하위 클래스 타입을 받도록 재귀적인 타입 제한을 사용(빌더 자신 타입이 자기 자신의 제네릭 타입)
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        
        // 리턴 타입을 Builder<T> 자신으로 지정하게 되면 하위 타입의 빌더 클래스들이 불편해진다. -> 하위 클래스에서 호출 할 때 Pizza에 있는 build()만 사용 가능
        //public Builder<T> addTopping(Topping topping) {
        //    toppings.add(Objects.requireNonNull(topping));
        //    return this();
        //}
        // 하위 클래스들의 빌더들은 자기 자신을 리턴해야 한다. 그래야 하위 클래스의 빌더만의 특수한 기능을 사용할 수 있다.
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의(overriding)하여
        // "this"를 반환하도록 해야 한다.
        protected abstract T self();
    }
    
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // 아이템 50 참조
    }
}

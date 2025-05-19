package me.whiteship.chapter01.item03.staticfactory;

import java.util.Objects;

// 코드 3-2 제네릭 싱글톤 팩토리 (24쪽)
// 클래스의 <T>는 인스턴스가 생성되어야 사용할 수 있는 타입 파라미터이다.
// 클래스 수준 제네릭 <T> → 인스턴스 레벨
public class MetaElvis<T> {
	// 제네릭 싱글턴 팩터리의 역할은 싱글턴 인스턴스를 원하는 타입으로 변환해주는 일만 해준다. 
    private static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

    private MetaElvis() { }

    // 원하는 타입으로 형변환을 해줄 수 있다.
    // static 메서드는 클래스의 제네릭을 사용할 수 없다.
    // public static void something(T t) { }  // ❌ 불가능! 컴파일 에러
    // 왜냐하면 static 메서드는 클래스가 로드될 때 존재하지만, T는 인스턴스를 생성해야만 구체화되기 때문이다.
    // static 메서드 제네릭 <E> → 메서드 레벨
    @SuppressWarnings("unchecked")
    public static <E> MetaElvis<E> getInstance() { return (MetaElvis<E>) INSTANCE; }

    public void say(T t) {
        System.out.println(t);
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
    	// 제네릭 타입을 사용할 때 인스턴스는 동일하지만 원하는 타입으로 변경 후 사용할 수 있다.
        MetaElvis<String> elvis1 = MetaElvis.getInstance();
        MetaElvis<Integer> elvis2 = MetaElvis.getInstance();
        // 해쉬 코드가 같고 같은 인스턴스이지만 제네릭 타입이 다르기 때문에 == 비교는 할 수 없다. equals만 가능
        System.out.println(elvis1);
        System.out.println(elvis2);
        // 클래스(MetaElvis<T>)의 제네릭 타입
        // getInstance()의 <E>는 클래스의 T로 전달되어 연결된다.
        // 즉, MetaElvis<E>가 반환되기 때문에 클래스의 <T>는 바로 E로 일치하게 바인딩 된다.
        elvis1.say("hello");
        elvis2.say(100);
    }
    
    /**
	 * 제네릭 퀴즈
	 * public static <E> MetaElvis<E> getInstance() { return (MetaElvis<E>) INSTANCE; }
	 * 클래스에 이미 <T>가 들어가 있는데 왜 또 <E>가 들어가 있는가?
	 * scope이 다르다. 즉 클래스의 <T>는 인스턴스 scope이고 <E>는 static한 scope이다.
	 * MetaElvis<E> 여기에 선언한 제네릭 타입은  static <E> 이걸 사용
	 * public void say(T t) 메서드에서의 T는 클래스의 제네릭 타입을 사용
	 * 즉 class MetaElvis<T> 내에 있는 <T>는 인스턴스용이고,
	 * static <E> MetaElvis<E> getInstance()의 <E>는 이 static 메서드 전용 타입이기 때문에 둘을 동시에 써도 괜찮고 스코프가 다르다.
	 */
}

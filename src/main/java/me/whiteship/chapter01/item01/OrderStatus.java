package me.whiteship.chapter01.item01;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * enum : 정해져 있는 상수 값들을 정할 수 있다.
 * 장점
 * 특정한 값들로만 제한할 수 있다.(타입 안정성)
 * enum에서 정의한 값들은 JVM에서 단 하나의 객체만 생성된다.
 *  
 */
public enum OrderStatus {

//	질문 2. enum은 자바의 클래스 처럼 생성자, 메소드, 필드들을 가질 수 있는가
//	enum 내부적으로 값을 표현해야 하는 경우가 있다.
    PREPARING(0), SHIPPED(1), DELIVERING(2), DELIVERED(3);

    private int number;

    OrderStatus(int number) {
        this.number = number;
    }
    
//    enum을 사용 안 할 경우
//    타입 안정성을 방어(검증)하는 코드를 추가해야한다. -> enum을 사용하면 필요없다.(컴파일러에서 처리)
//    0 - 주문 1 - 준비 중 2 - 배송 중 3 - 배송 완료
//    private int status;
//    
//    private final int PREPARING = 0;
//    private final int SHIPPED = 2;
//    
//    public static Order primeOrder(Product product) {
//    	Order order = new Order();
//    	order.prime = true;
//    	order.product = product;
//    	
//    	if ( this.status == order.PREPARING ) {
//    		return order;
//    	}
//    }

//    질문 1. enum 타입을 가질 수 있는 모든 값을 순회하며 출력하라
//    public static void main(String[] args) {
//    	Arrays.stream(OrderStatus.values()).forEach(System.out::println);
//    }

//    질문 3. enum은 == 연산자로 비교를 할 수 있는가 (equals를 사용해야 하는가 ==를 사용해야 하는가)
//    == 연산자 권장
//    ==은 JVM 레벨에서 하나의 인스턴스만 있음을 보장
//    equals는 null을 가지고 있으면 에러

//    과제 enum을 key로 사용하는 Map을 정의하세요. 또는 enum을 담고 있는 Set을 만들어 보세요.

//    Enum은 타입에 안전한 상수 집합을 만들 때 사용하며, Map의 키로 사용하거나 Set에 담기에 매우 적합하다.
//    Enum은 내부적으로 효율적인 정수 값으로 관리되기 때문이다.
//    
//    enum Day {
//    	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
//    }
//
//    EnumMap은 Java에서 Enum을 key로 사용할 때 가장 효율적인 Map 구현체이다.
//    EnumMap은 배열을 기반으로 구현되어 있어 매우 빠르고 메모리 효율도 좋다.
//    Key 타입은 반드시 enum이어야 하며, 생성 시 해당 타입 클래스 정보(Day.class)를 넘겨줘야 한다. null key 허용하지 않는다.
//    public static void main(String[] args) {
//    	EnumMap<Day, String> schedule = new EnumMap<>(Day.class);
//    	
//    	schedule.put(Day.MONDAY, "Work");
//    	schedule.put(Day.TUESDAY, "Rest");
//	}

//    enum Permission {
//    	READ, WRITE, EXECUTE, DELETE
//    }
//    
//    EnumSet은 Set<Enum>을 구현한 매우 빠르고 효율적인 Set이다.
//    내부적으로 비트 벡터(Bit Vector)를 사용하여 성능이 우수하다.
//    빠르고 메모리 효율적, 순서가 Enum 선언 순서와 같다.
//    public static void main(String[] args) {
//		EnumSet<Permission> userPermissions = EnumSet.of(Permission.READ, Permission.WRITE);
//	}
}

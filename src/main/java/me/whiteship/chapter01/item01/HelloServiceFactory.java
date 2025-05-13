package me.whiteship.chapter01.item01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.ServiceLoader;

/**
 * 인터페이스 타입을 사용할 수 있다.
 * 선언은 인터페이스를 넣었지만 막상 리턴해주는 타입은 구현체로 해줄 수 있다.(하위 클래스도 가능 -> 유연함이 생긴다.)
 * 생성자는 해당 클래스의 객체만 가져올 수 있지만 정적 팩토리 메소드는 리턴하는 반환 타입을 호환 가능한 다른 타입의 객체를 리턴할 수 있다.
 * 
 * HelloServiceFactory를 거쳐서 어떤 객체를 가지고 오든 타입이 인터페이스 타입이 된다.
 * 인터페이스 기반의 프레임워크를 사용하도록 강제하고, 구체적인 타입을 숨길 수 있다.
 * 
 */


import me.whiteship.hello.ChineseHelloService;

public class HelloServiceFactory {

// 자바8 이전에는 static을 인터페이스에 선언 할 수 없었지만 8부터 가능
// 인터페이스에서 접근제어자를 작성하지 않으면 기본이 public이다.
// 클래스에서는 접근제어자를 작성하지 않으면 패키지 private 레벨의 접근제어자로 간주한다.
//	static HelloService of(String lang) {
//		if ( lang.equals("ko") ) {
//			return new KoreanHelloService();
//		} else {
//			return new EnglishHelloService();
//		}
//	}

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    	// 자바가 기본으로 제공해주는 ServiceLoader (임의의 서비스를 로딩하겠다. / 여러 개의 서비스가 있을 수 있으므로 iterator)
    	// ServiceLoader : 서비스 프로파이더 프레임워크의 자바 기본 구현제 
    	// 장점5. 정적팩토리 메소드가 있으면 인터페이스만 있고 인터페이스 구현체는 존재하지 않아도 된다.
    	// 이 코드는 ChineseHelloService()에 의존적이지 않다.
    	// 어떤 임의의 구현체가 올 지 모르는 코드이다.
    	// 유연함이 있다. 예로 들어 JDBC Driver -> 하지만 JDBC Driver는 ServiceLoader가 등장하기 전에 나왔기 때문에 사용하지는 않고 있다.
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        // 자바8에서 추가된 Optional (있을 수도 있고 없을 수도 있다.)
        Optional<HelloService> helloServiceOptional = loader.findFirst();
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello());
        });
        
        // 이렇게 하는 경우 ChineseHelloService()에 의존적이며, import 해줘야한다.
        // 어떤 구현체를 사용할 것인지 명확하게 표시
        HelloService helloService = new ChineseHelloService();
        System.out.println(helloService.hello());

//        Class<?> aClass = Class.forName("me.whiteship.hello.ChineseHelloService");
//        Constructor<?> constructor = aClass.getConstructor();
//        HelloService helloService = (HelloService) constructor.newInstance();
//        System.out.println(helloService.hello());
        
    }

}

package me.whiteship.chapter01.item03.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 생성자로 여러 인스턴스 만들기
public class ElvisReflection {

    public static void main(String[] args) {
        try {
        	// getConstructor() : public한 생성자에만 접근이 가능하다.
        	// getDeclaredConstructor() : 접근 제어자에 상관없이 private한 생성자에도 접근 할 수 있다.
            Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor();
            // setAccessible(true) : false일 경우 private 생성자를 호출할 수 없다.
            defaultConstructor.setAccessible(true);
            // 서로 다른 인스턴스가 생성되게 된다.
            // 생성자로 추가 인스턴스 생성을 막으면 에러 발생(Elvis 클래스)
            Elvis elvis1 = defaultConstructor.newInstance();
            Elvis elvis2 = defaultConstructor.newInstance();
            Elvis.INSTANCE.sing();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

package me.whiteship.chapter01.item08.outerclass;

import java.lang.reflect.Field;

public class LambdaExample {

    private int value = 10;

    // Runnable로 바깥에 있는 어떤 값을 참조하게 되면 Lamda를 감싸고 있는 LambdaExample OuterClass에 대한 레퍼런스가 람다 안에 들어간다.
    // 클린을 하는 작업을 하는 러너블로 사용할 곳에서는 외부에 그걸 감싸고 있는 만약 이 감싸고 있는 인스턴스가 정리를 해야하는 인스턴스라면 순환 참조가 생긴다.
    // 작업 처리하는 거를 안에다 둘 때는 이렇게 하면 안 된다. 왜냐하면 정리해야 될 객체에 대한 레퍼런스가 생긴다.(항상 그런 건 아니다. 바깥 객체에 대한 걸 아무 것도 안 쓰면 생기지 않는다. 또한 static이면 안 생긴다)
    private Runnable instanceLambda = () -> {
        System.out.println(value);
    };

    public static void main(String[] args) {
        LambdaExample example = new LambdaExample();
        Field[] declaredFields = example.instanceLambda.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field type: " + field.getType());
            System.out.println("field name: " + field.getName());
        }
    }
}

package me.whiteship.chapter01.item08.outerclass;

import java.lang.reflect.Field;

public class OuterClass {

    private void hi() {

    }
    // 정적(static)이 아닌 중첩클래스를 썼을 때 그걸 감싸고 있는 OuterClass에 대한 레퍼런스가 생기기 때문에 Runnable만들 때 static으로 만들어라
    // OuterClass의 굉장히 종속적이다.
    class InnerClass {

        public void hello() {
            OuterClass.this.hi();
        }

    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();

        System.out.println(innerClass);

        outerClass.printFiled();
    }

    private void printFiled() {
        Field[] declaredFields = InnerClass.class.getDeclaredFields();
        for(Field field : declaredFields) {
            System.out.println("field type:" + field.getType());
            System.out.println("field name:" + field.getName());
        }
    }
}

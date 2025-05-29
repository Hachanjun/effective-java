package me.whiteship.chapter02.item13.exception;

public class MyApp {

    /**
     *
     * @param name
     * @throws MyException 이거 자체가 API
     */
    public void hello(String name) throws MyException {
        if (name.equals("푸틴")) {
            throw new MyException();
        }

        System.out.println("hello");
    }

    public static void main(String[] args) {
        MyApp myApp = new MyApp();
        try {
            myApp.hello("푸틴");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}

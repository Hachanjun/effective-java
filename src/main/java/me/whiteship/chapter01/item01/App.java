package me.whiteship.chapter01.item01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
    	// 서비스 접근 API
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = applicationContext.getBean(HelloService.class);
        System.out.println(helloService.hello());
    }
}

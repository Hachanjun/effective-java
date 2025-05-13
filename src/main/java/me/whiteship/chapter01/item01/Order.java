package me.whiteship.chapter01.item01;

/**
 * 장점 1. 이름을 가질 수 있다.
 * 생성자는 클래스 이름과 동일하게 만들어야 한다.
 * 생성자를 동일하게 만들 수는 없으나 타입의 순서나 매개 변수 갯수를 다르게 해서 생성할 수는 있다.
 * 정적 팩토리 메소드를 이름을 만들어 생성해준다.
 * 표현을 잘 할 수 있다.(객체의 특징을 팩토리 메소드의 이름으로 표현 할 수 있다. / 생성자의 매개변수가 중복되는 경우에 고려할 수 있다.)
 */

import java.util.*;

public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    private OrderStatus orderStatus;

    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;

        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    public static void main(String[] args) {

        Order order = new Order();
        if (order.orderStatus == OrderStatus.DELIVERED) {
            System.out.println("delivered");
        }
    }

}

package me.whiteship.chapter02.item10;

import java.util.ArrayList;
import java.util.List;

// 단순한 불변 2차원 정수 점(point) 클래스 (56쪽)
public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override public boolean equals(Object o) {
    	// 1. 객체의 동일성(자기 자신하고 같은 거니까) 반사성에 해당
        if (this == o) {
            return true;
        }
        // 2. 타입 비교
        if (!(o instanceof Point)) {
            return false;
        }
        // 3. 형변환
        Point p = (Point) o;
        // 4. 값들 중에서 반드시 꼭 같아야 하는 값들(핵심적인 필드) 비교
        // 책에서는 동기화에 사용하는 lock을 비교하지 말라고 예를 들었다.(synchronized)
        // lock은 어떤 객체 하나가 가지고 있는 특수한 필드인게 아닌거니까
        // float이랑 double 처럼 부동 소수점의 영향을 받는 것들은 가지고 있는 메소드로 비교하라
        // Double.compare(y, x);
        // 레퍼런스 타입은 equals로 기본타입은 ==으로 비교
        // 값이 null을 허용해야 하는 경우에는 Objects.equals를 사용해라
        return p.x == x && p.y == y;
    }

    public static void main(String[] args) {
        Point point = new Point(1, 2);
        List<Point> points = new ArrayList<>();
        points.add(point);
        System.out.println(points.contains(new Point(1, 2)));
    }

    // 잘못된 코드 - 리스코프 치환 원칙 위배! (59쪽)
//    @Override public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass())
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    // 아이템 11 참조
    @Override public int hashCode()  {
        return 31 * x + y;
    }
}

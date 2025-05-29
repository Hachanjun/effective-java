package me.whiteship.chapter02.item10.inheritance;

import me.whiteship.chapter02.item10.Color;
import me.whiteship.chapter02.item10.Point;

// Point에 값 컴포넌트(color)를 추가 (56쪽)
public class ColorPoint extends Point {
	// 필드를 추가했을 때는 안전하고 어떤 그 이런 추이성이나 대칭성을 위반하지 않는 equals를 추가하는 방법은 없다.
	// equals 규약을 만족할 수 있는 방법이 존재하지 않는다. 구체 클래스를 확장해서 새로운 값을 추가하면 equals 규약을 만족시킬 방법은 존재하지 않는다.
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // 코드 10-2 잘못된 코드 - 대칭성 위배! (57쪽)
//    @Override public boolean equals(Object o) {
//        if (!(o instanceof ColorPoint))
//            return false;
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }

//    // 코드 10-3 잘못된 코드 - 추이성 위배! (57쪽)
    // 그럼 Point는 Point라는 이 상위 클래스에서 이게 하위 타입은 하위 타입끼리 같은 타입인지 확인해야 하는 거 아닐까?
    // 리스코프 치안원칙 위배! -> 상위 클래스 타입으로 상위 클래스 타입의 인스턴스를 주더라도 그대로 동일하게 동작해야 한다.
    @Override public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        // o가 일반 Point면 색상을 무시하고 비교한다.
        if (!(o instanceof ColorPoint))
            return o.equals(this);

        // o가 ColorPoint면 색상까지 비교한다.
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public static void main(String[] args) {
        // 첫 번째 equals 메서드(코드 10-2)는 대칭성을 위배한다. (57쪽)
//        Point p = new Point(1, 2);
//        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
//        System.out.println(p.equals(cp) + " " + cp.equals(p));

        // 두 번째 equals 메서드(코드 10-3)는 추이성을 위배한다. (57쪽)
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n",
                          p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}

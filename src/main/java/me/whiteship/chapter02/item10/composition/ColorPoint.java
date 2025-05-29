package me.whiteship.chapter02.item10.composition;


import me.whiteship.chapter02.item10.Color;
import me.whiteship.chapter02.item10.Point;

import java.util.Objects;

// 코드 10-5 equals 규약을 지키면서 값 추가하기 (60쪽)
// 필드를 추가하고 싶은 경우에는 상속을 하지 말고 새로운 클래스를 정의한다.(Point와 내가 추가할 필드) -> Composition
public class ColorPoint {
	// 하나의 필드로 선언
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * 이 ColorPoint의 Point 뷰를 반환한다.
	 * ColoerPoint 이지만 Point로 볼 수 있는 메소드
     */
    public Point asPoint() {
        return point;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}

package me.whiteship.chapter01.item03.field;

import java.io.Serializable;

// 코드 3-1 public static final 필드 방식의 싱글턴 (23쪽)
// 직렬화 인터페이스를 구현해야한다.
public class Elvis implements IElvis, Serializable {

    /**
     * 싱글톤 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis();
    // 생성자가 두번 째 호출되는 경우 인스턴스 생성을 막게하라.
    private static boolean created;

    private Elvis() {
    	// 생성이 이미 됐다면 예외 발생
        if (created) {
            throw new UnsupportedOperationException("can't be created by constructor.");
        }
        // boolean은 기본값이 false이기 때문에 최초 생성 후에는 true로 변경
        created = true;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public void sing() {
        System.out.println("I'll have a blue~ Christmas without you~");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

    // 역질렬화를 할 때 in.readObject() 이 메소드가 사용이 된다. 
    // 오버라이딩은 아니지만 작성해주면 오버라이딩 처럼 동작된다. 
    private Object readResolve() {
        return INSTANCE;
    }

}

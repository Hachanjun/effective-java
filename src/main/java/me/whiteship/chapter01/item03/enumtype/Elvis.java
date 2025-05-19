package me.whiteship.chapter01.item03.enumtype;

// 열거 타입 방식의 싱글턴 - 바람직한 방법 (25쪽)
// 리플렉션과 직렬화/역직렬화에 안전하다.
// Enum은 애초에 Constructor()를 가져올 수가 없다.(리플렉션에 안전하다.)
// Enum은 근본적으로 new해서 만들 수 없게 되어있다. 열거형이기 때문에 선언한 것들만 사용 가능하다.(리플렉션 API에서도 동일하다.) 
// 테스트 시에는 인터페이스를 구현해서 사용하면 된다. -> public enum Elvis implements IElvis
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("기다려 자기야, 지금 나갈께!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}

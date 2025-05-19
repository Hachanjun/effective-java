package me.whiteship.chapter01.item03.staticfactory;

// 코드 3-2 정적 팩터리 방식의 싱글턴 (24쪽)
// 단점 : 리플렉션과 직렬화 문제가 동일
public class Elvis implements Singer {
	// private으로 선언 후 public 메서드를 통하는 방법
    private static final Elvis INSTANCE = new Elvis();
    // 직접 인스턴스를 생성하지 못 하도록 private 생성자를 만든다.
    private Elvis() { }
    // 메서드를 통해서 인스턴스를 가져가게 하는 방법
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    // 장점 1 : 클라이언트 코드는 변경되지 않지만 행위(동작)을 바꿀 수 있게 된다.
    // public static Elvis getInstance() { return new Elvis(); }
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();

        System.out.println(Elvis.getInstance());
        System.out.println(Elvis.getInstance());
    }

    @Override
    public void sing() {
        System.out.println("my way~~~");
    }
}

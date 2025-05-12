package me.whiteship.chapter01.item01;

/**
 * 이 클래스의 인스턴스는 #getInstance()를 통해 사용한다.
 * @see #getInstance()
 * 
 * 장점 2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
 * 
 * 자바의 생성자는 호출될 때 마다 새로운 객체를 만든다.
 * 해당 인스턴스를 하나만 만들어서 사용해야 할 경우 생성자가 아니라 정적 팩토리를 사용해서 인스턴스를 통제할 수 있다.
 * 이럴 경우 여러 개의 인스턴스를 만들 수 없다.
 * 생성자로는 못 하는 것을 정적 팩토리로는 할 수 있다.
 * 생성자는 객체 생성을 얼마든지 사용할 수 있다. 하지만 정적 팩토리는 생성자를 막았기 때문에 객체 생성을 자기 자신이 하겠다는 의미이다.(가져올 수는 있다.)
 * 플라이웨이트 패턴 : 자주 사용하는 값들을 캐싱해서 넣어놓고 꺼내쓰는 디자인 패턴
 * 
 */
public class Settings {

    private boolean useAutoSteering;

    private boolean useABS;

    private Difficulty difficulty;

    private Settings() {}

    private static final Settings SETTINGS = new Settings();

    public static Settings getInstance() {
        return SETTINGS;
    }

}

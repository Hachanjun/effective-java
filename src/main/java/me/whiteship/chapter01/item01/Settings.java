package me.whiteship.chapter01.item01;

/**
 * 이 클래스의 인스턴스는 #getInstance()를 통해 사용한다.
 * @see #getInstance()
 * 
 * 장점 2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
 * 
 * 자바의 생성자는 호출될 때 마다 새로운 인스턴스를 만든다.
 * 해당 인스턴스를 하나만 만들어서 사용해야 할 경우 생성자가 아니라 정적 팩토리를 사용해서 인스턴스를 통제할 수 있다.
 * 이럴 경우 여러 개의 인스턴스를 만들 수 없다.
 * 생성자로는 못 하는 것을 정적 팩토리로는 할 수 있다.
 * 생성자는 객체 생성을 얼마든지 사용할 수 있다. 하지만 정적 팩토리는 생성자를 막았기 때문에 객체 생성을 자기 자신이 하겠다는 의미이다.(가져올 수는 있다.)
 * 
 * 플라이웨이트 패턴 : 자주 사용하는 값들을 캐싱해서 넣어놓고 꺼내쓰는 디자인 패턴
 * 정적 팩토리 메소드에서 인스턴스를 통제하는 방법이기 때문에 미리 자주 사용하는 객체들을 만들어 놓고 그 중에서 필요로 하는 인스턴스를 꺼내 쓰는 방식이 플라이웨이트 패턴과 비슷하다.
 * 
 * 단점 1.
 * 정적 팩토리 메소드만을 사용하게 하려면 생성자를 private으로 만들어야 한다. 즉 상속을 허용하지 않는다.
 * 단, Delegation을 사용해 변경 가능하다.(꼭 상속하지 않더라고 사용 가능)
 * Delegation이란 자신으 ㅣ작업 중 일부를 다른 객체에 위임(delegate)하는 객체 지향 프로그래밍 기법
 * 쉽게 말해서, 어떤 기능을 수행해야 할 때 직접 처리하는 것이 아닌, 그 작업을 수행할 수 있는 "다른 객체"에게 일을 맡기는 것
 *
 * static한 정적 팩토리 메소드도 제공하면서 new도 제공하는 경우도 있을 수 있다.
 * 예로 들어 ArrayList<>()
 * List<String> list = new ArrayList<>(); / List.of("test", "test");
 *
 * 단점 2.
 * 문서화와 관련이 있다.
 * 어떤 생성자가 있다고 가정했을 경우 public Settings(...) {}
 * 메이븐으로 javadoc 만드는 방법 : mvn javadoc:javadoc
 * Constructors 같은 경우에는 별도의 컬럼이 있어 눈에 쉽게 들어온다.(이런 생성자를 통해서 만들 수 있겠구나라는 것을 파악할 수 있다.)
 * 정적 팩토리 메소드도 메소드 영역에 들어가 있지만 메소드가 많아진다면 인스턴스를 생성해 주는 용도의 메소드를 찾기가 어렵게 된다. > 이게 단점
 *
 * 책에서는 네이밍 패턴을 제안
 * of 혹은 valueOf: 매개변수를 받아서 사용하는 경우
 * getInstance : 미리 만들어져 있는 인스턴스를 가져오는 경우
 * newInstance : 팩토리 안에서 새로 만들어야 하는 경우
 *
 * 가장 좋은 방법은 문서화를 하는 것이다.
 * 
 * 문서화 방법
 * 이 클래스의 인스턴스는 #getInstance()를 통해 사용한다.
 * @see #getInstance() -> 나 자신일 경우 클래스 생략 가능
 * @see HelloService#hello() -> 밖에 있는 클래스를 참조할 경우
 * 이후 자바독 생성 mvn javadoc:javadoc
 */
public class Settings {

    private boolean useAutoSteering;

    private boolean useABS;

    private Difficulty difficulty;

    private Settings() {}

    private static final Settings SETTINGS = new Settings();
    
    public Settings(boolean useAutoSteering, boolean useABS, Difficulty difficulty) {
    	this.useAutoSteering = useAutoSteering;
    	this.useABS = useABS;
    	this.difficulty = difficulty;
    }

    public static Settings getInstance() {
        return SETTINGS;
    }

}

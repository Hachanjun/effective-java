package me.whiteship.chapter01.item03.field;

public class Concert {

    private boolean lightsOn;

    private boolean mainStateOpen;
    
    // 인터페이스 기반
    private IElvis elvis;

    public Concert(IElvis elvis) {
        this.elvis = elvis;
    }

    public void perform() {
        mainStateOpen = true;
        lightsOn = true;
        elvis.sing();
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public boolean isMainStateOpen() {
        return mainStateOpen;
    }
}

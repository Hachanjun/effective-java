package me.whiteship.chapter01.item08.finalizer;

/**
파이너라이저는 우리가 가지고 있는 클래스에 파이너 라이저를 오버라이드 오브젝트 클래스에 정의 자바9버전 부터 사용을 자제하라고 권장하고 있다
AutoCloseable을 구형 트라이 리소스를 사용하라고 권장한다.
*/

public class FinalizerIsBad {

    @Override
    protected void finalize() throws Throwable {
        System.out.print("");
    }
}

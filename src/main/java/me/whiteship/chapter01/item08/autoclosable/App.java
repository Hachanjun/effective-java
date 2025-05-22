package me.whiteship.chapter01.item08.autoclosable;

public class App {

    public static void main(String[] args) {
    	// 사용하는 쪽에서는 try
    	// 다 사용하면 자원 정리
    	// Cleaner를 사용할 때는 사람들이 아래처럼 사용 안 하더라도 자원이 반납될 수 있는 기회를 가질 수 있도록 하게 위해서 Cleaner 사용
        try(AutoClosableIsGood good = new AutoClosableIsGood("")) {
            // TODO 자원 반납 처리가 됨.

        }
    }
}

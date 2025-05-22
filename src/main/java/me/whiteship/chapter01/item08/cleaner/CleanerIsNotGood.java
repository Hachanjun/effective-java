package me.whiteship.chapter01.item08.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {

	// 사용 방법은 Phantom Reference를 사용해서 만들어졌기 때문에 사용 방법이 비슷하다.
    public static void main(String[] args) throws InterruptedException {
    	// Cleaner 생성
        Cleaner cleaner = Cleaner.create();
        // 사용하고 싶은 객체 생성
        List<Object> resourceToCleanUp = new ArrayList<>();
        BigObject bigObject = new BigObject(resourceToCleanUp);
        // Cleaner 등록
        cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp));

        bigObject = null;
        System.gc();
        Thread.sleep(3000L);
    }
}

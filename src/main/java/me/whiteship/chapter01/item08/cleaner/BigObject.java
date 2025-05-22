package me.whiteship.chapter01.item08.cleaner;

import java.util.List;

public class BigObject {

    private List<Object> resource;

    public BigObject(List<Object> resource) {
        this.resource = resource;
    }

    // 오브젝트가 없어질 때마다 정리가 돼야할 때 정리하는 작업을 Runnable로 정의한다.
    // 파이너라이저에서 하는 일을 별도의 Runnable Task를 만든다.
    // 주의해야하는 것은 static으로 만들어야한다. 절대로 BigObject에한 레퍼런스가 있으면 안 된다.
    // 내가 정리하려는 오브젝트를 참조하면 안 된다. 객체가 부활할 수 있다.
    
    public static class ResourceCleaner implements Runnable {
    	// 그래서 리소스를 참조하도록 한다.
        private List<Object> resourceToClean;

        public ResourceCleaner(List<Object> resourceToClean) {
            this.resourceToClean = resourceToClean;
        }

        @Override
        public void run() {
            resourceToClean = null;
            System.out.println("cleaned up.");
        }
    }
}

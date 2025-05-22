package me.whiteship.chapter01.item07.executor;

import me.whiteship.chapter01.item01.Product;

import java.util.concurrent.*;

public class ExecutorsExample {

//	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		// 메인 스레드가 있고 별도의 스레드가 호출된다.
//		// 스레드를 만드는 거 자체가 시스템 리소스를 많이 차지한다고 봐야한다.
//		// 이러한 작업을 스레드를 조금만 쓰고도 (비동기적으로)할 수 있다면? -> 쓰레드풀을 만든다.
//		for ( int i = 0; i < 100; i++ ) {
//			Thread thread = new Thread(new Task());
//			thread.start();
//		}
//		
//		System.out.println(Thread.currentThread() + " hello");
//	}
//	
//    static class Task implements Runnable {
//
//		@Override
//		public void run() {
//			try {
//				Thread.sleep(2000L);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread() + " world");
//		}
//    }

    // 쓰레드 풀 방식
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    	// 쓰레드를 10개만 만들겠다. -> 10개의 쓰레드로 100개의 작업을 처리
    	// 쓰레드 풀의 개수를 조정할 때 두 가지를 신경써야 한다. 1. CPU의 작업이냐, 2. I/O 작업이냐
    	// CPU의 작업 -> 아무리 쓰레드 개수를 늘려도 CPU 개수를 넘어가면 막힌다. CPU보다 많이 개수를 늘려도 기다려야한다. 처리를 못 한다. CPU 개수 만큼만 만들어야 한다.
    	// cpu 개수 구하는 방법
    	// int numberOfCpu = Runtime.getRuntime().availableProcessors();
    	
    	// 자기가 필요한 만큼 스레드를 만드는 방법
    	// newCachedThreadPool() : 필요한 만큼 스레드를 만든다. 기존에 스레드가 있으면 재사용하고 바쁘면 새로 만든다. 오랫동안 아무 일도 안 하고 있는 스레드가 있으면 60초가 지나면 자동으로 그 스레드를 없애준다.
    	// 작업을 위한 공간이 딱 하나이다. 이 큐를 들어오자마자 바로 스레드에 주는데 줄만한 스레드가 없으면 새로 만든다. 그래스 스레드가 계속 늘어난다.
    	
    	// newSingleThreadExecutor() : 싱글 스레드이기 때문에 Thread를 딱 하나만 만들어서 작업 100개를 하나 가지고 다 처리 -> 굉장히 오래 걸린다.

    	// newScheduledThreadPool(10) : 순차적으로 작업이 들어오지 않고 스케줄을 감안해서 순서가 바뀔 수 있다. 어떤 작업을 몇 초 뒤에 딜레이 시켜서 실행한다거나 아니면 주기적으로 실행한다거나 할 때 사용
    	
    	// newFixedThreadPool() : 내부적으로 BlockingQueue라고 해서 100개의 작업을 큐에 넣는데 BlockingQueue는 Concurrent하게 접근이 가능하다.
    	// 일반적인 ArrayList나 HashMap은 Concurrent에 안전하지 않다. 동시 접근하는데 사용할 만한 안전한 컬렉션이 아니다.
    	// Concurrent Modification Exception(누구나 이걸 보고 있는데 바꾸면 안 되지) : 동시다발적으로 어떤 여러 멀티스레드가 동일한 ArrayList나 HashMap에 접근해서 엘리먼트들을 조작하거나 이러면 발생
    	// newFixedThreadPool() : 여러 스레드가 동시에 엘리먼트를 넣고 뺄 수 있는 기능을 지원하는 큐(BlockingQueue)
    
        ExecutorService service = Executors.newFixedThreadPool(10);

        // non blocking
        Future<String> submit = service.submit(new Task());

        System.out.println(Thread.currentThread() + " hello");

        // blocking call .get()
        System.out.println(submit.get());

        service.shutdown();
    }

    // Callable : 결과를 받고 싶을 떄 (리턴 : Future)
    static class Task implements Callable<String> {
    	
    	// I/O 작업 (DB 엑세스, HTTP 콜로 값 가져오기)
    	// 스레드 개수와 CPU 개수와 상관없이 더 많은 수의 스레드를 필요로 한다. -> I/O 에서 딜레이가 될텐데 그걸 정확히 정의 할 수 없다.
    	@Override
    	public String call() throws Exception {
    		Thread.sleep(2000L);
    		return Thread.currentThread() + " world";
    	}
    }
}
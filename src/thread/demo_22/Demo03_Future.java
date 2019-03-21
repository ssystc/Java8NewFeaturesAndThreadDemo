package thread.demo_22;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Demo03_Future {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		FutureTask<Integer> futureTask = new FutureTask<>(()->{
//			System.out.println("start");
//			Thread.sleep(1000);
//			return 66;
//		});
//		
//		Thread t1 = new Thread(futureTask);
//		Thread t2 = new Thread(futureTask);
//
//		t1.start();
//		t2.start();
//		System.out.println(futureTask.get());
		
		
//		Runnable runnable = ()->{
//			System.out.println("start");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("end");
//		};
//			
//		Thread t3 = new Thread(runnable);
//		Thread t4 = new Thread(runnable);
//		t3.start();
//		t4.start();
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		Future<Integer> f = service.submit(()->{
			Thread.sleep(1000);
			return 66;
		});
		
		Future<Integer> f2 = service.submit(()->{
			Thread.sleep(1000);
			return 88;
		});
		
		System.out.println(f.isDone());
		System.out.println(f.get());
		System.out.println(f.isDone());
		
		Thread.sleep(10);
		
		System.out.println(f2.isDone());
		System.out.println(f2.get());
		System.out.println(f2.isDone());

	}
	
}

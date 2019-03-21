package thread.demo_22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo02_ThreadPool {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 5; i++) {
			service.execute(()->{
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		System.out.println(service);
		service.shutdown();				//不加shutdown的话，线程会一直等待，等着新的任务加入
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-------------------------------");
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-------------------------------");
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
		
	}
	
}

package thread.demo_22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//这个pool只要有任务加进来就会新建一个线程去跑任务，无限加，加到程序顶不住
//当等待一分钟如果空闲的线程都没有等到新任务的时候，这个空闲的线程会释放
public class Demo05_CacheThreadPool {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println(service);
		
		for(int i = 0; i<10; i++) {
			service.execute(()->{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		System.out.println(service);
		
		Thread.sleep(1500);
		System.out.println(service);
		
		for(int i = 0; i<10; i++) {
			service.execute(()->{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		Thread.sleep(1500);
		System.out.println(service);
		
		
		for(int i = 0; i<20; i++) {
			service.execute(()->{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		Thread.sleep(1500);
		System.out.println(service);
		
		
		//等待80秒
		Thread.sleep(80000);
		System.out.println(service);
	}
	
}

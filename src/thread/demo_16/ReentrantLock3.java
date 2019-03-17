package thread.demo_16;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//这个锁是可以被打断的，我不想等了就直接打断它，我不陪你玩了。。

public class ReentrantLock3 {
	
	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();

		Thread t1 = new Thread(()->{
			try {
				lock.lock();
				System.out.println("t1 start");
				Thread.sleep(Integer.MAX_VALUE);
				System.out.println("t1 end");
			} catch (Exception e) {
				System.out.println("t1 interrupted");
			} finally {
				if(lock.tryLock()) lock.unlock();
			}
		});
		t1.start();
		
		
		Thread t2 = new Thread(() -> {
			try {
//				lock.lock();
				lock.lockInterruptibly();
				System.out.println("t2.start");
				Thread.sleep(3000);
				System.out.println("t2 end");
			} catch (Exception e) {
				System.out.println("t2 interrupted");
			} finally {
				if(lock.tryLock()) lock.unlock();
			}
		});
		t2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.interrupt();
	}

}

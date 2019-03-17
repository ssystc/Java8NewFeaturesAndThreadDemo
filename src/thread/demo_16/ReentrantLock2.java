package thread.demo_16;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock2 {

Lock lock = new ReentrantLock();
	
	void m1() {
		try {
			lock.lock();
			for(int i = 0; i < 10; i++) {
				Thread.sleep(500);
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	//tryLock进行尝试锁定，不管能否锁定，方法继续执行
	//可以根据tryLock的返回值判断是否锁定
	void m2() {
		
		
		boolean locked = false;
		try {
			locked = lock.tryLock(1, TimeUnit.SECONDS);
			System.out.println("m2 " + locked);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(locked) lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ReentrantLock2 r = new ReentrantLock2();
		new Thread(r::m1).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(r::m2).start();
	}
	
}

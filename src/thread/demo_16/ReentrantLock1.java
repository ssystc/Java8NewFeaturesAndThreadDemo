package thread.demo_16;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//必须手动锁定，手动释放，一般放finally里释放
public class ReentrantLock1 {

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
	
	void m2() {
		lock.lock();
		System.out.println("m2 ... ");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		ReentrantLock1 r = new ReentrantLock1();
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

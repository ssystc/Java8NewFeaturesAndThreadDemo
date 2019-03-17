package thread.demo_16;

import java.util.concurrent.locks.ReentrantLock;
//默认是非公平锁，这样效率高，但是我们可以改成公平锁，谁等的时间长就让谁获得锁
public class ReentrantLock4 extends Thread {

	private static ReentrantLock lock = new ReentrantLock(true);
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName());
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		ReentrantLock4 r = new ReentrantLock4();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
	
}

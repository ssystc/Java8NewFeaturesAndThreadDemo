package thread.demo_15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
* @author 作者
* @version 创建时间：2019年3月16日 下午2:53:38
* 类说明	使用Latch代替wait和notify
*/
public class MyContainer4 {
	//别忘了volatile
	volatile List list = new ArrayList<>();
	
	public void add(Object o) {
		list.add(o);
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		MyContainer4 c = new MyContainer4();
		CountDownLatch latch = new CountDownLatch(1);
		
		new Thread(()->{
			System.out.println("t2 start");
			if(c.size()!=5) {
				try {
					latch.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("t2 end");
		}, "t2").start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(()->{
			System.out.println("t1 start");
			for(int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add " + i);
				if(c.size()==5) {
					latch.countDown();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}, "t1").start();
	}
}

package thread.demo_15;

import java.util.ArrayList;
import java.util.List;

/**
* @author 作者
* @version 创建时间：2019年3月16日 下午2:41:19
* 类说明	这个方法是不能实现我们要的功能的，因为我们notify之后，我们想要执行t2里的内容，但是锁没有被释放，所以走不下去
*/
public class MyContainer2 {
	
	//别忘了volatile
	volatile List list = new ArrayList<>();
		
	public void add(Object o) {
		list.add(o);
	}
		
	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		MyContainer2 c = new MyContainer2();
		final Object lock = new Object();
		
		new Thread(()->{
			synchronized (lock) {
				System.out.println("t2 start");
				if(c.size() != 5) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("t2 end");
			}
			
		}, "t2").start(); 
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(()->{
			System.out.println("t1 start");
			synchronized (lock) {
				for(int i = 0; i < 10; i++) {
					c.add(new Object());
					System.out.println("add " + i);
					
					if(c.size()==5) {
						lock.notify();
					}
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "t1").start();
		
	}
	
}

package thread.demo_15;

import java.util.ArrayList;
import java.util.List;

/**
* @author 作者
* @version 创建时间：2019年3月16日 下午2:49:26
* 类说明	这个就能实现了，和上一个对比一下，别犯wait、notify放到synchronize代码块外的低级错误，notify是不释放锁的
*/
public class MyContainer3 {

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
					lock.notify();
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
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
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

package thread.demo_11;

import java.util.ArrayList;
import java.util.List;

/**
* @author 作者
* @version 创建时间：2019年3月16日 下午1:59:46
* 类说明 volatile只能保证可见性，不能保证原子性
*/
public class T {

	volatile int count = 0;
	void m() {
		for(int i = 0; i<10000; i++) {
			count++;
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		List<Thread> threads = new ArrayList<>();
		
		for(int i = 0; i<10; i++) {
			threads.add(new Thread(()->t.m()));
		}
		
		threads.forEach((o)->o.start());
		
		threads.forEach((o)->{
			try {
				o.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		
		System.out.println(t.count);
	}
	
}

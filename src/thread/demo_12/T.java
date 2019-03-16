package thread.demo_12;
/**
* @author 作者
* @version 创建时间：2019年3月16日 下午2:08:14
* 类说明 和上一个示例相对比一下就明白了，AutomicXX类，注意把注释去掉结果可以证明多个原子性方法加起来就不再是原子性的了
*/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class T {
	
	AtomicInteger count = new AtomicInteger(0);
	
	void m() {
		for(int i = 0; i<10000; i++) {
//			if(count.get()<1000) {
//				count.incrementAndGet();
//			}
			
			count.incrementAndGet();
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

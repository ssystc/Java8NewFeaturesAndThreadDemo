package thread.demo_15;

import java.util.ArrayList;
import java.util.List;

/**
* @author 作者
* @version 创建时间：2019年3月16日 下午2:31:31
* 类说明
* 写一个容器，提供add和size方法
* 写两个线程，线程1添加10个元素到容器中，线程2实现元素个数的监控，当个数到5时，线程2给出提示并结束
* 
*/
public class MyContainer1 {

	//别忘了volatile
	volatile List list = new ArrayList<>();
	
	public void add(Object o) {
		list.add(o);
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		
		MyContainer1 c = new MyContainer1();
		
		new Thread(() ->{
			for(int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "t1").start();
		
		new Thread(()->{
			while(true) {
				if(c.size()==5) {
					break;
				}
			}
			System.out.println("t2 结束");
		}, "t2").start(); 
		
	}
	
}

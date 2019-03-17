package thread.demo_17;

import java.util.LinkedList;

import sun.tools.jar.resources.jar;

/**
 * 
 * @author Administrator
 *写一个固定容器同步容器，有put和get和getCount方法
 *支持两个生产者线程和是个消费者线程阻塞调用
 *
 *使用wait和notify、notifyall实现
 */

public class MyContainer1<T> {

	final private LinkedList<T> lists = new LinkedList<>();
	final private int MAX = 10;
	private int count = 0;
	
	public synchronized void put(T t) {
		while(lists.size() == MAX) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		lists.add(t);
		++count;
		this.notifyAll();
	}
	
	public synchronized T get() {
		T t = null;
		while(lists.size()==0) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		t = lists.removeFirst();
		count--;
		this.notifyAll();
		return t;
	}
	
	public static void main(String[] args) {
		MyContainer1<String> c = new MyContainer1<>();
		for(int i = 0; i < 10; i++) {	//十个消费者
			new Thread(()->{
				for(int j = 0; j < 5; j++) {
					System.out.println(c.get());
				}
			}, "c" + i).start();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < 3; i++) {	//三个生产者
			new Thread(()->{
				for(int j = 0; j < 25; j++) {
					c.put(Thread.currentThread().getName() + ":" + j);
				}
			}, "p" + i).start();
		}
	}
	
}

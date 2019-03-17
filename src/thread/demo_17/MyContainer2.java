package thread.demo_17;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Lock和Condition的方式实现

public class MyContainer2<T> {

	final private LinkedList<T> lists = new LinkedList<>();
	final private int MAX = 10;
	private int count = 0;
	
	private Lock lock = new ReentrantLock();
	private Condition producer = lock.newCondition();
	private Condition consumer = lock.newCondition();
	
	public void put(T t) {
		try {
			lock.lock();
			while(lists.size()==MAX) {
				producer.await();
			}
			lists.add(t);
			count++;
			consumer.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public T get() {
		T t = null;
		try {
			lock.lock();
			while(lists.size()==0) {
				consumer.await();
			}
			t = lists.removeFirst();
			count--;
			producer.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return t;
	}
	
	public static void main(String[] args) {
		MyContainer2<String> c = new MyContainer2<>();
		
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

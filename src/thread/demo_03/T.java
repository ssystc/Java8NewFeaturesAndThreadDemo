package thread.demo_03;
/**
* @author 作者
* @version 创建时间：2019年3月16日 上午11:01:32
* 类说明	
*/
public class T {

	//同步方法和非同步方法能否同时执行，就是一个方法锁当前对象，另一个方法不锁，那么执行第一个方法的时候第二个方法能执行吗，废话，肯定能执行啊
	//以下的方法说明m1和m2同时执行的，不会有等待锁的情况
	
	public synchronized void m1()  {
		System.out.println(Thread.currentThread().getName() + " start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end");
	}
	
	public void m2()  { //如果也加个synchronize情况就不一样了
		System.out.println(Thread.currentThread().getName() + " start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end");
	}
	
	public static void main(String[] args) {

		T t = new T();
		new Thread(()->t.m1(), "t1").start();
		new Thread(()->t.m2(), "t2").start();
		
	}
	
}

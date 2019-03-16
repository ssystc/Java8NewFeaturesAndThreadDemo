package thread.demo_05;
/**
* @author 作者
* @version 创建时间：2019年3月16日 上午11:26:18
* 类说明
*/
public class MainTest {

	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2();
		
//		Runnable r = ()->t1.t1m1();
//		Runnable r2 = ()->t1.t1m2();
//		
//		new Thread(r).start();
//		new Thread(r2).start();
//		//以上代码会等t1m1执行完之后执行t1m2
		
		
//		//以下代码t1m1和t2m1同时执行
//		Runnable r = ()->t1.t1m1();
//		Runnable r2 = ()->t2.t2m1();
//		new Thread(r).start();
//		new Thread(r2).start();
		
		
		//以下代码t1m1和t2m1同时执行
		T1 t11 = new T1();
		Runnable r = ()->t1.t1m1();
		Runnable r2 = ()->t11.t1m1();
		new Thread(r).start();
		new Thread(r2).start();
		
		
		//这说明啥？说明了synchronize方法实际上锁的是方法所在的对象，所以两个不同对象里的synchronize是不会相互阻塞的
	}
	
	
	
}

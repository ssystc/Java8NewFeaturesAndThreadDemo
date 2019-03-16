package thread.demo_13;
/**
* @author 作者
* @version 创建时间：2019年3月16日 下午2:16:43
* 类说明	锁定一个对象，如果这个对象的引用发生了改变，锁也就变了；如果只是对象的属性发生改变则没有影响
*/
public class T {

	Object o = new Object();
	
	void m() {
		synchronized (o) {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}
		}
	}
	
	public static void main(String[] args) {
		
		T t = new T();
		new Thread(()->t.m(),"t1").start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t2 = new Thread(()->t.m(), "t2");
//		t.o = new Object();
		t2.start();
		
	}
	
}

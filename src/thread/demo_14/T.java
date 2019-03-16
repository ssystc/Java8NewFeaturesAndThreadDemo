package thread.demo_14;
/**
* @author 作者
* @version 创建时间：2019年3月16日 下午2:20:53
* 类说明	不要拿String当锁，例子中看似不同对象，实际上如果字符串相同那么锁的就是同一个对象
*/
public class T {

	String s1 = "aaa";
	String s2 = "aaa";
	
	void m1() {
		synchronized (s1) {
			while(true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}
		}
	}
	
	void m2() {
		synchronized (s2) {
			while(true) {
				try {
					Thread.sleep(500);
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
		Runnable r1 = ()->t.m1();
		Runnable r2 = ()->t.m2();
		
		new Thread(r1).start();
		new Thread(r2).start();

	}
	
}

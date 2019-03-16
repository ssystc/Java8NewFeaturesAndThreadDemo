package thread.demo_06;
/**
* @author 作者
* @version 创建时间：2019年3月16日 下午12:02:23
* 类说明 synchronize是可重入锁
*/
public class T {

	synchronized void m1() {
		System.out.println("m1.start");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m2();
	}
	
	synchronized void m2() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m2");
	}
	
	
}

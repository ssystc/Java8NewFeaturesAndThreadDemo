package thread.demo_05;
/**
* @author 作者
* @version 创建时间：2019年3月16日 上午11:25:36
* 类说明
*/
public class T2 {

	public synchronized void t2m1() {
		System.out.println("t2m1 start");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("t2m1 end");
	}
	
	public synchronized void t2m2() {
		System.out.println("t2m2 start");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("t2m2 end");
	}
	
}

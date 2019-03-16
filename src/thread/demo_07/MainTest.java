package thread.demo_07;


/**
* @author 作者
* @version 创建时间：2019年3月16日 下午12:08:30
* 类说明 死锁
*/
public class MainTest {

	
	public static void main(String[] args) {
		Thread t1 = new Thread(new T(true));
		Thread t2 = new Thread(new T(false));
		
		t1.start();
		t2.start();
	}
	
	
}

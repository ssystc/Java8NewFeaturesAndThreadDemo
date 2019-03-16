package thread.demo_02;
/**
* @author 作者
* @version 创建时间：2019年3月16日 上午10:56:21
* 类说明
*/
public class T implements Runnable {

	private int count = 10;
	
	public synchronized void run() {	//synchronize最简单的例子
		count--;
		System.out.println(Thread.currentThread().getName() + ".count=" + count);
	}
	
	public static void main(String[] args) {
		T t = new T();
		
		for (int i = 0; i<5; i++) {
			new Thread(t).start();
		}
	}
	
}

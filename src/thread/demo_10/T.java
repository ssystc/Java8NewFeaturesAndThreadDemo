 package thread.demo_10;
/**
* @author 作者
* @version 创建时间：2019年3月16日 下午1:53:11
* 类说明 volatile的简单使用示例
*/
public class T {

	/*volatile*/ boolean running = true;
	
	void m() {
		System.out.println("m start");
		while(running) {
			
		}
		System.out.println("m end");
	}
	
	public static void main(String[] args) {
		T t = new T();
		new Thread(()->t.m(), "t1").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.running = false;
	}
	
	
}

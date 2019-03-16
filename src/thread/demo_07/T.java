package thread.demo_07;
/**
* @author 作者
* @version 创建时间：2019年3月16日 下午12:07:08
* 类说明
*/
public class T implements Runnable {
	
	final static Object o1 = new Object();
	final static Object o2 = new Object();
	
	boolean b;
	public T(boolean b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		
		if(this.b) {
			synchronized (o1) {
				try {
					
					System.out.println("o1.lock line 22");
					Thread.sleep(4500);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("o2 lock line 27");
				}
				
				
			}
		}else {
			synchronized (o2) {
				try {
					
					System.out.println("o2.lock line 36");
					Thread.sleep(2000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("o1 lock line41");
				}
				
			}
		}
		
		
		
	}

}

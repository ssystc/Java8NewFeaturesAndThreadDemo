package thread.demo_09;
/**
* @author 作者
* @version 创建时间：2019年3月16日 下午1:46:20
* 类说明 如果程序执行过程中出现异常，锁是会被默认释放的
*/
public class T {

	int count = 0;
	
	synchronized void m() {
		System.out.println(Thread.currentThread().getName() + " start");
		while(true) {
			count++;
			System.out.println(Thread.currentThread().getName() + " count:" + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count==5) {
				int i = 1/0;	//此处异常，锁会被释放，如果不想被释放，就加try-catch即可
			}
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		Runnable r = ()->t.m();
		new Thread(r, "t1").start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(r, "t2").start();
	}
	
}

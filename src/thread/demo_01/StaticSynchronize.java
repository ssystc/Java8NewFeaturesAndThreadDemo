package thread.demo_01;
/**
* @author 作者
* @version 创建时间：2019年3月16日 上午10:52:28
* 类说明
*/
public class StaticSynchronize {

	private static int count = 10;
	
	public synchronized static void m() {//和锁StaticSynchronize.class效果一样
		count--;
		System.out.println(Thread.currentThread().getName() + " : count = " + count);
	}
	
	public static void mm() {
		synchronized (StaticSynchronize.class) {  //明显不能锁this，因为是静态方法
			count--;
		}
	}
	
}

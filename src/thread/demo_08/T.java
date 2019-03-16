package thread.demo_08;
/**
* @author 作者
* @version 创建时间：2019年3月16日 下午1:42:12
* 类说明
*/
public class T {
	
	synchronized void m() {
		System.out.println("m start");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m end");
	}
	
	public static void main(String[] args) {
		new TT().m();
	}
}


class TT extends T{
	@Override
	synchronized void m() {
		System.out.println("child m start");
		super.m();
		System.out.println("child m end");
	}
}

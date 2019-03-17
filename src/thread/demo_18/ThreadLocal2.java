package thread.demo_18;

//上一个例子中一个线程中的值变了，另一个线程里的这个值也跟着变了
//可以用ThreadLocal来让上述现象不发生
//我自己的线程我自己用，别的线程用不了，所以以下代码最终输出为null

public class ThreadLocal2 {

	static ThreadLocal<Person> tl = new ThreadLocal<>();
	
	public static void main(String[] args) {
		
		new Thread(()->{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(tl.get());
		}).start();
		
		new Thread(()->{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tl.set(new Person());
		}).start();
		
	}
	
}

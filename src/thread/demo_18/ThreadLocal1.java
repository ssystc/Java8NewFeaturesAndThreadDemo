package thread.demo_18;


public class ThreadLocal1 {
	
	volatile static Person person = new Person();
	
	public static void main(String[] args) {
		new Thread(()->{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(person.name);
		}).start();
		
		new Thread(()->{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			person.name = "lisi";
		}).start();
	}

}

class Person{
	String name = "zhangsan";
}
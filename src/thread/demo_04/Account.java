package thread.demo_04;
/**
* @author 作者
* @version 创建时间：2019年3月16日 上午11:11:42
* 类说明 说明银行账户能不能只在写上加锁，答案是不能的，如下的例子，我已经存钱了，但是两次读取的钱不一样，这就是脏读现象
*/
public class Account {
	
	public String name;
	public double balance;
	
	public synchronized void set(String name, double balance) {
		
		this.name = name;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance = balance;
	}
	
	public double getBalance(String name) {
		return this.balance;
	}
	
	public static void main(String[] args) {
		Account a = new Account();
		new Thread(()->a.set("xiaoA", 100)).start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(a.getBalance("xiaoA"));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(a.getBalance("xiaoA"));
	}
	
}

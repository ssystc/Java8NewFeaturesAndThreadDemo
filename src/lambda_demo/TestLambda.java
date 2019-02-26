package lambda_demo;

/*
 * 
 * 一、lambda的基础语法（lambda需要函数式接口的支持，也就是需要有个只有一个实现方法的接口）：
 * 				java8引入一个新的操作符->，即箭头操作符，该操作符将Lambda表达式分成两部分，
 * 				左侧：Lambda表达式的参数列表
 * 				右侧：Lambda表达式中所需执行的功能，也就是那个接口的实现类需要实现的功能
 * 	语法格式1：无参数，无返回值
 * 			()->System.out.println("hello lambda")
 * 
 */

public class TestLambda {
	
	//语法格式1
	public void test1() {
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello 匿名函数类");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("hello 匿名函数类");
			}
		};
		
		Thread t = new Thread(r1);
		t.start();
		
		System.out.println("-----------------------------");
		
		Runnable r2 = ()->{
			System.out.println("hello lambda!!!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hello lambda!!!");
		};
		Thread t2 = new Thread(r2);
		t2.start();
	}
	
	public static void main(String[] args) {
		TestLambda T1 = new TestLambda();
		T1.test1();
	}
	
}

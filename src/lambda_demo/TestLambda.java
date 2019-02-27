package lambda_demo;

import java.util.Comparator;
import java.util.function.Consumer;

/*
 * 
 * 一、lambda的基础语法（lambda需要函数式接口的支持，也就是需要有个只有一个实现方法的接口）：
 * 				java8引入一个新的操作符->，即箭头操作符，该操作符将Lambda表达式分成两部分，
 * 				左侧：Lambda表达式的参数列表，列表中的参数不需要加字段类型，当然，相加的话也可以加，如：(String x) -> System.out.println(x)
 * 				右侧：Lambda表达式中所需执行的功能，也就是那个接口的实现类需要实现的功能
 * 	语法格式1：无参数，无返回值
 * 			()->System.out.println("hello lambda")
 *  
 *  语法格式2：有一个参数，并且无返回值
 *  		(x)->System.out.println("!!!!!")
 *  		只有一个参数时，参数x的括号可以省略
 *  
 *  语法格式3：有多个参数，且有返回值
 *  		(x, y) -> {
 *  		System.out.println("------");
 *  		return Integer.compare(x,y);	
 *  	};
 * 		（注意，若是lambda体中只有一行语句，则{}和return都可以省略），如下：(x, y) -> Integer.compare(x,y);	
 * 
 *  看完例子后是不是感觉还得自己写接口，有点麻烦。。放心，java8很贴心的给你提供了四个基础的函数式接口：
 *  	1、消费型接口，Consumer<T>{void accept(T t);}
 *  	2、共给型接口：Supplier<T>{T get();}
 *  	3、函数型接口：Function<T, R>{R apply(T t);}		//(和Practice里我们自己写的MyFunction完全一样有木有)
 *  	4、断言型接口：Predicate<T>{boolean test(T t);}
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

	//语法格式2
	public void test2() {
		Consumer<String> consumer = (x) -> System.out.println(x);
		consumer.accept("!!!!!!!");
	}

	//语法格式3
	public void test3() {
		Comparator<Integer> com = (x, y) -> {
			System.out.println("比较" + x + "和" + y);
			return Integer.compare(x, y);
		};
		System.out.println(com.compare(1, 2));
	}
	
	public static void main(String[] args) {
		
		TestLambda T1 = new TestLambda();
//		T1.test1();
//		T1.test2();
		T1.test3();
		
	}
	
}

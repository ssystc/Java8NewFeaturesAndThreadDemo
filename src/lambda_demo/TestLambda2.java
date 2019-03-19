package lambda_demo;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 
 * @author ssy
 *方法引用：如果lambda体中的内容已经有方法实现了，那么就可以使用方法引用了
 *		
 *语法格式有三种：对象::实例方法名
 *			类::静态方法名
 *			类::实例方法名
 *
 *注意：lambda体中使用方法的参数列表与返回值类型，要和函数式接口中抽象方法的参数裂变与返回类型相同
 *
 *
 *构造器引用：
 *		语法格式：ClassName::new
 *
 *
 *数组引用：
 *		语法格式：Type::new
 */

public class TestLambda2 {
	
	//对象::实例方法名
	public void test1() {
		PrintStream ps = System.out;
		Consumer<String> con = ps::println;
		con.accept("i want to print");
		
		User u = new User("name1", 18, 18000);
		Supplier<String> sup = ()->u.getName();
		System.out.println(sup.get());
		
		Supplier<Integer> sup1 = u::getMoney;
		sup1.get();
		System.out.println(sup1.get());
	}
	
	//类::静态方法名
	public void test2() {
		Comparator<Integer> com = (x, y)->Integer.compare(x, y);
		System.out.println(com.compare(1, 2));
		
		Comparator<Integer> com1 = Integer::compareTo;
		System.out.println(com1.compare(2, 1));
	}
	
	//类::实例方法名
	public void test3() {
		
		//当第一个参数是方法的调用者，第二个参数是方法的参数时，可以使用类名::方法名的语法格式，如下：
		BiPredicate<String, String> bi1 = (x, y)->x.equals(y);
		System.out.println(bi1.test("a", "a"));
		BiPredicate<String, String> bi2 = String::equals;
		System.out.println(bi2.test("a", "a"));
	}
	
	//构造器引用
	public void test4() {
		
		//一样的，自动匹配，自动找和传入的参数类型相匹配的构造方法
		Supplier<User> sup = ()->new User();
		System.out.println(sup.get());
		Supplier<User> sup2 = User::new;
		System.out.println(sup2.get());
		
		
		Function<Integer, User> f = User::new;
		System.out.println(f.apply(18000));
	}
	
	//数组引用，和构造器引用相似
	public void test5() {
		Function<Integer, String[]> fun = (x)->new String[x];
		System.out.println(fun.apply(6).length);
		
		Function<Integer, String[]> fun1 = String[]::new;
		System.out.println(fun1.apply(6).length);
	}
	
	
	public static void main(String[] args) {
		TestLambda2 t = new TestLambda2();
		t.test1();
		
		t.test2();
		
		t.test3();
		
		t.test4();
		
		t.test5();
	}

}

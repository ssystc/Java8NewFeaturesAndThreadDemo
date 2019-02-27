package lambda_demo;

/*
 * 声明一个带两个泛型的函数式接口，T为参数，R为返回
 * 接口声明对应抽象方法
 * 主类中写某个方法，用接口作为参数，对两个数进行某些操作
 * 
 */
public class Practice3 {

	public static Long getValue(Long l1, Long l2, MyFunction<Long, Long> myFunc) {
		return myFunc.getValue(l1, l2);
	}
	
	public static void main(String[] args) {
		Long result = getValue(100L, 200L, (e1, e2)->{
			return e1*e2;
		});
		System.out.println(result);
	}
	
}

package lambda_demo;

import com.sun.istack.internal.FinalArrayList;

/*
 * 新建一个函数式接口，声明抽象方法public String getValue(String str)
 * 编写一个方法用接口做参数，对字符串进行某些处理，并返回处理后的值
 */

public class Practice2 {
	
	public static String strHandler(String str, MyOpe ope) {
		return ope.getValue(str);
	}
	
	
	public static void main(String[] args) {
		String str = " AAA dag ";
		System.out.println(strHandler(str, (x)->{
			return x.trim() + "end";//去掉首位的空格，然后+end
		}));
	}
	
}

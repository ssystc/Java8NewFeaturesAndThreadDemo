package lambda_demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 练习1：调用collections.sort()方法，按照想要的规则对User类进行排序
 */

public class Practice1 {

	public void mySort(List<User> users) {
		Comparator<User> c = (e1, e2)->{
			if(e1.getAge() == e2.getAge()) {
				return Integer.compare(e1.getMoney(), e2.getMoney());
			}else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		};
		Collections.sort(users, c);
		for(User user : users) {
			System.out.println(user);
		}
	}
	
	public static void main(String[] args) {
		List<User> users = Arrays.asList(new User("小明", 31, 5000), 
				new User("小王", 20, 10000),
				new User("小红", 25, 9000),
				new User("小张", 26, 10000));
		Practice1 p = new Practice1();
		p.mySort(users);
	}
}

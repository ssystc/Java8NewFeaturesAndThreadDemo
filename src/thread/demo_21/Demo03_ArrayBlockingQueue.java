package thread.demo_21;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo03_ArrayBlockingQueue {

	static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
	
	static Random r = new Random();
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 10; i++) {
			strs.put("a" + i);
		}
		
//		strs.put("aaa");	//阻塞
//		strs.add("aaa");	//异常
		System.out.println(strs.offer("aaa"));	//会告诉你加没加成功
	}
	
}

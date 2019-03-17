package thread.demo_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo02_CopyOnWrite {
	
	public static void main(String[] args) {
//		List<String> lists = new ArrayList<>();
//		Vector<String> lists = new Vector<>();
		List<String> lists = new CopyOnWriteArrayList<>();
		
		Random r = new Random();
		
		Thread[] ths = new Thread[100];
		
		for(int i = 0; i < ths.length; i++) {
			Runnable runable = ()->{
				for(int j = 0; j < 1000; j++) {
					lists.add("a" + r.nextInt(10000));
				}
			};
			ths[i] = new Thread(runable);
		}
		
		runAndComputerTime(ths);
		
		System.out.println(lists.size());
	}
	
	static void runAndComputerTime(Thread[] ths) {
		long start = System.currentTimeMillis();
		Arrays.asList(ths).forEach(t->t.start());
		
		Arrays.asList(ths).forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		long end = System.currentTimeMillis();
		System.out.println(start-end);
	}

}

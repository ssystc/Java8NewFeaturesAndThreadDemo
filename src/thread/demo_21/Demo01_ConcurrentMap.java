package thread.demo_21;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

import sun.tools.jar.resources.jar;

public class Demo01_ConcurrentMap {

	public static void main(String[] args) {
		
		
//		Map<String, String> map = new Hashtable<>();
//		Map<String, String> map = new ConcurrentHashMap<>();
		Map<String, String> map = new ConcurrentSkipListMap<>();
//		Map<String, String> map = new Hashtable<>();
		
		Random r = new Random();
		
		Thread[] ths = new Thread[10];
		
		CountDownLatch latch = new CountDownLatch(ths.length);
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < ths.length; i++) {
			ths[i] = new Thread(()->{
				for(int j = 0; j < 10000; j++) map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
				latch.countDown();
			});
		}
		
		Arrays.asList(ths).forEach(t->t.start());
		
		try {
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(map.size());
		
	}
	
}

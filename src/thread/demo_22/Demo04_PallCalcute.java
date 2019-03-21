package thread.demo_22;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo04_PallCalcute {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		long start = System.currentTimeMillis();
		List<Integer> result = getPrim(0, 250000);
		System.out.println(result);
		System.out.println(result.size());
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.println("+++++++++++++++++++++++++++++++++++");
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		MyTask t1 = new MyTask(0, 100000);
		MyTask t2 = new MyTask(100001, 160000);
		MyTask t3 = new MyTask(160001, 210000);
		MyTask t4 = new MyTask(210001, 250000);
		
		Future<List<Integer>> future1 = service.submit(t1);
		Future<List<Integer>> future2 = service.submit(t2);
		Future<List<Integer>> future3 = service.submit(t3);
		Future<List<Integer>> future4 = service.submit(t4);
		
		start = System.currentTimeMillis();
		List<Integer> result1 = future1.get();
		List<Integer> result2 = future2.get();
		List<Integer> result3 = future3.get();
		List<Integer> result4 = future4.get();
		System.out.println(result1.size() + result2.size() + result3.size() + result4.size() + "");
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	public static class MyTask implements Callable<List<Integer>>{

		int start;
		int end;
		
		public MyTask(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public List<Integer> call() throws Exception {
			List<Integer> result = getPrim(start, end);
			return result;
		}

	}
	
	public static List<Integer> getPrim(int start, int end){
		List<Integer> result = new ArrayList<>();
		for(int i = start; i<=end; i++) {
			if(isPrim(i)) result.add(i);
		}
		return result;
	}
	
	public static boolean isPrim(int value) {
		for(int i = 2; i<=value/2; i++) {
			if(value%i==0) return false;
		}
		return true;
	}
	
}

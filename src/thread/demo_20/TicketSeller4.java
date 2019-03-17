package thread.demo_20;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketSeller4 {

	static Queue<String> tickets = new ConcurrentLinkedQueue<>();
	static {
		for(int i = 0; i < 1000; i++) tickets.add("编号：" + i);
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			new Thread(()->{
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String s = tickets.poll();
					if(s==null) break;
					else System.out.println("销售了：" + s);
				}
			}).start();
		}
	}
	
	
}

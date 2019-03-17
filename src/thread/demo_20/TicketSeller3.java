package thread.demo_20;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TicketSeller3 {

//	static Vector<String> tickets = new Vector<>();
	static List<String> tickets = new LinkedList<>();
	static {
		for(int i = 0; i < 1000; i++) tickets.add("编号：" + i);
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			new Thread(()->{
				while(true) {
					synchronized (tickets) {
						if(tickets.size()<=0) {break;}
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("销售了：" + tickets.remove(0));
					}
					
					
				}
			}).start();
		}
	}
	
}

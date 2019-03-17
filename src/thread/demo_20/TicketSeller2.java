package thread.demo_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TicketSeller2 {

	static Vector<String> tickets = new Vector<>();
	static {
		for(int i = 0; i < 1000; i++) tickets.add("编号：" + i);
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			new Thread(()->{
				while(tickets.size()>0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("销售了：" + tickets.remove(0));
				}
			}).start();
		}
	}
	
}

package thread.demo_20;

import java.util.ArrayList;
import java.util.List;

//别说List的remove不是原子性的就算是原子性的，判断和remove两个合起来就不原子了，看下个例子

public class TicketSeller1 {

	static List<String> tickets = new ArrayList<>();
	
	static {
		for(int i = 0; i < 10000; i++) tickets.add("编号：" + i);
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

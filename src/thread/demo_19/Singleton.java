package thread.demo_19;

import java.util.Arrays;

public class Singleton {

	private Singleton() {
		System.out.println("single");
	}
	
	private static class Inner{
		private static Singleton s = new Singleton();
	}
	
	public static Singleton getSingleton() {
		return Inner.s;
	}
	
	public static void main(String[] args) {
		Thread[] ths = new Thread[100];
		for(int i = 0; i < ths.length; i++) {
			ths[i] = new Thread(()->{
				Singleton.getSingleton();
			});
		}
		
		Arrays.asList(ths).forEach(o->o.start());
	}
}

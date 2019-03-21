package thread.demo_22;

import java.util.concurrent.Executor;

public class Demo01_MyExecutor implements Executor {

	public static void main(String[] args) {
		new Demo01_MyExecutor().execute(()->{
			System.out.println("sss");
		});
	}
	
	@Override
	public void execute(Runnable command) {
		new Thread(command).start();
	}

}

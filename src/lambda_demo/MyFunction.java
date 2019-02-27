package lambda_demo;

public interface MyFunction<T, R> {

	public R getValue(T t1, T t2); 
	
}

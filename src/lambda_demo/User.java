package lambda_demo;

public class User {

	private String name;
	private int age;
	private int money;
	
	public User() {
		
	}
	
	public User(int money) {
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public User(String name, int age, int money) {
		super();
		this.name = name;
		this.age = age;
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", money=" + money + "]";
	}
	
}

package game;

public class Player {

	private String name;
	private int age;
	private double wallet;

	public Player(String name, int age) {
		this.name = name;
		if (age <= 99) {
			this.age = age;
		} else if (age > 99) {
			this.age = 99;
		}
		this.wallet = age * 100;
	}

	public Player() {
		this.name = "Loser";
		this.age = 21;
		this.wallet = 100;
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

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return name + " ----- wallet: " + wallet + "]";
	}

	
}

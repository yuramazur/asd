package game;

import exceptions.NotEnoughMoneyException;

public class Player {

	private String name;
	private double wallet;

	public Player(String name, int age) {
		this.name = name;
		this.wallet = age * 100;
	}

	public Player() {
		this.name = "NoName";
		this.wallet = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getBet(double bet) throws NotEnoughMoneyException {
		if ((wallet - bet) < 0) {
			throw new NotEnoughMoneyException("Not Enough Money, max bet - "
					+ wallet);
		}
		wallet -= bet;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double bank) {
		this.wallet += bank;
	}

	@Override
	public String toString() {
		return name + "_" + wallet;
	}

}

package game;

import exceptions.NotEnoughMoneyException;

public class Player {

	private String name;
	private int wallet;

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

	public void getBet(int bet) throws NotEnoughMoneyException {
		if ((wallet - bet) < 0) {
			throw new NotEnoughMoneyException("Not Enough Money, max bet - "
					+ wallet);
		}
		wallet -= bet;
	}

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int bank) {
		this.wallet += bank;
	}

	@Override
	public String toString() {
		return name + "_" + wallet;
	}

}

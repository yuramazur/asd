package game;

import scanner.MyScanner;
import view.View;
import cards.Card;
import exceptions.NotEnoughMoneyException;
import exceptions.TooMuchPiontsException;

public class Game {
	private GameTable table;

	public Game(GameTable table) {
		this.table = table;
	}

	public Game(String name, int age) {
		Player player = new Player(name, age);
		table = new GameTable(player);
	}

	public GameTable getTable() {
		return table;
	}

	public void setTable(GameTable table) {
		this.table = table;
	}

	private void beginRound() throws TooMuchPiontsException {
		Card card;
		for (int i = 0; i < 2; i++) {
			card = table.getHeel().takeCard();
			table.getPlayerHand().addCard(card);
			card = table.getHeel().takeCard();
			table.getDealerHand().addCard(card);
		}
		View.displayBeginRoud(table);
	}

	private void playerTakeCard() throws TooMuchPiontsException {
		while (MyScanner
				.getYN("Take another Card?( \"Y\" - to \"Yes\" ; \"N\" - to \"No\") ")) {
			try {
				table.getPlayerHand().addCard(table.getHeel().takeCard());
			} finally {
				View.displayBeginRoud(table);
			}
		}
	}

	private void dillerTakeCard() throws TooMuchPiontsException {
		boolean flag = true;
		View.displayRoud(table);
		while (flag) {
			flag = false;
			if ((table.getDealerHand().getCardPoints() < 17 | table
					.getDealerHand().getCardPoints() < table.getPlayerHand()
					.getCardPoints())
					& table.getDealerHand().getCardPoints() != table
							.getPlayerHand().getCardPoints()) {
				flag = true;
				try {
					table.getDealerHand().addCard(table.getHeel().takeCard());
				} finally {
					View.displayRoud(table);
				}
			}
		}
	}

	private void endRound() {
		if (table.getDealerHand().getCardPoints() < table.getPlayerHand()
				.getCardPoints()) {
			table.getPlayer().setWallet(table.getBet() * 2);
			System.out.println(" Player Win!");
		} else if (table.getDealerHand().getCardPoints() > table
				.getPlayerHand().getCardPoints()) {
			System.out.println(" Diller Win!");
		}
		if (table.getDealerHand().getCardPoints() == table.getPlayerHand()
				.getCardPoints()) {
			table.getPlayer().setWallet(table.getBet());
			System.out.println(" A Draw!");
		}
	}

	private void clearHands() {
		table.getPlayerHand().clear();
		table.getDealerHand().clear();
	}

	private void startRound() throws NotEnoughMoneyException {
		View.displayTable(table);
		table.getPlayer().getBet(table.getBet());
		clearHands();
		boolean endFlag = false;
		boolean playerFlag = false;
		boolean dillerFlag = false;
		try {
			beginRound();
			playerTakeCard();
			playerFlag = true;
			dillerTakeCard();
			dillerFlag = true;
			endFlag = true;
		} catch (TooMuchPiontsException e) {
			System.out.println(e.getMessage());
		}
		if (!playerFlag) {
			System.out.println("Diller Win!");
		}
		if (playerFlag & !dillerFlag) {
			System.out.println("Player Win!");
			table.getPlayer().setWallet(table.getBet() * 2);
		}
		if (endFlag) {
			endRound();
		}
		View.displayTable(table);

	}

	public boolean start() {
		int count = 0;
		boolean flag = true;
		do {
			View.gamesDivider(++count);
			flag = false;
			try {
				startRound();
				flag = true;
			} catch (NotEnoughMoneyException e) {
				System.err.println(e.getMessage());
			}
		} while (flag
				&& MyScanner
						.getYN("One more game?( \"Y\" - to \"Yes\" ; \"N\" - to \"No\") "));
		return flag;
	}
}

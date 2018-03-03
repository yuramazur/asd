package game;

import scanner.MyScanner;
import view.View;
import cards.Card;
import exceptions.NotEnoughMoneyException;
import exceptions.TooMuchPiontsException;

public class Game {
	private GameTable table;
	int count = 0;

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
				View.displayRoudPlayer(table);
			}
		}
	}

	private void dillerTakeCard() throws TooMuchPiontsException {
		boolean flag = true;
		View.sleep(750);
		View.displayRoudDiller(table);
		View.sleep(1500);
		while (flag) {
			flag = false;
			if ((table.getDealerHand().getCardPoints() < 17)
					&& ((table.getDealerHand().getCardPoints() < table
							.getPlayerHand().getCardPoints()) & (table
							.getDealerHand().getCardPoints() != table
							.getPlayerHand().getCardPoints()))) {
				flag = true;
				try {
					table.getDealerHand().addCard(table.getHeel().takeCard());
				} finally {
					View.displayRoudDiller(table);

				}
			}
		}
	}

	private void endRound() {
		View.sleep(1500);
		View.displayRoudDiller(table);
		View.displayRoudPlayer(table);

		if (table.getDealerHand().getCardPoints() < table.getPlayerHand()
				.getCardPoints()) {
			table.getPlayer().setWallet(table.getBet() * 2);
			System.out.println(" Player Win!");
			System.out.println();
		} else if (table.getDealerHand().getCardPoints() > table
				.getPlayerHand().getCardPoints()) {
			System.out.println(" Diller Win!");
			System.out.println();
		}
		if (table.getDealerHand().getCardPoints() == table.getPlayerHand()
				.getCardPoints()) {
			table.getPlayer().setWallet(table.getBet());
			System.out.println(" A Draw!");
			System.out.println();
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
			System.out.println();
			View.displayBeginRoudDiller(table);
			View.displayRoudPlayer(table);
		}
		if (playerFlag & !dillerFlag) {
			System.out.println("Player Win!");
			System.out.println();
			table.getPlayer().setWallet(table.getBet() * 2);
			View.displayRoudDiller(table);
			View.displayRoudPlayer(table);
		}
		if (endFlag) {
			endRound();
		}
		View.displayTable(table);

	}

	public void start() {
		boolean flag = true;
		int count = table.getCount();
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
		table.setCount(count);
	}
}

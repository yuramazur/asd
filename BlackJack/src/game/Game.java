package game;

import scanner.MyScanner;
import view.View;
import cards.Card;
import exceptions.NotEnoughMoneyException;
import exceptions.TooMuchPiontsException;

public class Game {
	private GameTable table;
	int count = 0;
	double bank = 0.0;

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
		System.out.println("---- Player Begin ----");

		while (table.getPlayerHand().getCardPoints() < 21
				&& MyScanner
						.getYN("Take another Card?( \"Y\" - to \"Yes\" ; \"N\" - to \"No\") ")) {
			try {
				table.getPlayerHand().addCard(table.getHeel().takeCard());
			} finally {
				View.displayRoudPlayer(table);
			}
		}
		System.out.println("---- Player End ----");
	}

	private void dillerTakeCard() throws TooMuchPiontsException {
		boolean flag = true;
		System.out.println("---- Diller Begin ----");
		View.displayRoudDiller(table);
		if (table.getDealerHand().cardPoints() >= 17
				& table.getDealerHand().getCardPoints() > table.getPlayerHand()
						.getCardPoints()) {
			flag = false;
		}
		while (flag) {
			flag = false;
			try {
				if (table.getDealerHand().getCardPoints() < 17) {
					flag = true;
					table.getDealerHand().addCard(table.getHeel().takeCard());

				}
			} finally {
				View.sleep(750);
				View.displayRoudDiller(table);
			}
		}
		System.out.println("---- Diller Eng ----");
	}

	private void endRound() {

		if (table.getDealerHand().getCardPoints() < table.getPlayerHand()
				.getCardPoints()) {
			table.getPlayer().setWallet(bank);
			System.out.println(" Player Win!");
			System.out.println();
		} else if (table.getDealerHand().getCardPoints() > table
				.getPlayerHand().getCardPoints()) {
			System.out.println(" Diller Win!");
			System.out.println();
		}
		if (table.getDealerHand().getCardPoints() == table.getPlayerHand()
				.getCardPoints() & table.getDealerHand().getCardPoints() >= 17) {
			table.getPlayer().setWallet(bank / 2);
			System.out.println(" A Draw!");
			System.out.println();
		}
		View.sleep(500);
		View.displayRoudDiller(table);
		View.displayRoudPlayer(table);

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
			if (table.getPlayerHand().getCardPoints() == 21) {
				if (table.getDealerHand().getHand().get(0).getIndex()
						.getPoints() < 10) {
					System.out.println("---- BLACK JACK ----");
					table.getPlayer().setWallet(bank * 1.25);
					View.displayTable(table);
					return;
				}
				if (table.getDealerHand().getHand().get(0).getIndex()
						.getPoints() == 11) {
					System.out.println("Continue or win 1 to 1 :");
					if (!MyScanner
							.getYN("\"Y\" - to \"Continue\" ; \"N\" - to \" Win 1 to 1\"")) {
						table.getPlayer().setWallet(bank);
						View.displayTable(table);
						return;
					}
					bank *= 1.25;
				}
				if (table.getDealerHand().getHand().get(0).getIndex()
						.getPoints() == 10) {
					bank *= 1.25;
				}
			}
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
			View.displayBeginRoud(table);
		}
		if (playerFlag & !dillerFlag) {
			System.out.println("Player Win!");
			System.out.println();
			table.getPlayer().setWallet(bank);
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
			bank = table.getBet() * 2;
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

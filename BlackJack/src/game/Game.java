package game;

import scanner.MyScanner;
import view.View;
import cards.Card;

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

	private boolean beginRound() {
		Card card;
		for (int i = 0; i < 2; i++) {
			card = table.getHeel().takeCard();
			table.getPlayerHand().addCard(card);
			card = table.getHeel().takeCard();
			table.getDealerHand().addCard(card);
		}
		if (table.getPlayerHand().getCardPoints() == 21) {
			if (table.getDealerHand().getHand().get(0).getIndex().getPoints() < 10) {
				System.out.println("---- BLACK JACK ----");
				table.getPlayer().setWallet(bank * 1.25);
				View.displayBeginRoud(table);
				return false;
			}
			if (table.getDealerHand().getHand().get(0).getIndex().getPoints() == 11) {
				System.out.println("Continue or win 1 to 1 ? :");
				if (!MyScanner.getYN(View.winOneToOneMasege())) {
					table.getPlayer().setWallet(bank);
					View.displayBeginRoud(table);
					return false;
				}
				bank *= 1.25;
			}
			if (table.getDealerHand().getHand().get(0).getIndex().getPoints() == 10) {
				bank *= 1.25;
			}
		}
		View.displayBeginRoud(table);
		return true;
	}

	private boolean playerTakeCard() {
		while (MyScanner.getYN(View.raundMasege())) {
			table.getPlayerHand().addCard(table.getHeel().takeCard());
			if (table.getPlayerHand().getCardPoints() == 21) {
				View.displayRoudPlayer(table);
				return true;
			}
			if (table.getPlayerHand().getCardPoints() > 21) {
				View.displayRoudPlayer(table);
				return false;
			}
			View.displayRoudPlayer(table);
		}
		return true;
	}

	private boolean dillerTakeCard() {
		boolean flag = true;
		System.out.println("---- Diller Begin ----");
		System.out.println();
		View.displayRoudDiller(table);
		if (table.getDealerHand().getCardPoints() >= 17
				& table.getDealerHand().getCardPoints() > table.getPlayerHand()
						.getCardPoints()) {
			flag = false;
		}
		while (flag) {
			flag = false;
			if (table.getDealerHand().getCardPoints() < 17) {
				flag = true;
				table.getDealerHand().addCard(table.getHeel().takeCard());
				View.sleep(750);
				View.displayRoudDiller(table);
			}
		}
		if (table.getDealerHand().getCardPoints() > 21) {
			System.out.println();
			table.getPlayer().setWallet(bank);
			return false;
		}
		System.out.println("---- Diller Eng ----");
		System.out.println();
		return true;
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

	private boolean startRound() {
		int count = table.getCount();
		View.gamesDivider(++count);
		View.displayTable(table);
		bank = table.getBet() * 2;
		if (!table.getPlayer().getBet(table.getBet())) {
			return false;
		}
		clearHands();
		if (beginRound()) {
			if (playerTakeCard()) {
				if (dillerTakeCard()) {
					endRound();
				}
			}
		}
		View.displayTable(table);
		table.setCount(count);
		return true;
	}

	public void startGame() {
		while ((MyScanner.getYN(View.gameMasege())) && (startRound())) {

		}
	}
}

package game;

import scanner.MyScanner;
import view.View;
import cards.Card;

public class Game {
	private GameTable table;
	private double bank = 0.0;
	boolean bonus = false;

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

	private void clearHands() {
		table.getPlayerHand().clear();
		table.getDealerHand().clear();
	}

	private void win() {
		if (bonus) {
			bank *= 1.5;
		}
		table.getPlayer().setWallet(bank);
		View.displayWinLoseMessage(bank, true);
	}

	private void lose() {
		table.getPlayer().getBet(table.getBet());
		View.displayWinLoseMessage(table.getBet(), false);
	}

	private void draw() {
		View.displayDraw();
	}

	private boolean beginRound() {
		bonus = false;
		Card card;
		for (int i = 0; i < 2; i++) {
			card = table.getHeel().takeCard();
			table.getPlayerHand().addCard(card);
			card = table.getHeel().takeCard();
			table.getDealerHand().addCard(card);
		}
		if (table.getPlayerHand().getCardPoints() == 21) {
			if (table.getDealerHand().getHand().get(0).getIndex().getPoints() < 10) {
				View.diaplayMessage("BLACK", "JACK");
				bonus = true;
				win();
				View.displayBeginRoud(table);
				return false;
			}
			if (table.getDealerHand().getHand().get(0).getIndex().getPoints() == 11) {
				View.displayBeginRoud(table);
				View.displayWinOneToOneMessage();
				if (!MyScanner.getYN(View.winOneToOneMessage())) {
					table.getPlayer().setWallet(bank);
					bonus = false;
					win();
					return false;
				}
				bonus = true;
			}
			if (table.getDealerHand().getHand().get(0).getIndex().getPoints() == 10) {
				bonus = true;
			}
		}
		View.displayBeginRoud(table);
		return true;
	}

	private boolean playerTakeCard() {
		View.diaplayMessage(table.getPlayer().getName(), "Begin");
		while (MyScanner.getYN(View.raundMessage())) {
			table.getPlayerHand().addCard(table.getHeel().takeCard());
			if (table.getPlayerHand().getCardPoints() == 21) {
				View.displayRoudPlayer(table);
				View.diaplayMessage(table.getPlayer().getName(), "End");
				return true;
			}
			if (table.getPlayerHand().getCardPoints() > 21) {
				View.displayRoudPlayer(table);
				View.displayBusted(table.getPlayerHand());
				View.diaplayMessage(table.getPlayer().getName(), "End");
				lose();
				return false;
			}
			View.displayRoudPlayer(table);
		}
		View.diaplayMessage(table.getPlayer().getName(), "End");
		return true;
	}

	private boolean dillerTakeCard() {
		boolean flag = true;
		View.diaplayMessage("Diller", "Begin");
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
			View.displayBusted(table.getDealerHand());
			View.diaplayMessage("Diller", "End");
			win();
			return false;
		}
		View.diaplayMessage("Diller", "End");
		return true;
	}

	private void endRound() {
		if (table.getDealerHand().getCardPoints() < table.getPlayerHand()
				.getCardPoints()) {

			win();
		} else if (table.getDealerHand().getCardPoints() > table
				.getPlayerHand().getCardPoints()) {
			lose();
		}
		if (table.getDealerHand().getCardPoints() == table.getPlayerHand()
				.getCardPoints() & table.getDealerHand().getCardPoints() >= 17) {
			draw();
		}
		View.sleep(500);
		View.displayRoudDiller(table);
		View.displayRoudPlayer(table);

	}

	private boolean startRound() {
		int count = table.getCount();
		View.gamesDivider(++count);
		View.displayTable(table);

		if (table.getPlayer().getWallet() < table.getBet()) {
			if (table.getPlayer().getWallet() == 0) {
				View.displayWalletEnd();
			}
			View.displayWalletProblem(table);
			return false;
		}
		bank = table.getBet();
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
		View.displayTable(table);
		while ((MyScanner.getYN(View.gameMessage())) && (startRound())) {

		}
	}
}

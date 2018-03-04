package view;

import cards.Card;
import cards.Hand;
import game.GameTable;

public class View {

	public static void menu() {
		System.out.println(" 1) Start new Game :");
		System.out.println(" 2) Download Game  :");
		System.out.println(" 3) Save Game      :");
		System.out.println(" 4) Change a bet   :");
		System.out.println(" 5) Continue Game  :");
		System.out.println(" 0) Exit           :");
	}

	public static void displayHand(Hand hand) {
		System.out
				.println("----------------------------------------------------------");
		for (Card card : hand.getHand()) {
			sleep(200);
			System.out.print(card);
		}
		System.out.println();
		System.out
				.println("----------------------------------------------------------");
	}

	private static void displayDillerHand(Hand hand) {
		System.out
				.println("----------------------------------------------------------");
		System.out.print(hand.getHand().get(0));
		sleep(200);
		System.out.print("[?]");
		System.out.println();
		System.out
				.println("----------------------------------------------------------");
	}

	public static void displayRoudPlayer(GameTable table) {

		System.out
				.printf("| %-20s| %-10s %-5s\n", table.getPlayer().getName()
						+ " hand :", " Points :", table.getPlayerHand()
						.getCardPoints());
		displayHand(table.getPlayerHand());

	}

	public static void displayRoudDiller(GameTable table) {
		System.out.printf("| %-20s| %-10s %-5s\n", "Diller hand :",
				" Points :", table.getDealerHand().getCardPoints());

		displayHand(table.getDealerHand());
	}

	public static void displayBeginRoudDiller(GameTable table) {
		System.out.printf("| %-20s| %-10s %-5s\n", "Diller hand :",
				" Points :", table.getDealerHand().getCardPoints());
		displayDillerHand(table.getDealerHand());
	}

	public static void displayBeginRoud(GameTable table) {
		System.out.printf("| %-20s| %-10s %-5s\n", "Diller hand :",
				" Points :", table.getDealerHand().getHand().get(0).getIndex()
						.getPoints());
		displayDillerHand(table.getDealerHand());
		System.out
				.printf("| %-20s| %-10s %-5s\n", table.getPlayer().getName()
						+ " hand :", " Points :", table.getPlayerHand()
						.getCardPoints());
		displayHand(table.getPlayerHand());
	}

	public static void displayTable(GameTable table) {
		System.out
				.println("----------------------------------------------------------");
		System.out.printf("| %-20s| %-20s| %-20s\n", "Player:", "Wallet $ :",
				"Bet : ");
		System.out.printf("| %-20s| %-20s| %-20s\n", table.getPlayer()
				.getName(), table.getPlayer().getWallet(), table.getBet());
		System.out
				.println("----------------------------------------------------------");
	}

	public static void gamesDivider(int number) {
		System.out
				.println("----------------------------------------------------------");
		System.out.println("--------------------------Round №" + number
				+ "--------------------------");
		System.out
				.println("----------------------------------------------------------");
	}

	public static void gamesDivider() {
		System.out
				.println("----------------------------------------------------------");

		System.out
				.println("----------------------------------------------------------");
	}

	public static void changingHeel() {
		try {
			System.out.println("----- Heel needs to be changed -----");
			Thread.sleep(1000);
			System.out.println("----- Dealer changing the Heel -----");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleep(int sleep) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

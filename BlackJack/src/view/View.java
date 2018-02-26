package view;

import cards.Card;
import cards.Hand;
import game.GameTable;

public class View {

	public static void menu() {
		System.out.println(" 1) Start new Game :");
		System.out.println(" 2) Change a bet   :");
		System.out.println(" 3) Continue Game  :");
		System.out.println(" 0) Exit           :");
	}

	public static void displayHand(Hand hand) {
		System.out
				.println("----------------------------------------------------------");
		for (Card card : hand.getHand()) {
			System.out.print(card);
		}
		System.out.println();
		System.out
				.println("----------------------------------------------------------");
	}

	private static void displayDillerHand(Hand hand) {
		System.out
				.println("----------------------------------------------------------");
		for (int i = 0; i < hand.getHand().size() - 1; i++) {
			System.out.print(hand.getHand().get(i));
		}
		System.out.print("[?]");
		System.out.println();
		System.out
				.println("----------------------------------------------------------");
	}

	public static void displayRoud(GameTable table) {
		System.out.printf("| %-20s| %-10s %-5s\n", "Diller hand :",
				" Points :", table.getDealerHand().getCardPoints());

		displayHand(table.getDealerHand());
		System.out
				.printf("| %-20s| %-10s %-5s\n", table.getPlayer().getName()
						+ " hand :", " Points :", table.getPlayerHand()
						.getCardPoints());
		displayHand(table.getPlayerHand());

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
}

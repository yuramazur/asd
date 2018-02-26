package game;

import scanner.MyScanner;
import view.View;

public class Menu {
	private Game game;

	public Menu() {
		game = new Game("NoName", 21);
	}

	public void start() {
		
		boolean swch = true;
		while (swch) {
			View.menu();
			switch (MyScanner.menuChoice(0, 3)) {
			case 1:
				System.out.println(" 1) Start new Game :");
				System.out.println("Enter player name :");
				String name = MyScanner.inputName();
				System.out.println("Enter player age :");
				int age = MyScanner.inputIntNumbers();
				game = new Game(name, age);
				game.start();
					break;
			

			case 2:
				System.out.println(" 2) Change a bet   :");
				System.out.println(" Current bet is : "
						+ game.getTable().getBet());
				System.out.println(" Enter a number from : 1 to "
						+ game.getTable().getPlayer().getWallet());
				int bet = MyScanner.menuChoice(1, game.getTable().getPlayer()
						.getWallet());
				game.getTable().setBet(bet);
				System.out.println(" Current bet is : "
						+ game.getTable().getBet());
				break;
			case 3:
				game.start();
				break;
			case 0:
				swch = false;
				System.out.println(" ------------- Goodbye! ------------- ");
				break;
			}
		}
	}
}
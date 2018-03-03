package game;

import saves.GameSaver;
import scanner.MyScanner;
import view.View;

public class Menu {
	private Game game;
	private GameSaver saver;

	public Menu() {
		game = new Game("NoName", 21);
		saver = new GameSaver(game.getTable());
	}

	public void start() {

		boolean swch = true;
		while (swch) {
			View.menu();
			switch (MyScanner.menuChoice(0, 5)) {
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
				System.out.println(" 2) Download Game :");
				System.out.println("Enter save nnumber :");
				saver.setTable(game.getTable());
				System.out.println("0) Return to Menu : ");
				saver.displaySaves();
				int number = MyScanner.menuChoice(0, saver.savesNumber());
				if (number > 0) {
					game.setTable(saver.download(number));
				}
				break;
			case 3:
				System.out.println(" 3) Save Game :");
				saver.setTable(game.getTable());
				saver.save();
				System.out.println(" --- Game Saved --- ");
				break;
			case 4:
				System.out.println(" 4) Change a bet   :");
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
			case 5:
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
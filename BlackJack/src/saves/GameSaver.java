package saves;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import saves.engine.FileEngine;
import game.GameTable;
import game.Player;

public class GameSaver {
	private GameTable table;
	private Calendar calendar = Calendar.getInstance();
	private FileEngine file;

	public GameSaver() {
		file = new FileEngine("saves.txt");
	}

	public GameSaver(GameTable table) {
		this.table = table;
		file = new FileEngine("saves.txt");
	}

	public FileEngine getFile() {
		return file;
	}

	public void setFile(FileEngine file) {
		this.file = file;
	}

	public GameTable getTable() {
		return table;
	}

	public void setTable(GameTable table) {
		this.table = table;
	}

	private String tableToString() {
		StringBuffer sb = new StringBuffer("");
		sb.append(calendar.getTime());
		sb.append("_");
		sb.append(table.getPlayer().toString());
		sb.append("_");
		sb.append(table.getBet());
		sb.append("_");
		sb.append(table.getCount());
		return sb.toString();

	}

	public void save() {
		try {
			file.writeLine(tableToString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private GameTable stringToTable(String line) {
		Player player = new Player();
		String[] arr = line.split("_");
		if (arr.length == 5) {
			player.setName(arr[1]);
			player.setWallet(Integer.parseInt(arr[2]));
			GameTable table = new GameTable(player);
			table.setBet(Integer.parseInt(arr[3]));
			table.setCount(Integer.parseInt(arr[4]));
			return table;
		}
		return null;
	}

	public GameTable download(int number) {
		GameTable table = null;
		try {
			table = stringToTable(file.readAll().get((savesNumber() - number)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return table;
	}

	public void displaySaves() {
		List<String> list;
		try {
			list = file.readAll();
			for (int i = 0; i < list.size(); i++) {
				System.out.println((i + 1)
						+ ")"
						+ list.get(list.size() - 1 - i)
								.replaceFirst("_", "  [ ")
								.replaceFirst("_", " - Wallet: ")
								.replaceFirst("_", "\\$ - Bet: ")
								.replaceFirst("_", "\\$ - round № : ") + " ]");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int savesNumber() {
		int number = 0;
		try {
			number = file.readAll().size();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return number;
	}
}

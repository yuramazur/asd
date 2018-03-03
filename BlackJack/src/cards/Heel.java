package cards;

import java.util.ArrayList;
import java.util.List;

public class Heel {
	private List<Card> heel;
	private int decksAmount;

	public Heel() {
		heel = new ArrayList<Card>();
		decksAmount = 6;
		fillHeel(decksAmount);
	}

	public Heel(int decksAmount) {
		if (decksAmount <= 0) {
			this.decksAmount = 1;
		} else {
			this.decksAmount = decksAmount;
		}
		heel = new ArrayList<Card>();
		fillHeel(decksAmount);
	}

	private void fillHeel(int decksAmount) {
		for (int i = 0; i < decksAmount; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			heel.addAll(deck.getDeck());
		}
	}

	public List<Card> getHeel() {
		return heel;
	}

	public void setHeel(List<Card> heel) {
		this.heel = heel;
	}

	public Card takeCard() {
		if (heel.size() < (decksAmount * 52 / 3)) {
			fillHeel(decksAmount);
		}
		Card takenCard = heel.get(0);
		heel.remove(0);
		return takenCard;
	}

}

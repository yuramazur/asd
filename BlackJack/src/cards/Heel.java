package cards;

import java.util.ArrayList;
import java.util.List;

public class Heel {
	private List<Card> heel;

	public Heel() {
		heel = new ArrayList<Card>();
		for (int i = 0; i < 6; i++) {
			DeckOfCards deck = new DeckOfCards();
			deck.shuffleDeck();
			heel.addAll(deck.getDeck());
		}
	}

	public Heel(int decksAmount) {
		heel = new ArrayList<Card>();
		for (int i = 0; i < decksAmount; i++) {
			DeckOfCards deck = new DeckOfCards();
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
    public Card takeCard(){
    	Card takenCard = heel.get(0);
    	heel.remove(0);
    	return  takenCard;
    }
	
	
}

package cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private List<Card> hand;
	private int cardWeight;

	public Hand() {
		hand = new ArrayList<Card>();
		cardWeight = 0;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public void addCard(Card card) {
		hand.add(card);
		cardWeight = cardWeight + card.getDig().getDignity();
	}

	public int getCardWeight() {
		return cardWeight;
	}

	@Override
	public String toString() {
		return "Hand [" + hand + "," + cardWeight + "]";
	}

}

package cards;

import java.util.Set;
import java.util.TreeSet;

public class Hand {

	private Set<Card> hand;
	private int cardWeight;

	public Hand() {
		hand = new TreeSet<Card>();
		cardWeight = 0;
	}

	public Set<Card> getHand() {
		return hand;
	}

	public void setHand(Set<Card> hand) {
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

package cards;

import java.util.Set;
import java.util.TreeSet;

public class Hand {

	private Set<Card> hand;
	private int cardPoints;

	public Hand() {
		hand = new TreeSet<Card>();
		cardPoints = 0;
	}

	public Set<Card> getHand() {
		return hand;
	}

	public void setHand(Set<Card> hand) {
		this.hand = hand;
	}

	public void addCard(Card card) {
		hand.add(card);
		cardPoints = cardPoints + card.getIndex().getPoints();
	}

	public int getCardPoints() {
		return cardPoints;
	}

	@Override
	public String toString() {
		return "Hand [" + hand + "," + cardPoints + "]";
	}

}

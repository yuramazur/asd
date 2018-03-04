package cards;

import java.util.ArrayList;
import java.util.List;

import cards.enums.Index;

public class Hand {

	private List<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();

	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	private int cardPoints() {
		int points = 0;
		for (Card card : hand) {
			points += card.getIndex().getPoints();
		}
		return points;
	}

	public int addCard(Card card) {
		hand.add(card);

		if (cardPoints() > 21) {
			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).getIndex().getPoints() == 11) {
					hand.set(i, new Card(Index.ACE1, hand.get(i).getSuit()));
					break;
				}
			}
		}
		return cardPoints();
	}

	public int getCardPoints() {
		return cardPoints();
	}

	public void clear() {
		hand.clear();

	}

	@Override
	public String toString() {
		return "Hand [" + hand + "," + cardPoints() + "]";
	}

}

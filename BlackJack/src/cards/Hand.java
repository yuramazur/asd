package cards;

import java.util.ArrayList;
import java.util.List;

import cardsEnums.Index;
import exceptions.TooMuchPiontsException;

public class Hand {

	private List<Card> hand;
	private int cardPoints;

	public Hand() {
		hand = new ArrayList<Card>();
		cardPoints = 0;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public void addCard(Card card) throws TooMuchPiontsException {
		hand.add(card);
		cardPoints += card.getIndex().getPoints();
		if (card.getIndex().equals(Index.ACE) && cardPoints > 21) {
			cardPoints -= 10;
		}
		if (cardPoints > 21) {
			throw new TooMuchPiontsException(
					"                                 Too Much : " + cardPoints);
		}
	}

	public int getCardPoints() {
		return cardPoints;
	}

	public void clear() {
		hand.clear();
		cardPoints = 0;
	}

	@Override
	public String toString() {
		return "Hand [" + hand + "," + cardPoints + "]";
	}

}

package cards;

import cardsEnums.Index;
import cardsEnums.Suit;

public class Card {
	private Index index;
	private Suit suit;

	public Card(Index index, Suit suit) {
		this.index = index;
		this.suit = suit;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		String correction = " ";
		if (index.getPicture().equals("10")) {
			correction = "";
		}
		return correction + "[" + index.getPicture() + suit.getPicture() + "]";
	}



}

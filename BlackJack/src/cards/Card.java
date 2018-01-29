package cards;

import cardsEnums.Dignity;
import cardsEnums.Suit;

public class Card {
	private Dignity dig;
	private Suit suit;

	public Card(Dignity dig, Suit suit) {
		this.dig = dig;
		this.suit = suit;
	}

	public Dignity getDig() {
		return dig;
	}

	public void setDig(Dignity dig) {
		this.dig = dig;
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
		if (dig.getPicture().equals("10")) {
			correction = "";
		}
		return correction + "[" + dig.getPicture() + suit.getPicture() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dig == null) ? 0 : dig.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (dig != other.dig)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}

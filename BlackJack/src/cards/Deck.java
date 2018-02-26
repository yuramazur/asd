package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cardsEnums.Index;
import cardsEnums.Suit;

public class Deck {
	private List<Card> deck = new ArrayList<Card>();
	private Index[] arrDig = Index.values();
	private Suit[] arrSuit = Suit.values();

	public Deck() {
		for (int j = 0; j < arrSuit.length; j++) {
			for (int i = 0; i < arrDig.length; i++) {
				deck.add(new Card(arrDig[i], arrSuit[j]));
			}
		}
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public void shuffleDeck() {
		List<Card> deck1 = new ArrayList<Card>();
		List<Card> deck2 = new ArrayList<Card>();
		List<Card> tempDeck = new ArrayList<Card>();
		Random random = new Random();
		int size = deck.size() / 2;
		int num = 0;

		for (int j = 0; j <= (random.nextInt(deck.size()) + 1); j++) {
			for (int i = 0; i < size; i++) {
				deck1.add(deck.get(i));
				deck2.add(deck.get(size + i));
			}
			deck.clear();
			for (int i = 0; i < size; i++) {
				if (random.nextBoolean()) {
					deck.add(deck1.get(i));
					deck.add(deck2.get(size - 1 - i));
				} else {
					deck.add(deck1.get(size - 1 - i));
					deck.add(deck2.get(i));
				}
			}

			for (int i = 0; i < 1000; i++) {
				while (deck.size() != 0) {
					num = random.nextInt(deck.size());
					tempDeck.add(deck.get(num));
					deck.remove(num);
				}
				deck.addAll(tempDeck);
				tempDeck.clear();
			}
		}

	}

	@Override
	public String toString() {
		String str = "";
		int count = 0;
		for (int i = 0; i < deck.size(); i++) {
			str = str + deck.get(i).toString() + " ";
			count++;
			if (count == arrDig.length) {
				str = str + '\n';
				count = 0;
			}
		}

		return str;
	}

}

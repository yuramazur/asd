package comparators;

import java.util.Comparator;

import cards.Card;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		if (o1.getSuit().getPriority() != o2.getSuit().getPriority())
			return o1.getSuit().getPriority() - o2.getSuit().getPriority();
		return o1.getIndex().getPriority() - o2.getIndex().getPriority();
	}

}

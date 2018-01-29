package main;


import cards.DeckOfCards;


public class Main {

	public static void main(String[] args) {
		
		 DeckOfCards deck1 = new DeckOfCards();
		 DeckOfCards deck2 = new DeckOfCards();
		 System.out.println(deck1);
		 System.out.println("---------------------------------------------------------------------------------------");
		 deck1.shuffleDeck();
		 System.out.println(deck1);
		 System.out.println("---------------------------------------------------------------------------------------");
		 deck2.shuffleDeck();
		 System.out.println(deck2);
//		Hand hand = new Hand();
//		hand.addCard(deck.getDeck().get(0));
//		hand.addCard(deck.getDeck().get(1));
//		System.out.println(hand);
		 
//	Card card = new Card(Dignity.ACE,Suit.DIAMONDS);
//	System.out.println(card);

	
	}

}

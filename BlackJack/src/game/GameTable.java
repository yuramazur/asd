package game;

import cards.Hand;
import cards.Heel;

public class GameTable {
private Player player;
private Heel heel;
private Hand dealerHand = new Hand();
private Hand playerHand = new Hand();
private int bet = 0;

public GameTable(Player player) {
	this.player = player;
	heel = new Heel();
	bet = 100;
}

public Player getPlayer() {
	return player;
}

public void setPlayer(Player player) {
	this.player = player;
}

public Heel getHeel() {
	return heel;
}

public void setHeel(Heel heel) {
	this.heel = heel;
}

public Hand getDealerHand() {
	return dealerHand;
}

public void setDealerHand(Hand dealerHand) {
	this.dealerHand = dealerHand;
}

public Hand getPlayerHand() {
	return playerHand;
}

public void setPlayerHand(Hand playerHand) {
	this.playerHand = playerHand;
}

public int getBet() {
	return bet;
}

public void setBet(int bet) {
	this.bet = bet;
}


}

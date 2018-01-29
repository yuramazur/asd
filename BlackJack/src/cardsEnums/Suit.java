package cardsEnums;

public enum Suit {
	CLUBS(0,"\u2663"), DIAMONDS(1,"\u2666"), HEARTS(2,"\u2665"), SPADES(3,"\u2660");

	private String picture;
	private int priority;

	private Suit(int priority, String picture) {
		this.priority = priority;
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}

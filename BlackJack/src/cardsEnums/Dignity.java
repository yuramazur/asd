package cardsEnums;

public enum Dignity {

	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), KNAVE(10), QUEEN(10), KING(
			10), ACE(11);

	private int dignity;

	private Dignity(int dignity) {
		this.dignity = dignity;
	}

	public int getDignity() {
		return dignity;
	}

	public void setDignity(int dignity) {
		this.dignity = dignity;
	}

}

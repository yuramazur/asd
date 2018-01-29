package cardsEnums;

public enum Dignity {

	TWO(2,"2"), THREE(3,"3"), FOUR(4,"4"), FIVE(5,"5"), SIX(6,"6"), SEVEN(7,"7"), EIGHT(8,"8"), NINE(9,"9"), TEN(
			10,"10"), JAKE(10,"J"), QUEEN(10,"Q"), KING(10,"K"), ACE(11,"A");

	private int dignity;
	private String picture;

	private Dignity(int dignity, String picture) {
		this.dignity = dignity;
		this.picture = picture;
	}

	public int getDignity() {
		return dignity;
	}

	public void setDignity(int dignity) {
		this.dignity = dignity;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	

}

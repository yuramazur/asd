package cards.enums;

public enum Index {

	TWO(0, 2, "2"), THREE(1, 3, "3"), FOUR(2, 4, "4"), FIVE(3, 5, "5"), SIX(4,
			6, "6"), SEVEN(5, 7, "7"), EIGHT(6, 8, "8"), NINE(7, 9, "9"), TEN(
			8, 10, "10"), JAKE(9, 10, "J"), QUEEN(10, 10, "Q"), KING(11, 10,
			"K"), ACE(12, 11, "A");
	private int priority;
	private int points;
	private String picture;

	private Index(int priority, int points, String picture) {
		this.priority = priority;
		this.points = points;
		this.picture = picture;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints (int points) {
		this.points = points;
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

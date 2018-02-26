package exceptions;

public class NotEnoughMoneyException extends GameException  {

	private static final long serialVersionUID = 6840666238096669479L;

	public NotEnoughMoneyException(String message) {
		super(message);
		
	}

}

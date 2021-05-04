package exceptions;

public class IdNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE_ERROR = "Register_Not_Found";
	
	public IdNotFoundException() {
		super(MESSAGE_ERROR);
	}
}

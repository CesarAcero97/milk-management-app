package exceptions;

public class NotSelectionRow extends Exception{

	
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE_ERROR = "Select_Municipality";
	
	public  NotSelectionRow() {
		super(MESSAGE_ERROR);
	}
}

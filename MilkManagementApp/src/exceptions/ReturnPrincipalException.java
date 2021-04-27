package exceptions;

public class ReturnPrincipalException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public static final String MESSAGE_ERROR ="Return_Principal_Table";
	
	public ReturnPrincipalException() {
		super(MESSAGE_ERROR);
	}
}

package exceptions;

public class   FieldsNullException extends Exception{

	private static final long serialVersionUID = 1L;
	

	public static  final String MESSAGE_ERROR = "Message_Exception_FieldsNull";
	
	public FieldsNullException() {
		super(MESSAGE_ERROR);
	}
	
	
}

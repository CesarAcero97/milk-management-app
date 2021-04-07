package exceptions;

public class IncompleteEntryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String MSG_INCOMPLETE = "La entrada de datos no está completa";
	
	public IncompleteEntryException() {
		super(MSG_INCOMPLETE);
	}

}

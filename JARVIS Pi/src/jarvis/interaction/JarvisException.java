package jarvis.interaction;

public class JarvisException extends Exception {
	
	private static final long serialVersionUID = 7040079993807569114L;
	
	private static final String MESSAGE_HEADER = "Jarvis error: ";
	
	public JarvisException(String message, Throwable t) {
		super(MESSAGE_HEADER + message, t);
	}
	
	public JarvisException(String message) {
		super(MESSAGE_HEADER + message);
	}
}

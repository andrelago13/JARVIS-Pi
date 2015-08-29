package jarvis.interaction.state;

public interface JarvisMainState {
	public Boolean hasContext();
	public void setContext(JarvisMainContext context);
	public void initiate();
	public void receiveString(String message);
	public void end();
	
	public static Boolean isStateMessage(String message) {
		return false;
	}
}

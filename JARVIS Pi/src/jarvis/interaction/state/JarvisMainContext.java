package jarvis.interaction.state;

public interface JarvisMainContext {
	public void receiveString(String message);
	public void setState(JarvisMainState state);
	public void respondToUser(String message);
}

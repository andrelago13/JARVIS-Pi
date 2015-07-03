package jarvis.interaction.state;

public interface State {
	public boolean isInterested(String message);
	public void activate(String message);
}

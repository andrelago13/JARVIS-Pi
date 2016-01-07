package jarvis.interaction.state;

import designpatterns.Context;

public interface MainJarvisContext extends Context {
	
	public void activate();
	public void deactivate();
	public void replyToUser(String message);
	public MainJarvisState getState();
	public void setState(MainJarvisState state);
	public void getUserInput();

}

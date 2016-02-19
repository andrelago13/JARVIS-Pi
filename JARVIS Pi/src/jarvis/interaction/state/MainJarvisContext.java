package jarvis.interaction.state;

import designpatterns.Context;

public interface MainJarvisContext extends Context {
	
	public void activate();
	public void deactivate();
	public void execute();
	public void replyToUser(String message);
	public MainJarvisState getState();
	public void setState(MainJarvisState state);
	public String getUserInput();
	public Boolean isActive();
	public void run();

}

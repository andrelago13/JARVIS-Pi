package jarvis.interaction.state;

import designpatterns.Context;
import jarvis.interaction.JarvisException;

public interface MainJarvisContext extends Context {
	
	public void activate() throws JarvisException;
	public void deactivate();
	public void execute();
	public void replyToUser(String message);
	public MainJarvisState getState();
	public void setState(MainJarvisState state);
	public String getUserInput();
	public Boolean isActive();
	public void run() throws JarvisException;

}

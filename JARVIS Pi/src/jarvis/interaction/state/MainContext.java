package jarvis.interaction.state;

import designpatterns.Context;

public interface MainContext extends Context {
	
	public void activate();
	public void deactivate();
	public void replyToUser(String message);
	public String getUserName();

}

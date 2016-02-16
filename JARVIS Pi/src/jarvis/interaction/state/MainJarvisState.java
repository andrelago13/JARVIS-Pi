package jarvis.interaction.state;

import designpatterns.State;

public interface MainJarvisState extends State {

	public MainJarvisContext getContext();
	public void setContext(MainJarvisContext context);
	public void handle(String message);
	public void execute();
	public Boolean isActive();
}

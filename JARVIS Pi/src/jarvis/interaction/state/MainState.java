package jarvis.interaction.state;

import designpatterns.State;

public interface MainState extends State {

	public String toString();
	public MainContext getContext();
	public void setContext(MainContext context);

}

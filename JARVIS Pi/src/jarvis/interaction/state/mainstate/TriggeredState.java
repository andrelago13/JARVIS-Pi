package jarvis.interaction.state.mainstate;

import jarvis.interaction.state.MainJarvisContext;
import jarvis.interaction.state.MainJarvisState;

public class TriggeredState implements MainJarvisState {
	
	private MainJarvisContext context;

	@Override
	public void activate() {
		context.getUserInput();
	}

	@Override
	public void deactivate() {}

	@Override
	public MainJarvisContext getContext() {
		return context;
	}

	@Override
	public void setContext(MainJarvisContext context) {
		this.context = context;
	}

	@Override
	public void handle(String message) {
		// TODO Auto-generated method stub
		
	}
	
	

}

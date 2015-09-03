package jarvis.interaction;

import designpatterns.State;
import jarvis.interaction.state.MainContext;
import jarvis.interaction.state.MainState;

public class Interactor implements MainContext {
	
	private MainState state = null;

	public State getState() {
		return state;
	}

	public void setState(MainState state) throws IllegalArgumentException {
		if(state == null)
			throw new IllegalArgumentException();
		
		this.state = state;
	}

	public void setState(State state) throws IllegalArgumentException {
		if(!(state instanceof MainState))
			throw new IllegalArgumentException();
		
		setState((MainState) state);
	}

	public void handle(String message) {
		// TODO Auto-generated method stub
		
	}

	public void activate() {
		// TODO create listening cycle
	}

	public void deactivate() {
		// TODO leave
		
	}

	public void replyToUser(String message) {
		// TODO use synth to respond
		
	}

	public String getUserName() {
		// TODO complete with a configurations class as singleton (maybe)
		return "sir";
	}
	
	

}

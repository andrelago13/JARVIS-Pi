package jarvis.interaction.state.mainstates;

import jarvis.interaction.state.JarvisMainContext;
import jarvis.interaction.state.JarvisMainState;

public class ActiveMainState implements JarvisMainState {
	
	private JarvisMainContext context = null;

	public ActiveMainState(JarvisMainContext context) {
		setContext(context);
	}

	public Boolean hasContext() {
		return context != null;
	}

	public void setContext(JarvisMainContext context) {
		this.context = context;
	}

	public void initiate() {
		// TODO Auto-generated method stub

	}

	public void receiveString(String message) {
		// TODO Auto-generated method stub

	}

	public void end() {
		// TODO Auto-generated method stub

	}

}

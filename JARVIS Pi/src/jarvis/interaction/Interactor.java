package jarvis.interaction;

import jarvis.interaction.state.JarvisMainContext;
import jarvis.interaction.state.JarvisMainState;
import jarvis.interaction.state.mainstates.IdleMainState;

public class Interactor implements JarvisMainContext {
	
	private JarvisMainState state = null;
	
	public Interactor() {
		state = new IdleMainState(this);
	}

	public void receiveString(String message) {
		state.receiveString(message);
		// TODO que faz aqui ??
	}

	public void setState(JarvisMainState state) {
		endCurrState();
		this.state = state;
		initiateCurrState();
	}

	private void endCurrState() {
		if(this.state != null)
			this.state.end();
	}

	private void initiateCurrState() {
		if(this.state != null)
			this.state.initiate();
	}

	@Override
	public void respondToUser(String message) {
		// TODO use synth to speak
	}

}

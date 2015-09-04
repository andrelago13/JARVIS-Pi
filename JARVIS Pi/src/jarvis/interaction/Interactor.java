package jarvis.interaction;

import sound.MP3Player;
import sphinx.SoundListener;
import designpatterns.State;
import freetts.TextSynthesizer;
import jarvis.interaction.state.MainContext;
import jarvis.interaction.state.MainState;
import jarvis.interaction.state.mainstate.IdleState;

public class Interactor implements MainContext {

	private MainState state = null;
	private SoundListener listener = null;
	private TextSynthesizer synth = null;
	private Boolean active = false;

	public Interactor() {
		setState(new IdleState(this));
	}

	public State getState() {
		return state;
	}

	public void setState(MainState state) throws IllegalArgumentException {
		if(state == null)
			throw new IllegalArgumentException();

		if(this.state != null)
			this.state.deactivate();
		this.state = state;
		this.state.setContext(this);
		this.state.activate();
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
		
		active = true;

		try {
			listener = new SoundListener();
			synth = new TextSynthesizer();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		startListening();

	}

	private void startListening() {
		String message = "";
		while(!message.equals("farewell") && active) {
			message = listener.listenOnce(true);

			state.handle(message);
		}
	}

	public void deactivate() {
		active = false;
	}

	public void replyToUser(String message) throws IllegalArgumentException {
		if(message == null)
			throw new IllegalArgumentException();

		if(synth != null) {
			System.out.println("Replying \"" + message + "\"");
			synth.speakString(message);
		}

	}

	public String getUserName() {
		// TODO complete with a configurations class as singleton (maybe)
		return "sir";
	}



}

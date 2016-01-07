package jarvis.interaction;

import java.io.IOException;

import config.Configuration;
import sphinx.SoundListener;
import freetts.TextSynthesizer;
import jarvis.interaction.state.MainJarvisContext;
import jarvis.interaction.state.MainJarvisState;
import jarvis.interaction.state.mainstate.IdleState;

public class Interactor implements MainJarvisContext {

	private MainJarvisState state = null;
	private SoundListener listener = null;
	private TextSynthesizer synth = null;
	private Configuration config = null;

	public Interactor() throws Exception {
		listener = new SoundListener();
		synth = new TextSynthesizer();
		config = Configuration.getInstance();
	}

	public MainJarvisState getState() {
		return state;
	}

	public void setState(MainJarvisState state) throws IllegalArgumentException {
		if(state == null)
			throw new IllegalArgumentException();

		if(this.state != null)
			this.state.deactivate();
		this.state = state;
		this.state.activate();
	}

	public void handle(String message) {
		if(state != null)
			state.handle(message);

	}

	public void activate() {
		try {
			setState(new IdleState(this));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void deactivate() {
		try {
			config.storeToFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Unable to save program configurations.");
		}
	}

	public void replyToUser(String message) throws IllegalArgumentException {
		if(message == null)
			throw new IllegalArgumentException();

		if(synth != null) {
			System.out.println("Replying \"" + message + "\"");
			synth.speakString(message);
		}

	}

	@Override
	public void getUserInput() {
		String message = "";
		message = listener.listenOnce();
		if(state != null)
			state.handle(message);
	}

}

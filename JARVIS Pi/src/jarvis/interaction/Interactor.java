package jarvis.interaction;

import java.io.IOException;
import java.util.Scanner;

import configuration.Configuration;
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
	private Boolean active = false;

	public Interactor() throws Exception {
		listener = new SoundListener();
		synth = new TextSynthesizer();
		config = Configuration.getInstance();
		setState(new IdleState(this));
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
		if(active)
			this.state.activate();
	}

	public void handle(String message) {
		if(!isActive())
			return;
		
		if(state != null)
			state.handle(message);

	}
	
	public void execute() {
		while(isActive()) {
			this.state.execute();
		}
	}

	public void activate() {
		if(isActive())
			return;
		
		active = true;
		this.state.activate();
	}

	public void deactivate() {
		if(!isActive())
			return;
		
		active = false;
		try {
			state.deactivate();
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
	public String getUserInput() {
		System.out.println("Waiting...");
		String message = "";
		message = listener.listenOnce();
		System.out.println("Read: " + message);
		return message;
	}

	public Boolean isActive() {
		return active;
	}

	public void run() {
		activate();
		execute();
	}

}

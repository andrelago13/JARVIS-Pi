package jarvis.interaction.state.mainstate;

import java.io.IOException;

import configuration.Configuration;
import configuration.language.TextSystem;
import sound.MP3Player;
import jarvis.easter_eggs.EasterEggSystem;
import jarvis.interaction.state.MainJarvisContext;
import jarvis.interaction.state.MainJarvisState;

public class IdleState implements MainJarvisState {

	/*
	 * 		STATE ATTRIBUTES
	 */
	private MainJarvisContext context = null;
	private Configuration config = null;
	private Boolean active = false;

	public IdleState(MainJarvisContext context) throws IllegalArgumentException, ClassNotFoundException, IOException {
		setContext(context);
		config = Configuration.getInstance();
	}

	public void activate() {
		if(isActive())
			return;
		
		active = true;
	}

	public void deactivate() {
		if(!isActive())
			return;
		
		active = false;
	}
	
	public Boolean isActive() {
		return active;
	}
	
	public void execute() {
		if(!isActive())
			return;
		
		context.getUserInput();
	}

	public void handle(String message) {
		if(TextSystem.isGreet(message)) {
			context.replyToUser(TextSystem.currentGreetReply() + config.getUserName());
			context.setState(new TriggeredState(context));
			return;
		} else if(TextSystem.isFarewell(message)) {
			context.replyToUser(TextSystem.getFarewellReply() + config.getUserName());
			context.deactivate();
			return;
		}
	}

	public MainJarvisContext getContext() {
		return context;
	}

	public void setContext(MainJarvisContext context) throws IllegalArgumentException {
		if(context == null) {
			throw new IllegalArgumentException();
		}

		this.context = context;
	}

}

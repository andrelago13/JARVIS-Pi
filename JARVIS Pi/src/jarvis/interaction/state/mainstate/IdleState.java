package jarvis.interaction.state.mainstate;

import java.io.IOException;
import java.util.ArrayList;

import configuration.Configuration;
import configuration.language.TextSystem;
import sound.MP3Player;
import time.Time;
import jarvis.interaction.state.MainJarvisContext;
import jarvis.interaction.state.MainJarvisState;

public class IdleState implements MainJarvisState {

	/*
	 * 		STATE CONSTANTS
	 * 	some of these might be later moved into text files
	 */
	
	private final static String heisenberg_message_1 = "say my name";
	private final static String heisenberg_message_2 = "you're hi zen berg";
	private final static String heisenberg_file_1 = "./resources/sound/heisenberg/youre-heisenberg.mp3";
	private final static String heisenberg_file_2 = "./resources/sound/heisenberg/youre-goddamn-right.mp3";

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
		if(active)
			return;
		
		active = true;
	}

	public void deactivate() {
		if(!active)
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
			context.replyToUser(currentGreetReply() + config.getUserName());
			context.setState(new TriggeredState(context));
			return;
		} else if(TextSystem.isFarewell(message)) {
			context.replyToUser(TextSystem.farewellReply + config.getUserName());
			context.deactivate();
			return;
		} else if(message.equals(heisenberg_message_1)) {
			MP3Player.playFileForeground(heisenberg_file_1);
		} else if (message.equals(heisenberg_message_2)) {
			MP3Player.playFileForeground(heisenberg_file_2);
		}
	}

	private static String currentGreetReply() {
		Time t = Time.getCurrentTime();
		int hours = t.getHours();

		if(hours >= 5 && hours <= 12) {
			return TextSystem.greetReplies[TextSystem.greetRepliesType.MORNING.ordinal()];
		} else if(hours >= 13 && hours <= 20) {
			return TextSystem.greetReplies[TextSystem.greetRepliesType.AFTERNOON.ordinal()];
		} else {
			return TextSystem.greetReplies[TextSystem.greetRepliesType.EVENING.ordinal()];
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

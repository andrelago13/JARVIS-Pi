package jarvis.interaction.state.mainstate;

import java.io.IOException;

import config.Configuration;
import sound.MP3Player;
import time.Time;
import jarvis.interaction.state.MainJarvisContext;
import jarvis.interaction.state.MainJarvisState;

public class IdleState implements MainJarvisState {

	/*
	 * 		STATE CONSTANTS
	 * 	some of these might be later moved into text files
	 */
	private final static String greets[] = { "good morning jarvis", "good afternoon jarvis", "good evening jarvis", "hello jarvis", "hey jarvis", "hi jarvis", "jarvis" };
	private final static String farewell[] = { "farewell jarvis", "goodbye jarvis", "bye jarvis", "terminate jarvis", "jarvis terminate" };

	private final static String greetReplies[] = { "good morning ", "good afternoon ", "good evening "};
	private static enum greetRepliesType { MORNING, AFTERNOON, EVENING };
	private final static String farewellReply = "goodbye ";
	
	private final static String heisenberg_message_1 = "say my name";
	private final static String heisenberg_message_2 = "you're hi zen berg";
	private final static String heisenberg_file_1 = "./resources/sound/heisenberg/youre-heisenberg.mp3";
	private final static String heisenberg_file_2 = "./resources/sound/heisenberg/youre-goddamn-right.mp3";

	/*
	 * 		STATE ATTRIBUTES
	 */
	private MainJarvisContext context = null;
	private Configuration config = null;

	public IdleState(MainJarvisContext context) throws IllegalArgumentException, ClassNotFoundException, IOException {
		setContext(context);
		config = Configuration.getInstance();
	}

	public void activate() {
		context.getUserInput();
	}

	public void deactivate() {}

	public void handle(String message) {

		if(isGreet(message)) {
			context.replyToUser(currentGreetReply() + config.getUserName());
		} else if(isFarewell(message)) {
			context.replyToUser(farewellReply + config.getUserName());
			context.deactivate();
			return;
		} else if(message.equals(heisenberg_message_1)) {
			MP3Player.playFileForeground(heisenberg_file_1);
		} else if (message.equals(heisenberg_message_2)) {
			MP3Player.playFileForeground(heisenberg_file_2);
		}
		
		context.getUserInput();
	}

	private static Boolean isGreet(String message) {

		if(message == null) return false;

		for(int i = 0; i < greets.length; i++) {
			if(greets[i].equals(message))
				return true;
		}

		return false;
	}

	private static Boolean isFarewell(String message) {

		if(message == null) return false;

		for(int i = 0; i < farewell.length; i++) {
			if(farewell[i].equals(message))
				return true;
		}

		return false;
	}

	private static String currentGreetReply() {
		Time t = Time.getCurrentTime();
		int hours = t.getHours();

		if(hours >= 5 && hours <= 12) {
			return greetReplies[greetRepliesType.MORNING.ordinal()];
		} else if(hours >= 13 && hours <= 20) {
			return greetReplies[greetRepliesType.AFTERNOON.ordinal()];
		} else {
			return greetReplies[greetRepliesType.EVENING.ordinal()];
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

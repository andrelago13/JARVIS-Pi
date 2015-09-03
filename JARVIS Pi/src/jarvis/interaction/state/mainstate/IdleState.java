package jarvis.interaction.state.mainstate;

import time.Time;
import jarvis.interaction.state.MainContext;
import jarvis.interaction.state.MainState;

public class IdleState implements MainState {

	private static String greets[] = { "good morning jarvis", "good afternoon jarvis", "good evening jarvis", "hello jarvis", "hey jarvis", "hi jarvis", "jarvis" };
	private static String farewell[] = { "farewell jarvis", "goodbye jarvis", "bye jarvis", "terminate jarvis", "jarvis terminate" };

	private static String greetReplies[] = { "good morning ", "good afternoon ", "good evening "};
	private static enum greetRepliesType { MORNING, AFTERNOON, EVENING };
	private static String farewellReply = "goodbye ";

	private MainContext context = null;

	public IdleState(MainContext context) throws IllegalArgumentException {
		setContext(context);
	}

	public void activate() {}

	public void deactivate() {}

	public void handle(String message) {
		
		if(isGreet(message)) {
			context.replyToUser(currentGreetReply() + context.getUserName());
			return;
		}
		
		if(isFarewell(message)) {
			context.replyToUser(farewellReply + context.getUserName());
			context.deactivate();
		}
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
	
	public MainContext getContext() {
		return context;
	}

	public void setContext(MainContext context) throws IllegalArgumentException {
		if(context == null) {
			throw new IllegalArgumentException();
		}

		this.context = context;
	}

}

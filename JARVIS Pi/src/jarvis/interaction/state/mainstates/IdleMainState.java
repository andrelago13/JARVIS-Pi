package jarvis.interaction.state.mainstates;

import jarvis.interaction.state.JarvisMainContext;
import jarvis.interaction.state.JarvisMainState;

public class IdleMainState implements JarvisMainState {

	private JarvisMainContext context = null;
	
	public static final String stateMessages[] = {
		"jarvis",
		"good morning jarvis",
		"good afternoon jarvis",
		"good evening jarvis",
		"hello jarvis",
		"hey jarvis",
		"hi jarvis"
	};
	
	private static final String responses[] = {
		"yes sir",
		"good morning sir",
		"good afternoon sir",
		"good evening sir",
		"hello sir",
		"yes sir",
		"hello sir"
	};
	
	public IdleMainState(JarvisMainContext context) {
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
		if(isStateMessage(message)) {
			if(hasContext()) {
				context.respondToUser(responseTo(message));
				context.setState(new ActiveMainState(context));
			}
		}
	}

	public void end() {
		// TODO Auto-generated method stub
		
	}

	public static Boolean isStateMessage(String message) {
		for(int i = 0; i < stateMessages.length; i++) {
			if(stateMessages[i].equals(message))
				return true;
		}
		
		return false;
	}
	
	private static String responseTo(String message) {
		for(int i = 0; i < stateMessages.length; i++) {
			if(stateMessages[i].equals(message))
				return responses[i];
		}
		return "";
	}

}

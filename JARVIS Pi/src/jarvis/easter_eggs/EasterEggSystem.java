package jarvis.easter_eggs;

import sound.MP3Player;
import jarvis.interaction.state.MainJarvisContext;

public class EasterEggSystem {
	
	private final static String heisenberg_message_1 = "say my name";
	private final static String heisenberg_message_2 = "you're hi zen berg";
	private final static String heisenberg_file_1 = "./resources/sound/heisenberg/youre-heisenberg.mp3";
	private final static String heisenberg_file_2 = "./resources/sound/heisenberg/youre-goddamn-right.mp3";
	
	public static Boolean isEasterEgg(String message) {
		if(isHeisenbergTrigger(message))		// ADD OTHER EASTER EGGS HERE
			return true;
		
		return false;
	}
	
	public static void makeEasterEgg(String message, MainJarvisContext context) {
		if(isHeisenbergTrigger(message)) {
			makeHeisenbergAction(message);
			return;
		}
	}
	
	private static Boolean isHeisenbergTrigger(String message) {
		return (message.equals(heisenberg_message_1) || message.equals(heisenberg_message_2));
	}
	
	private static void makeHeisenbergAction(String message) {
		if(message.equals(heisenberg_message_1)) {
			MP3Player.playFileForeground(heisenberg_file_1);
		} else if (message.equals(heisenberg_message_2)) {
			MP3Player.playFileForeground(heisenberg_file_2);
		}
	}
}

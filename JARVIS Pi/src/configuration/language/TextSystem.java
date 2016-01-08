package configuration.language;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import configuration.Configuration;

public class TextSystem {

	/*
	 * DEFAULT VALUES
	 */
	
	private final static String defaultFilePath = "lang/";	// RELATIVE TO CONFIGURATION
	private final static String defaultGreetFarewellFile = "greet-farewell.txt";
	
	private static ArrayList<String> greets = new ArrayList<String>(Arrays.asList("good morning jarvis", "good afternoon jarvis", "good evening jarvis", "hello jarvis", "hey jarvis", "hi jarvis", "jarvis" ));
	private static ArrayList<String> farewell = new ArrayList<String>(Arrays.asList("farewell jarvis", "goodbye jarvis", "bye jarvis", "terminate jarvis", "jarvis terminate" ));
	private final static String greets_trigger = "/*GREET*/";
	private final static String farewell_trigger = "/*FAREWELL*/";

	public final static String greetReplies[] = { "good morning ", "good afternoon ", "good evening "};
	public static enum greetRepliesType { MORNING, AFTERNOON, EVENING };
	public final static String farewellReply = "goodbye ";
	
	public static void initiate() {
		initiateGreetFarewell();
		// INITIATE OTHER SUBSYSTEMS HERE
	}
	
	@SuppressWarnings("unchecked")
	private static void initiateGreetFarewell() {
		try {
			Configuration config = Configuration.getInstance();
			ArrayList<String> greets_temp = new ArrayList<String>();
			ArrayList<String> farewell_temp = new ArrayList<String>();
			ArrayList<String> destination = greets_temp;
			for (String line : Files.readAllLines(Paths.get(config.getFilePath() + defaultFilePath + defaultGreetFarewellFile))) {
				if(line.equals(greets_trigger)) {
					destination = greets_temp;
					continue;
				} else if (line.equals(farewell_trigger)) {
					destination = farewell_temp;
					continue;
				}
				
				destination.add(line);
			}
			
			greets = (ArrayList<String>) greets_temp.clone();
			farewell = (ArrayList<String>) farewell_temp.clone();			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static final ArrayList<String> getGreets() {
		return greets;
	}
	
	public static final ArrayList<String> getFarewell() {
		return farewell;
	}
	
	public static final Boolean isGreet(String message) {
		if(message == null) return false;

		for(int i = 0; i < greets.size(); i++) {
			if(greets.get(i).equals(message))
				return true;
		}

		return false;
	}

	public static final Boolean isFarewell(String message) {
		if(message == null) return false;

		for(int i = 0; i < farewell.size(); i++) {
			if(farewell.get(i).equals(message))
				return true;
		}

		return false;
	}
}

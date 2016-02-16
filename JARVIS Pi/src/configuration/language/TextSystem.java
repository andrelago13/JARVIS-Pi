package configuration.language;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import time.Time;
import configuration.Configuration;

public class TextSystem {

	/*
	 * DEFAULT VALUES
	 */
	
	private final static String defaultFilePath = "lang/";	// RELATIVE TO CONFIGURATION
	private final static String defaultUserInputFile = "text-system-in.txt";
	private final static String defaultUserOutputFile = "text-system-out.txt";
	
	private static ArrayList<String> greets = new ArrayList<String>(Arrays.asList("good morning jarvis", "good afternoon jarvis", "good evening jarvis", "hello jarvis", "hey jarvis", "hi jarvis", "jarvis" ));
	private static ArrayList<String> farewell = new ArrayList<String>(Arrays.asList("farewell jarvis", "goodbye jarvis", "bye jarvis", "terminate jarvis", "jarvis terminate" ));
	private static ArrayList<String> weather_current = new ArrayList<String>(Arrays.asList( "what's today's weather", "what's the weather like", "how's the weather", "is it raining", "is it sunny" ));
	private final static String greets_trigger = "/*GREET*/";
	private final static String farewell_trigger = "/*FAREWELL*/";
	private final static String weather_current_trigger = "/*WEATHER_CURRENT*/";
	private final static String input_triggers[] = {greets_trigger, farewell_trigger, weather_current_trigger};
	private final static Object input_lists[] = { greets, farewell, weather_current };
	
	private static ArrayList<String> already_here = new ArrayList<String>(Arrays.asList("i'm here USER", "i can hear you USER", "how should i serve you USER", "what can i do for you USER", "how may i be of service USER"));
	private final static String already_here_trigger = "/*ALREADY_HERE*/";
	private final static String output_triggers[] = {already_here_trigger};
	private final static Object output_lists[] = {already_here};

	private final static String greetReplies[] = { "good morning ", "good afternoon ", "good evening "};
	private static enum greetRepliesType { MORNING, AFTERNOON, EVENING };
	private final static String farewellReply = "goodbye ";
	
	private final static String weatherConditionReply_1 = "Current weather in ";
	private final static String weatherConditionReply_2 = " is ";
	private final static String weatherConditionReply_3 = " with a temperature of ";
	private final static String weatherConditionReply_4 = " Celsius degrees.";
	
	public static void initiate() {
		initiateUserInput();
		initiateUserOutput();
		// INITIATE OTHER SUBSYSTEMS HERE
	}
	
	@SuppressWarnings("unchecked")
	private static void load(String file_path, String triggers[], Object lists[]) throws ClassNotFoundException, IOException {
		int curr_index = 0;
		ArrayList<String> temp = new ArrayList<String>();
		
		for (String line : Files.readAllLines(Paths.get(file_path))) {
			if(line.charAt(0) == '/' && temp.size() > 0) {	// found end of section
				lists[curr_index] = (ArrayList<String>) temp.clone();
				temp.clear();
			}
			
			int new_index = 0;
			
			for(; new_index < triggers.length; ++new_index) {
				if(triggers[new_index].equals(line)) {
					curr_index = new_index;
					break;
				}
			}
			
			if(new_index < triggers.length)
				continue;
			
			temp.add(line);
		}
		lists[curr_index] = (ArrayList<String>) temp.clone();
	}
	
	private static void initiateUserInput() {
		try {
			Configuration config = Configuration.getInstance();
			load(config.getFilePath() + defaultFilePath + defaultUserInputFile, input_triggers, input_lists);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	private static void initiateUserOutput() {
		try {
			Configuration config = Configuration.getInstance();
			load(config.getFilePath() + defaultFilePath + defaultUserOutputFile, output_triggers, output_lists);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public static final String getFarewellReply() {
		return farewellReply;
	}
	
	public static final ArrayList<String> getGreets() {
		return greets;
	}
	
	public static final ArrayList<String> getFarewell() {
		return farewell;
	}
	
	public static final ArrayList<String> getAlreadyHere() {
		return already_here;
	}
	
	public static final String getRandomAlreadyHere() {
		Random rn = new Random();
		int index = rn.nextInt() % already_here.size();
		
		if(already_here.get(index).contains("USER")) {
			try {
				return already_here.get(index).replace("USER", Configuration.getInstance().getUserName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return already_here.get(index);
	}
	
	public static final ArrayList<String> getWeatherCondition() {
		return weather_current;
	}
	
	public static final Boolean isGreet(String message) {
		return greets.contains(message);
	}

	public static final Boolean isFarewell(String message) {
		return farewell.contains(message);
	}

	public static boolean isWeatherCondition(String message) {
		return weather_current.contains(message);
	}

	public static String weatherConditionMessage(String city, String weather, double temperatureCelsius) {
		return weatherConditionReply_1 + city + weatherConditionReply_2 + weather + weatherConditionReply_3 + temperatureCelsius + weatherConditionReply_4;
	}
	
	public static String currentGreetReply() {
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
}

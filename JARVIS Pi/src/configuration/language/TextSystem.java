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
	
	private final static String greets_trigger = "/*GREET*/";
	private final static String farewell_trigger = "/*FAREWELL*/";
	private final static String weather_current_trigger = "/*WEATHER_CURRENT*/";
	private final static String input_triggers[] = {greets_trigger, farewell_trigger, weather_current_trigger};
	private final static Object input_lists[] = new Object[input_triggers.length];
	private final static int greets_index = 0;
	private final static int farewell_index = 1;
	private final static int weather_current_index = 2;
	
	private final static String already_here_trigger = "/*ALREADY_HERE*/";
	private final static String output_triggers[] = {already_here_trigger};
	private final static Object output_lists[] = new Object[output_triggers.length];
	private final static int already_here_index = 0;

	private final static String greetReplies[] = { "good morning ", "good afternoon ", "good evening "};
	private static enum greetRepliesType { MORNING, AFTERNOON, EVENING };
	private final static String farewellReply = "goodbye ";
	
	private final static String weatherConditionReply_1 = "The current weather in ";
	private final static String weatherConditionReply_2 = " is ";
	private final static String weatherConditionReply_3 = " with a temperature of ";
	private final static String weatherConditionReply_4 = " Celsius degrees.";
	
	private final static String weatherForecastReply_1 = "The predicted condition for tomorrow is";
	private final static String weatherForecastReply_2 = " with temperatures between ";
	private final static String weatherForecastReply_3 = " and ";
	private final static String weatherForecastReply_4 = " celsius degrees. Probability of rain is ";
	private final static String weatherForecastReply_5 = " percent.";
	
	public static void initiate() throws ClassNotFoundException, IOException {
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
	
	private static void initiateUserInput() throws ClassNotFoundException, IOException {
		Configuration config = Configuration.getInstance();
		load(config.getFilePath() + defaultFilePath + defaultUserInputFile, input_triggers, input_lists);
	}
	
	private static void initiateUserOutput() throws ClassNotFoundException, IOException {
		Configuration config = Configuration.getInstance();
		load(config.getFilePath() + defaultFilePath + defaultUserOutputFile, output_triggers, output_lists);
	}
	
	public static final String getFarewellReply(Configuration config) {
		return farewellReply + config.getUserName();
	}
	
	@SuppressWarnings("unchecked")
	public static final ArrayList<String> getGreets() {
		return (ArrayList<String>) input_lists[greets_index];
	}
	
	@SuppressWarnings("unchecked")
	public static final ArrayList<String> getFarewell() {
		return (ArrayList<String>) input_lists[farewell_index];
	}
	
	@SuppressWarnings("unchecked")
	public static final ArrayList<String> getAlreadyHere() {
		return (ArrayList<String>) output_lists[already_here_index];
	}
	
	@SuppressWarnings("unchecked")
	public static final String getRandomAlreadyHere() {
		Random rn = new Random();
		int index = rn.nextInt(((ArrayList<String>) output_lists[already_here_index]).size());
		
		if(((ArrayList<String>)output_lists[already_here_index]).get(index).contains("USER")) {
			try {
				return ((ArrayList<String>)output_lists[already_here_index]).get(index).replace("USER", Configuration.getInstance().getUserName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return ((ArrayList<String>)output_lists[already_here_index]).get(index);
	}
	
	@SuppressWarnings("unchecked")
	public static final ArrayList<String> getWeatherCondition() {
		return (ArrayList<String>) input_lists[weather_current_index];
	}
	
	@SuppressWarnings("unchecked")
	public static final Boolean isGreet(String message) {
		return ((ArrayList<String>) input_lists[greets_index]).contains(message);
	}

	@SuppressWarnings("unchecked")
	public static final Boolean isFarewell(String message) {
		return ((ArrayList<String>) input_lists[farewell_index]).contains(message);
	}

	@SuppressWarnings("unchecked")
	public static boolean isWeatherCondition(String message) {
		return ((ArrayList<String>) input_lists[weather_current_index]).contains(message);
	}

	public static String weatherConditionMessage(String city, String weather, double temperatureCelsius) {
		return weatherConditionReply_1 + city + weatherConditionReply_2 + weather + weatherConditionReply_3 + temperatureCelsius + weatherConditionReply_4;
	}
	
	public static String weatherForecastMessage(String condition, int minCelsius, int maxCelsius, int rainProbability) {
		return weatherForecastReply_1 + condition + weatherForecastReply_2 + minCelsius + weatherForecastReply_3 + maxCelsius + weatherForecastReply_4 + rainProbability + weatherForecastReply_5;
	}
	
	public static String currentGreetReply(Configuration config) {
		Time t = Time.getCurrentTime();
		int hours = t.getHours();

		String timeReply;
		if(hours >= 5 && hours <= 12) {
			timeReply = greetReplies[greetRepliesType.MORNING.ordinal()];
		} else if(hours >= 13 && hours <= 20) {
			timeReply = greetReplies[greetRepliesType.AFTERNOON.ordinal()];
		} else {
			timeReply = greetReplies[greetRepliesType.EVENING.ordinal()];
		}
		
		return timeReply + config.getUserName();
	}
}

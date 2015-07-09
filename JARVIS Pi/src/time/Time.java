package time;

import java.util.Calendar;

public class Time implements Comparable<Time> {

	public static final int minHours = 0;
	public static final int maxHours = 23;
	public static final int numHours = 24;
	public static final int minMinutes = 0;
	public static final int maxMinutes = 59;
	public static final int numMinutes = 60;
	public static final int minSeconds = 0;
	public static final int maxSeconds = 59;
	public static final int numSeconds = 60;
	
	public static final int secToMillis = 1000;
	public static final int minToMillis = 60*secToMillis;
	public static final int hourToMillis = 60*minToMillis;

	protected int hours;
	protected int minutes;
	protected int seconds;

	public Time(int hours, int minutes, int seconds) throws IllegalArgumentException {

		if(!validHours(hours) || !validMinutes(minutes) || !(validSeconds(seconds)))
			throw(new IllegalArgumentException("args: " + hours + " " + minutes + " " + seconds));

		this.setHours(hours);
		this.setMinutes(minutes);
		this.setSeconds(seconds);
	}
	
	public Time(long millis) {
		this(millisToHours(millis), millisToMinutes(millis), millisToSeconds(millis));
	}
	
	public static int millisToHours(long millis) {
		return (int) ((millis / (hourToMillis)) % numHours);
	}
	
	public static int millisToMinutes(long millis) {
		return (int) ((millis / (minToMillis)) % numMinutes);
	}
	
	public static int millisToSeconds(long millis) {
		return (int) (millis / secToMillis) % numSeconds;
	}

	public static Boolean validHours(int hours) {
		return hours >= minHours || hours <= maxHours;
	}

	public static Boolean validMinutes(int minutes) {
		return minutes >= minMinutes && minutes <= maxMinutes;
	}

	public static Boolean validSeconds(int seconds) {
		return seconds >= minSeconds && seconds < maxSeconds;
	}

	public Time() { this(0, 0, 0); }

	public int getHours() {
		return hours;
	}

	public Boolean setHours(int hours) {
		if(!validHours(hours))
			return false;

		this.hours = hours;
		return true;
	}

	public int getMinutes() {
		return minutes;
	}

	public Boolean setMinutes(int minutes) {
		
		if(!validMinutes(minutes))
			return false;
		
		this.minutes = minutes;
		return true;
	}

	public int getSeconds() {
		return seconds;
	}

	public Boolean setSeconds(int seconds) {
		
		if(!validSeconds(seconds))
			return false;
		
		this.seconds = seconds;
		return true;
	}

	public int compareTo(Time arg0) {

		if(this.hours < arg0.hours) return -1;
		else if(this.hours > arg0.hours) return 1;

		if(this.minutes < arg0.minutes) return -1;
		else if(this.minutes > arg0.minutes) return 1;

		if(this.seconds < arg0.seconds) return -1;
		else if(this.seconds > arg0.seconds) return 1;

		return 0;
	}
	
	public Time difference(Time t2) {
		return new Time(Math.abs(t2.toMillis() - toMillis()));		
	}
	
	public static Time difference(Time t1, Time t2) {
		return t1.difference(t2);
	}

	public static Time getCurrentTime() {
		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		return new Time(hour, minute, second);
	}
	
	public long toMillis() {
		return seconds*secToMillis + minutes*minToMillis + hours*hourToMillis;
	}
}

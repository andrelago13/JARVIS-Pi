package time;

import java.util.Calendar;

public class Time implements Comparable<Time> {

	public static final int minHours = 0;
	public static final int maxHours = 23;
	public static final int minMinutes = 0;
	public static final int maxMinutes = 59;
	public static final int minSeconds = 0;
	public static final int maxSeconds = 59;

	protected int hours;
	protected int minutes;
	protected int seconds;

	public Time(int hours, int minutes, int seconds) throws IllegalArgumentException {

		if(!validHours(hours) || !validMinutes(minutes) || !(validSeconds(seconds)))
			throw(new IllegalArgumentException());

		this.setHours(hours);
		this.setMinutes(minutes);
		this.setSeconds(seconds);
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
		return new Time(this.hours-t2.hours, this.minutes-t2.minutes, this.seconds-t2.seconds);		
	}
	
	public Time absoluteDifference(Time t2) {
		int comp = compareTo(t2);
		if(comp == -1)
			return t2.difference(this);
		
		return difference(t2);
	}
	
	public static Time absoluteDifference(Time t1, Time t2) {
		return t1.absoluteDifference(t2);
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
}

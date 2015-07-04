package time;

public class Time implements Comparable<Time> {
	
	// TODO check for validity in getters and setters

	protected int hours;
	protected int minutes;
	protected int seconds;

	public Time(int hours, int minutes, int seconds) throws IllegalArgumentException {
		
		if(hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59)
			throw(new IllegalArgumentException());
		
		this.setHours(hours);
		this.setMinutes(minutes);
		this.setSeconds(seconds);
	}

	public Time() { this(0, 0, 0); }

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
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
	
	/*public static Time getCurrentTime() {
		System.currentTimeMillis();
		Date t;
	}*/
}

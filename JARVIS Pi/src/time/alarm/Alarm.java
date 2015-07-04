package time.alarm;

import time.Time;

public class Alarm {
	
	private Time time;
	
	public Alarm(Time time) {
		this.setTime(time);
	}
	
	public Alarm(int hours, int minutes, int seconds) {
		this(new Time(hours, minutes, seconds));
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}

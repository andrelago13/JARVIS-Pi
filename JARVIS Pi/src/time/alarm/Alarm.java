package time.alarm;

import java.util.Timer;
import java.util.TimerTask;

import sound.MP3Player;
import time.Time;

public class Alarm {
	
	private Time time;
	private Timer timer;
	private MP3Player ringPlayer;
	
	public Alarm(Time time) {
		this.setTime(time);
		timer = new Timer();
		ringPlayer = new MP3Player("./resources/sound/alarm/alarm.mp3");
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

	public void schedule() {
		Time curr_time = Time.getCurrentTime();
		Time diff = time.difference(curr_time);
		long diff_long = diff.toMillis();
		
		if(curr_time.compareTo(time) != -1) {
			diff_long = diff_long + Time.numHours*Time.hourToMillis;
		}
		
		System.out.println("Scheduling alarm to: " + diff_long + " milliseconds.");
	
		timer.schedule(new AlarmRinger(), diff_long);
	}
	
	private class AlarmRinger extends TimerTask {
		public void run() {
			System.out.println("Ringing alarm");
			ringPlayer.play();
		}
	}
	
	public void cancel() {
		timer.cancel();
		ringPlayer.stop();
	}
}

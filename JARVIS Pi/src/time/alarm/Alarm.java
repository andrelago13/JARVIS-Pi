package time.alarm;

import java.util.Timer;
import java.util.TimerTask;

import sound.MP3Player;
import time.Time;

public class Alarm {
	
	// TODO add function to stop ringing
	
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
		
		if(curr_time.compareTo(time) != -1) {	// FIXME correct, use week format schedule with possibility for specific dates and repititions, then use cycle to check for the alarms. Add a "receiver" sort of thing
			diff_long = time.difference(Time.MIDNIGHT_DAYAFTER).toMillis();
			diff_long += curr_time.difference(Time.MIDNIGHT_DAYBEFORE).toMillis();
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
	}
	
	public void stopRing() {
		ringPlayer.stop();		
	}
}

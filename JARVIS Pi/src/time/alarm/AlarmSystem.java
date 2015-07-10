package time.alarm;

import java.util.ArrayList;

public class AlarmSystem {
	
	private static AlarmSystem instance = null;
	
	private ArrayList<Alarm> alarms;
	private Boolean running;
	
	private AlarmSystem() {
		alarms = new ArrayList<Alarm>();
		running = false;
	}
	
	public static AlarmSystem getInstance() {
		if(instance == null) 
			instance = new AlarmSystem();
		return instance;
	}
	
	public void addAlarm(Alarm alarm) {
		alarms.add(alarm);
		if(running)
			alarm.schedule();
	}
	
	public void stop() {
		running = false;
		for(int i = 0; i < alarms.size(); i++) {
			alarms.get(i).stopRing();
		}
	}
	
	public void start() {
		running = true;
		for(int i = 0; i < alarms.size(); i++) {
			alarms.get(i).schedule();
		}
	}
	
	public ArrayList<Alarm> getAlarms() {
		return alarms;
	}
}

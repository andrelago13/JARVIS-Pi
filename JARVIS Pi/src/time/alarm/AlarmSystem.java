package time.alarm;

import java.util.ArrayList;
import java.util.Timer;

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
	
	public void start() {
		running = true;
		
		new Thread( new Runnable() {
		    @Override
		    public void run() {
		    	while(running) {
		    		try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		    		
		    		System.out.println("Here");
		    	}
		    }
		}).start();
	}
	
	public void stop() {
		running = false;
	}
	
}

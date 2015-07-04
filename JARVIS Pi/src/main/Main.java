package main;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import time.alarm.Alarm;
import jarvis.InteractorTest;

public class Main {
	
	private static final int SECOND = 1000;
	private static final int MINUTE = 60 * SECOND;
	private static final int HOUR = 60 * MINUTE;
	private static final int DAY = 24 * HOUR;

	public static void main(String[] args) {
		/*InteractorTest it = new InteractorTest();
		it.start();
		System.exit(0);*/
		
		long millis = System.currentTimeMillis();
		
		System.out.println(String.format("%d min, %d sec", 
    TimeUnit.MILLISECONDS.toMinutes(millis),
    TimeUnit.MILLISECONDS.toSeconds(millis) - 
    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
));

		long ms = System.currentTimeMillis();
		StringBuffer text = new StringBuffer("");
		if (ms > DAY) {
		  text.append(ms / DAY).append(" days ");
		  ms %= DAY;
		}
		if (ms > HOUR) {
		  text.append(ms / HOUR).append(" hours ");
		  ms %= HOUR;
		}
		if (ms > MINUTE) {
		  text.append(ms / MINUTE).append(" minutes ");
		  ms %= MINUTE;
		}
		if (ms > SECOND) {
		  text.append(ms / SECOND).append(" seconds ");
		  ms %= SECOND;
		}
		text.append(ms + " ms");
		System.out.println(text.toString());
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH); // Note: zero based!
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int millis2 = now.get(Calendar.MILLISECOND);

		System.out.printf("%d-%02d-%02d %02d:%02d:%02d.%03d", year, month + 1, day, hour, minute, second, millis2);
		
		Alarm alarm = new Alarm(hour, minute+2, second);
		
		new Thread( new Runnable() {
		    @Override
		    public void run() {
		    	// TODO try this
		    }
		}).start();
		
	}

}

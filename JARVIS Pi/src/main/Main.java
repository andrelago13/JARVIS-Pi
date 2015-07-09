package main;

import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import sound.MP3Player;
import time.Date;
import time.Time;
import time.alarm.Alarm;
import time.alarm.AlarmSystem;
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
		
		AlarmSystem as = (AlarmSystem) AlarmSystem.getInstance();
		as.start();
	
		as.addAlarm(new Alarm(22, 07, 0));
		
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		
		while(!line.equals("hi")) {
			
			System.out.println(line);
			
			if(line.equals("stop"))
				as.stop();
			// TODO stop sound
			line = s.nextLine();
		}
		
		as.stop();
	}
	
	/*Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH); // Note: zero based!
	int day = now.get(Calendar.DAY_OF_MONTH);
	int hour = now.get(Calendar.HOUR_OF_DAY);
	int minute = now.get(Calendar.MINUTE);
	int second = now.get(Calendar.SECOND);
	int millis2 = now.get(Calendar.MILLISECOND);*/

}

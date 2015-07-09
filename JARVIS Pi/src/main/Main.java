package main;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import time.Date;
import time.Time;
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
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH); // Note: zero based!
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int millis2 = now.get(Calendar.MILLISECOND);

		System.out.printf("%d-%02d-%02d %02d:%02d:%02d.%03d", year, month + 1, day, hour, minute, second, millis2);
		
		Time time = Time.getCurrentTime();
		System.out.println("" + time.getHours() + "-" + time.getMinutes() + "-" + time.getSeconds());
		// TODO not working
		Date date = Date.getCurrentDate();
		System.out.println(date.getYear() + "-" + date.getMonth() + "-" + date.getDay() + "-" + date.getTime().getHours() + "-" + date.getTime().getMinutes() + "-" + date.getTime().getSeconds());

	}

}

package time;

import java.util.Calendar;

public class Date implements Comparable<Date> {

	public static final int minYear = 0;
	public static final int maxYear = 4000;
	public static final int minMonth = 1;
	public static final int maxMonth = 12;
	public static final int minDay = 1;
	public static final int monthDaysNormalYear[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int monthDaysLeapYear[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	private Time time;

	protected int year;
	protected int month;
	protected int day;

	public Date(int year, int month, int day, int hours, int minutes, int seconds) throws IllegalArgumentException {
		
		if(!validDate(year, month, hours))
			throw new IllegalArgumentException();

		this.time = new Time(hours, minutes, seconds);
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Date(int year, int month, int day) {
		this(year, month, day, 0, 0, 0);
	}

	public Date() {
		this(0, 1, 1);
	}

	public int compareTo(Date o) {

		if(year < o.year) return -1;
		else if(year > o.year) return 1;
		
		if(month < o.month) return -1;
		else if(month > o.month) return 1;
		
		if(day < o.day) return -1;
		else if(day > o.day) return 1;
		
		return time.compareTo(o.time);
	}
	
	public Boolean validDate(int year, int month, int day) {
		if(year < minYear || year > maxYear || month < minMonth || month > maxMonth || day < minDay)
			return false;
		
		if(year % 4 == 0) {		// Leap year
			if(day > monthDaysLeapYear[month-1])
				return false;
		} else {				// Normal year
			if(day > monthDaysNormalYear[month-1])
				return false;
		}
		
		return true;
	}
	
	public Time getTime() {
		return time;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public static Date getCurrentDate() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH); // Note: zero based!
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(":" + year + "," + month + "," + day);
		
		Date date = new Date(year, month, day);
		date.setTime(Time.getCurrentTime());
		
		return new Date();
	}

}

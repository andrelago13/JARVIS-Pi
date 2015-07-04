package time;

public class Date implements Comparable<Date> {
	
	// TODO make getter and setter with validity verification

	private Time time;

	protected int year;
	protected int month;
	protected int day;

	protected static final int monthDaysNormalYear[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	protected static final int monthDaysLeapYear[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public Date(int year, int month, int day, int hours, int minutes, int seconds) throws IllegalArgumentException {
		
		if(year < 0 || year > 4000 || month < 1 || month > 12 || day < 0)
			throw new IllegalArgumentException();
		
		if(year % 4 == 0) {		// Leap year
			if(day > monthDaysLeapYear[month-1])
				throw new IllegalArgumentException();
		} else {				// Normal year
			if(day > monthDaysNormalYear[month-1])
				throw new IllegalArgumentException();
		}
		
		this.year = year;
		this.month = month;
		this.day = day;
		this.time = new Time(hours, minutes, seconds);
	}

	public Date(int year, int month, int day) {
		this(year, month, day, 0, 0, 0);
	}

	public Date() {
		this(0, 0, 0);
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

}

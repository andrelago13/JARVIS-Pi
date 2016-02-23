package main;

import java.io.IOException;

import configuration.language.TextSystem;
import weather.WUCondition;
import weather.WUForecast;
import weather.WeatherUnderground;
import jarvis.interaction.Interactor;

public class Main {

	/*private static final int SECOND = 1000;
	private static final int MINUTE = 60 * SECOND;
	private static final int HOUR = 60 * MINUTE;
	private static final int DAY = 24 * HOUR;*/

	public static void main(String[] args) throws Exception {
		
		Interactor it;
		try {
			it = new Interactor();
			it.run();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.exit(0);
		
		/*AlarmSystem as = (AlarmSystem) AlarmSystem.getInstance();
		as.start();
	
		as.addAlarm(new Alarm(8, 17, 0));
		
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		
		while(!line.equals("hi")) {
			
			System.out.println(line);
			
			if(line.equals("stop"))
				as.stop();
			if(line.equals("again")) {
				as.getAlarms().get(0).setTime(new Time(8, 12, 0));
				as.getAlarms().get(0).schedule();
			}
			line = s.nextLine();
		}
		
		as.stop();*/
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

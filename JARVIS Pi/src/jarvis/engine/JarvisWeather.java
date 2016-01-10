package jarvis.engine;

import weather.WUCondition;
import weather.WeatherUnderground;
import configuration.language.TextSystem;

public class JarvisWeather {
	
	public static String replyTo(String message) {
		if(TextSystem.isWeatherCondition(message)) {
			WUCondition wc = WeatherUnderground.getWeatherCondition();
			return TextSystem.weatherConditionMessage(wc.getCity(), wc.getWeather(), wc.getTemperatureCelsius());
		}
		
		return null;
	}

}

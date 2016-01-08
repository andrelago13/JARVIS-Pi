package weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherUnderground {
	
	private final static String test_string = "{\"response\":{\"features\":{\"conditions\":1},\"version\":\"0.1\",\"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\"},\"current_observation\":{\"nowcast\":\"\",\"temp_c\":15.2,\"observation_epoch\":\"1452211371\",\"temp_f\":59.3,\"wind_kph\":31.5,\"wind_mph\":19.6,\"wind_degrees\":244,\"temperature_string\":\"59.3 F (15.2 C)\",\"weather\":\"Mostly Cloudy\",\"feelslike_string\":\"59.3 F (15.2 C)\",\"precip_today_metric\":\"0\",\"precip_1hr_string\":\"0.00 in ( 0 mm)\",\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif\",\"image\":{\"link\":\"http://www.wunderground.com\",\"title\":\"Weather Underground\",\"url\":\"http://icons.wxug.com/graphics/wu2/logo_130x80.png\"},\"UV\":\"0\",\"station_id\":\"IPORTOTR2\",\"local_epoch\":\"1452211388\",\"local_tz_short\":\"WET\",\"wind_dir\":\"WSW\",\"precip_1hr_metric\":\" 0\",\"pressure_in\":\"29.86\",\"local_tz_long\":\"Europe/Lisbon\",\"wind_gust_mph\":\"19.6\",\"windchill_string\":\"NA\",\"wind_gust_kph\":\"31.5\",\"wind_string\":\"From the WSW at 19.6 MPH Gusting to 19.6 MPH\",\"local_time_rfc822\":\"Fri, 08 Jan 2016 00:03:08 +0000\",\"visibility_km\":\"10.0\",\"relative_humidity\":\"90%\",\"pressure_mb\":\"1011\",\"observation_time_rfc822\":\"Fri, 08 Jan 2016 00:02:51 +0000\",\"precip_1hr_in\":\"0.00\",\"feelslike_c\":\"15.2\",\"observation_time\":\"Last Updated on January 8, 12:02 AM WET\",\"feelslike_f\":\"59.3\",\"history_url\":\"http://www.wunderground.com/weatherstation/WXDailyHistory.asp?ID=IPORTOTR2\",\"windchill_f\":\"NA\",\"windchill_c\":\"NA\",\"precip_today_string\":\"0.00 in (0 mm)\",\"icon\":\"mostlycloudy\",\"precip_today_in\":\"0.00\",\"solarradiation\":\"--\",\"observation_location\":{\"elevation\":\"100 ft\",\"country\":\"PORTUGAL\",\"country_iso3166\":\"PT\",\"city\":\"Trofa\",\"latitude\":\"41.337067\",\"state\":\"PORTO\",\"full\":\"Trofa, PORTO\",\"longitude\":\"-8.562834\"},\"dewpoint_f\":56,\"display_location\":{\"zip\":\"00000\",\"magic\":\"7\",\"elevation\":\"230.00000000\",\"country\":\"PO\",\"country_iso3166\":\"PT\",\"city\":\"Maia\",\"state_name\":\"Portugal\",\"latitude\":\"41.27861023\",\"wmo\":\"08545\",\"state\":\"\",\"full\":\"Maia, Portugal\",\"longitude\":\"-8.50194454\"},\"dewpoint_string\":\"56 F (14 C)\",\"pressure_trend\":\"0\",\"dewpoint_c\":14,\"estimated\":{},\"forecast_url\":\"http://www.wunderground.com/global/stations/08545.html\",\"local_tz_offset\":\"+0000\",\"heat_index_f\":\"NA\",\"heat_index_c\":\"NA\",\"ob_url\":\"http://www.wunderground.com/cgi-bin/findweather/getForecast?query=41.337067,-8.562834\",\"heat_index_string\":\"NA\",\"visibility_mi\":\"6.2\"}}";

	private JSONObject reply_json = null;
	
	public static final void getWeather(){
		URL url;
		try {
			/*url = new URL("http://api.wunderground.com/api/303e97c620bdeff9/conditions/q/Portugal/Maia.json");
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			String body = IOUtils.toString(in, encoding);*/
			
			JSONObject obj = new JSONObject(test_string);
			JSONObject obj2 = obj.getJSONObject("current_observation");
		    System.out.println(obj2.get("temp_c"));
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private WeatherUnderground(JSONObject reply_json) {
		this.reply_json = reply_json;
	}
	
	public static WeatherUnderground getCurrentWeather() {
		/*url = new URL("http://api.wunderground.com/api/303e97c620bdeff9/conditions/q/Portugal/Maia.json");
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);*/
		
		JSONObject reply_json = new JSONObject(test_string);
		return new WeatherUnderground(reply_json);
	}
	
	public String getWeatherCondition() {
		return (reply_json.getJSONObject("current_observation")).getString("weather");
	}

}

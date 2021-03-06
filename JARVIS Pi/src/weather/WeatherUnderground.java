package weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import time.Date;
import time.Time;

public class WeatherUnderground {

	private final static String test_string_condition = "{\"response\":{\"features\":{\"conditions\":1},\"version\":\"0.1\",\"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\"},\"current_observation\":{\"nowcast\":\"\",\"temp_c\":15.2,\"observation_epoch\":\"1452211371\",\"temp_f\":59.3,\"wind_kph\":31.5,\"wind_mph\":19.6,\"wind_degrees\":244,\"temperature_string\":\"59.3 F (15.2 C)\",\"weather\":\"Mostly Cloudy\",\"feelslike_string\":\"59.3 F (15.2 C)\",\"precip_today_metric\":\"0\",\"precip_1hr_string\":\"0.00 in ( 0 mm)\",\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif\",\"image\":{\"link\":\"http://www.wunderground.com\",\"title\":\"Weather Underground\",\"url\":\"http://icons.wxug.com/graphics/wu2/logo_130x80.png\"},\"UV\":\"0\",\"station_id\":\"IPORTOTR2\",\"local_epoch\":\"1452211388\",\"local_tz_short\":\"WET\",\"wind_dir\":\"WSW\",\"precip_1hr_metric\":\" 0\",\"pressure_in\":\"29.86\",\"local_tz_long\":\"Europe/Lisbon\",\"wind_gust_mph\":\"19.6\",\"windchill_string\":\"NA\",\"wind_gust_kph\":\"31.5\",\"wind_string\":\"From the WSW at 19.6 MPH Gusting to 19.6 MPH\",\"local_time_rfc822\":\"Fri, 08 Jan 2016 00:03:08 +0000\",\"visibility_km\":\"10.0\",\"relative_humidity\":\"90%\",\"pressure_mb\":\"1011\",\"observation_time_rfc822\":\"Fri, 08 Jan 2016 00:02:51 +0000\",\"precip_1hr_in\":\"0.00\",\"feelslike_c\":\"15.2\",\"observation_time\":\"Last Updated on January 8, 12:02 AM WET\",\"feelslike_f\":\"59.3\",\"history_url\":\"http://www.wunderground.com/weatherstation/WXDailyHistory.asp?ID=IPORTOTR2\",\"windchill_f\":\"NA\",\"windchill_c\":\"NA\",\"precip_today_string\":\"0.00 in (0 mm)\",\"icon\":\"mostlycloudy\",\"precip_today_in\":\"0.00\",\"solarradiation\":\"--\",\"observation_location\":{\"elevation\":\"100 ft\",\"country\":\"PORTUGAL\",\"country_iso3166\":\"PT\",\"city\":\"Trofa\",\"latitude\":\"41.337067\",\"state\":\"PORTO\",\"full\":\"Trofa, PORTO\",\"longitude\":\"-8.562834\"},\"dewpoint_f\":56,\"display_location\":{\"zip\":\"00000\",\"magic\":\"7\",\"elevation\":\"230.00000000\",\"country\":\"PO\",\"country_iso3166\":\"PT\",\"city\":\"Maia\",\"state_name\":\"Portugal\",\"latitude\":\"41.27861023\",\"wmo\":\"08545\",\"state\":\"\",\"full\":\"Maia, Portugal\",\"longitude\":\"-8.50194454\"},\"dewpoint_string\":\"56 F (14 C)\",\"pressure_trend\":\"0\",\"dewpoint_c\":14,\"estimated\":{},\"forecast_url\":\"http://www.wunderground.com/global/stations/08545.html\",\"local_tz_offset\":\"+0000\",\"heat_index_f\":\"NA\",\"heat_index_c\":\"NA\",\"ob_url\":\"http://www.wunderground.com/cgi-bin/findweather/getForecast?query=41.337067,-8.562834\",\"heat_index_string\":\"NA\",\"visibility_mi\":\"6.2\"}}";
	private final static String test_string_forecast = " { \"response\": { \"version\":\"0.1\", \"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\", \"features\": { \"forecast\": 1 } } , \"forecast\":{ \"txt_forecast\": { \"date\":\"10:36 AM WET\", \"forecastday\": [ { \"period\":0, \"icon\":\"rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/rain.gif\", \"title\":\"Friday\", \"fcttext\":\"Cloudy. Periods of rain this morning. The rain may be heavy at times. High around 55F. Winds W at 5 to 10 mph. Chance of rain 100%. Rainfall around a quarter of an inch.\", \"fcttext_metric\":\"Rain, possibly heavy at times, ending this morning. Remaining cloudy in the afternoon. High 13C. Winds W at 10 to 15 km/h. Chance of rain 100%. Rainfall around 6mm.\", \"pop\":\"100\" } , { \"period\":1, \"icon\":\"nt_chancerain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/nt_chancerain.gif\", \"title\":\"Friday Night\", \"fcttext\":\"Cloudy skies with periods of light rain late. Low near 45F. Winds SW at 5 to 10 mph. Chance of rain 50%.\", \"fcttext_metric\":\"Cloudy with occasional light rain late. Low 7C. Winds SW at 10 to 15 km/h. Chance of rain 50%.\", \"pop\":\"50\" } , { \"period\":2, \"icon\":\"rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/rain.gif\", \"title\":\"Saturday\", \"fcttext\":\"Periods of rain. High near 55F. Winds SW at 15 to 25 mph. Chance of rain 100%. 1 to 2 inches of rain expected.\", \"fcttext_metric\":\"Rain. High 13C. Winds SW at 25 to 40 km/h. Chance of rain 100%. 25 to 50mm of rain expected.\", \"pop\":\"100\" } , { \"period\":3, \"icon\":\"nt_rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/nt_rain.gif\", \"title\":\"Saturday Night\", \"fcttext\":\"Showers and thundershowers during the evening, then cloudy and windy overnight with periods of rain, heavy at times. Low 51F. Winds SW at 20 to 30 mph. Chance of rain 100%. 2 to 3 inches of rain expected.\", \"fcttext_metric\":\"Showers and thundershowers in the evening, windy overnight with rain likely - it will be heavy at times. Low 11C. Winds SW at 30 to 50 km/h. Chance of rain 100%. 50 to 75mm of rain expected.\", \"pop\":\"100\" } , { \"period\":4, \"icon\":\"rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/rain.gif\", \"title\":\"Sunday\", \"fcttext\":\"Cloudy with periods of rain...which may be heavy early. Becoming windy in the afternoon. High 56F. Winds SW at 25 to 35 mph. Chance of rain 100%. 1 to 2 inches of rain expected.\", \"fcttext_metric\":\"Rain likely...possibly heavy early. Becoming windy in the afternoon. High 13C. Winds SW at 30 to 50 km/h. Chance of rain 100%. 25 to 50mm of rain expected.\", \"pop\":\"100\" } , { \"period\":5, \"icon\":\"nt_rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/nt_rain.gif\", \"title\":\"Sunday Night\", \"fcttext\":\"Windy at times with periods of rain. Low 49F. Winds WSW at 25 to 35 mph. Chance of rain 100%. Rainfall near an inch.\", \"fcttext_metric\":\"Windy at times with periods of rain. Low around 10C. WSW winds at 40 to 55 km/h, decreasing to 15 to 30 km/h. Chance of rain 100%. Rainfall may reach 25mm.\", \"pop\":\"100\" } , { \"period\":6, \"icon\":\"rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/rain.gif\", \"title\":\"Monday\", \"fcttext\":\"Rain. High 53F. Winds W at 10 to 20 mph. Chance of rain 80%. Rainfall around a quarter of an inch.\", \"fcttext_metric\":\"Rain. High 12C. Winds W at 15 to 30 km/h. Chance of rain 80%. Rainfall near 6mm.\", \"pop\":\"80\" } , { \"period\":7, \"icon\":\"nt_chancerain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/nt_chancerain.gif\", \"title\":\"Monday Night\", \"fcttext\":\"Cloudy with occasional light rain. Low around 45F. Winds W at 5 to 10 mph. Chance of rain 80%.\", \"fcttext_metric\":\"Cloudy. Some light rain is likely. Low 7C. Winds W at 10 to 15 km/h. Chance of rain 80%.\", \"pop\":\"80\" } ] }, \"simpleforecast\": { \"forecastday\": [ {\"date\":{ \"epoch\":\"1452279600\", \"pretty\":\"7:00 PM WET on January 08, 2016\", \"day\":8, \"month\":1, \"year\":2016, \"yday\":7, \"hour\":19, \"min\":\"00\", \"sec\":0, \"isdst\":\"0\", \"monthname\":\"January\", \"monthname_short\":\"Jan\", \"weekday_short\":\"Fri\", \"weekday\":\"Friday\", \"ampm\":\"PM\", \"tz_short\":\"WET\", \"tz_long\":\"Europe/Lisbon\" }, \"period\":1, \"high\": { \"fahrenheit\":\"55\", \"celsius\":\"13\" }, \"low\": { \"fahrenheit\":\"45\", \"celsius\":\"7\" }, \"conditions\":\"Rain\", \"icon\":\"rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/rain.gif\", \"skyicon\":\"\", \"pop\":100, \"qpf_allday\": { \"in\": 0.74, \"mm\": 19 }, \"qpf_day\": { \"in\": 0.35, \"mm\": 9 }, \"qpf_night\": { \"in\": 0.04, \"mm\": 1 }, \"snow_allday\": { \"in\": 0.0, \"cm\": 0.0 }, \"snow_day\": { \"in\": 0.0, \"cm\": 0.0 }, \"snow_night\": { \"in\": 0.0, \"cm\": 0.0 }, \"maxwind\": { \"mph\": 10, \"kph\": 16, \"dir\": \"W\", \"degrees\": 276 }, \"avewind\": { \"mph\": 9, \"kph\": 14, \"dir\": \"W\", \"degrees\": 276 }, \"avehumidity\": 88, \"maxhumidity\": 0, \"minhumidity\": 0 } , {\"date\":{ \"epoch\":\"1452366000\", \"pretty\":\"7:00 PM WET on January 09, 2016\", \"day\":9, \"month\":1, \"year\":2016, \"yday\":8, \"hour\":19, \"min\":\"00\", \"sec\":0, \"isdst\":\"0\", \"monthname\":\"January\", \"monthname_short\":\"Jan\", \"weekday_short\":\"Sat\", \"weekday\":\"Saturday\", \"ampm\":\"PM\", \"tz_short\":\"WET\", \"tz_long\":\"Europe/Lisbon\" }, \"period\":2, \"high\": { \"fahrenheit\":\"55\", \"celsius\":\"13\" }, \"low\": { \"fahrenheit\":\"51\", \"celsius\":\"11\" }, \"conditions\":\"Rain\", \"icon\":\"rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/rain.gif\", \"skyicon\":\"\", \"pop\":100, \"qpf_allday\": { \"in\": 4.03, \"mm\": 102 }, \"qpf_day\": { \"in\": 1.24, \"mm\": 31 }, \"qpf_night\": { \"in\": 2.79, \"mm\": 71 }, \"snow_allday\": { \"in\": 0.0, \"cm\": 0.0 }, \"snow_day\": { \"in\": 0.0, \"cm\": 0.0 }, \"snow_night\": { \"in\": 0.0, \"cm\": 0.0 }, \"maxwind\": { \"mph\": 25, \"kph\": 40, \"dir\": \"SW\", \"degrees\": 223 }, \"avewind\": { \"mph\": 18, \"kph\": 29, \"dir\": \"SW\", \"degrees\": 223 }, \"avehumidity\": 89, \"maxhumidity\": 0, \"minhumidity\": 0 } , {\"date\":{ \"epoch\":\"1452452400\", \"pretty\":\"7:00 PM WET on January 10, 2016\", \"day\":10, \"month\":1, \"year\":2016, \"yday\":9, \"hour\":19, \"min\":\"00\", \"sec\":0, \"isdst\":\"0\", \"monthname\":\"January\", \"monthname_short\":\"Jan\", \"weekday_short\":\"Sun\", \"weekday\":\"Sunday\", \"ampm\":\"PM\", \"tz_short\":\"WET\", \"tz_long\":\"Europe/Lisbon\" }, \"period\":3, \"high\": { \"fahrenheit\":\"56\", \"celsius\":\"13\" }, \"low\": { \"fahrenheit\":\"49\", \"celsius\":\"9\" }, \"conditions\":\"Rain\", \"icon\":\"rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/rain.gif\", \"skyicon\":\"\", \"pop\":100, \"qpf_allday\": { \"in\": 2.78, \"mm\": 71 }, \"qpf_day\": { \"in\": 1.76, \"mm\": 45 }, \"qpf_night\": { \"in\": 1.02, \"mm\": 26 }, \"snow_allday\": { \"in\": 0.0, \"cm\": 0.0 }, \"snow_day\": { \"in\": 0.0, \"cm\": 0.0 }, \"snow_night\": { \"in\": 0.0, \"cm\": 0.0 }, \"maxwind\": { \"mph\": 35, \"kph\": 56, \"dir\": \"SW\", \"degrees\": 223 }, \"avewind\": { \"mph\": 25, \"kph\": 40, \"dir\": \"SW\", \"degrees\": 223 }, \"avehumidity\": 91, \"maxhumidity\": 0, \"minhumidity\": 0 } , {\"date\":{ \"epoch\":\"1452538800\", \"pretty\":\"7:00 PM WET on January 11, 2016\", \"day\":11, \"month\":1, \"year\":2016, \"yday\":10, \"hour\":19, \"min\":\"00\", \"sec\":0, \"isdst\":\"0\", \"monthname\":\"January\", \"monthname_short\":\"Jan\", \"weekday_short\":\"Mon\", \"weekday\":\"Monday\", \"ampm\":\"PM\", \"tz_short\":\"WET\", \"tz_long\":\"Europe/Lisbon\" }, \"period\":4, \"high\": { \"fahrenheit\":\"53\", \"celsius\":\"12\" }, \"low\": { \"fahrenheit\":\"45\", \"celsius\":\"7\" }, \"conditions\":\"Rain\", \"icon\":\"rain\", \"icon_url\":\"http://icons.wxug.com/i/c/k/rain.gif\", \"skyicon\":\"\", \"pop\":80, \"qpf_allday\": { \"in\": 0.47, \"mm\": 12 }, \"qpf_day\": { \"in\": 0.24, \"mm\": 6 }, \"qpf_night\": { \"in\": 0.24, \"mm\": 6 }, \"snow_allday\": { \"in\": 0.0, \"cm\": 0.0 }, \"snow_day\": { \"in\": 0.0, \"cm\": 0.0 }, \"snow_night\": { \"in\": 0.0, \"cm\": 0.0 }, \"maxwind\": { \"mph\": 20, \"kph\": 32, \"dir\": \"W\", \"degrees\": 264 }, \"avewind\": { \"mph\": 15, \"kph\": 24, \"dir\": \"W\", \"degrees\": 264 }, \"avehumidity\": 72, \"maxhumidity\": 0, \"minhumidity\": 0 } ] } } }";
	
	private final static String condition_url = "http://api.wunderground.com/api/303e97c620bdeff9/conditions/q/Portugal/Maia.json";
	private final static String forecast_url = "http://api.wunderground.com/api/303e97c620bdeff9/forecast/q/Portugal/Maia.json";

	private static Date lastCheckDate_condition = null;
	private static WUCondition last_condition = null;
	private static Date lastCheckDate_forecast = null;
	private static WUForecast last_forecast = null;
	private static final int refresh_timeout = 3600000;	// 60 minutes in milliseconds

	public static WUCondition getWeatherCondition() {

		if(!mustUpdate(lastCheckDate_condition)) {
			return last_condition;
		} else {
			lastCheckDate_condition = Date.getCurrentDate();
		}

		try {
			JSONObject reply_json = getJsonRequest(condition_url);

			last_condition = new WUCondition(reply_json);
			return last_condition;		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static WUForecast getWeatherForecast() {

		if(!mustUpdate(lastCheckDate_forecast)) {
			return last_forecast;
		} else {
			lastCheckDate_forecast = Date.getCurrentDate();
		}

		try {
			JSONObject reply_json = getJsonRequest(forecast_url);

			last_forecast = new WUForecast(reply_json);
			return last_forecast;
		} catch (IOException e) {
			e.printStackTrace();
		}	

		return null;
	}

	private static Boolean mustUpdate(Date lastCheckDate) {
		if(lastCheckDate == null)
			return true;

		Date date = Date.getCurrentDate();
		
		if(date.compareTo(lastCheckDate) == 0) {	// SAME DAY -> COMPARE TIME
			Time currTime = date.getTime();
			Time lastTime = lastCheckDate.getTime();
			if(currTime.difference(lastTime).toMillis() > refresh_timeout) {
				return true;
			} else {
				return false;
			}
		} else {									// DIFFERENT DAY -> UPDATE
			return true;
		}
	}
	
	private static JSONObject getJsonRequest(String url_str) throws IOException {
		URL url = new URL(url_str);
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);

		return new JSONObject(body);
	}

}

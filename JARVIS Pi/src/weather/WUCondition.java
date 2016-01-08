package weather;

import org.json.JSONObject;

public class WUCondition {

	private JSONObject condition = null;
	
	public WUCondition(JSONObject condition_json) {
		setCondition(condition_json);
	}
	
	public void setCondition(JSONObject condition_json) {
		condition = condition_json;
	}
	
	public JSONObject getCondition() {
		return condition;
	}
	
	public JSONObject getCurrentObservation() {
		return condition.getJSONObject("current_observation");
	}
	
	public JSONObject getDisplayLocation() {
		return getCurrentObservation().getJSONObject("display_location");
	}
	
	public String getCity() {
		return getDisplayLocation().getString("city");
	}
	
	public String getWeather() {
		return getCurrentObservation().getString("weather");
	}
	
	public double getTemperature() {
		return getTemperatureCelsius();
	}
	
	public double getTemperatureCelsius() {
		return getCurrentObservation().getDouble("temp_c");
	}
	
	public double getTemperatureFahrenheit() {
		return getCurrentObservation().getDouble("temp_f");
	}
}

/*
 
{
  "response": {
  "version":"0.1",
  "termsofService":"http://www.wunderground.com/weather/api/d/terms.html",
  "features": {
  "conditions": 1
  }
	}
  ,	"current_observation": {
		"image": {
		"url":"http://icons.wxug.com/graphics/wu2/logo_130x80.png",
		"title":"Weather Underground",
		"link":"http://www.wunderground.com"
		},
		"display_location": {
		"full":"Maia, Portugal",
		"city":"Maia",
		"state":"",
		"state_name":"Portugal",
		"country":"PO",
		"country_iso3166":"PT",
		"zip":"00000",
		"magic":"7",
		"wmo":"08545",
		"latitude":"41.27861023",
		"longitude":"-8.50194454",
		"elevation":"230.00000000"
		},
		"observation_location": {
		"full":"Trofa, PORTO",
		"city":"Trofa",
		"state":"PORTO",
		"country":"PORTUGAL",
		"country_iso3166":"PT",
		"latitude":"41.337067",
		"longitude":"-8.562834",
		"elevation":"100 ft"
		},
		"estimated": {
		},
		"station_id":"IPORTOTR2",
		"observation_time":"Last Updated on January 7, 11:33 PM WET",
		"observation_time_rfc822":"Thu, 07 Jan 2016 23:33:45 +0000",
		"observation_epoch":"1452209625",
		"local_time_rfc822":"Thu, 07 Jan 2016 23:34:02 +0000",
		"local_epoch":"1452209642",
		"local_tz_short":"WET",
		"local_tz_long":"Europe/Lisbon",
		"local_tz_offset":"+0000",
		"weather":"Mostly Cloudy",
		"temperature_string":"58.6 F (14.8 C)",
		"temp_f":58.6,
		"temp_c":14.8,
		"relative_humidity":"91%",
		"wind_string":"From the SW at 15.0 MPH Gusting to 15.0 MPH",
		"wind_dir":"SW",
		"wind_degrees":225,
		"wind_mph":15.0,
		"wind_gust_mph":"15.0",
		"wind_kph":24.1,
		"wind_gust_kph":"24.1",
		"pressure_mb":"1011",
		"pressure_in":"29.86",
		"pressure_trend":"-",
		"dewpoint_string":"56 F (13 C)",
		"dewpoint_f":56,
		"dewpoint_c":13,
		"heat_index_string":"NA",
		"heat_index_f":"NA",
		"heat_index_c":"NA",
		"windchill_string":"NA",
		"windchill_f":"NA",
		"windchill_c":"NA",
		"feelslike_string":"58.6 F (14.8 C)",
		"feelslike_f":"58.6",
		"feelslike_c":"14.8",
		"visibility_mi":"6.2",
		"visibility_km":"10.0",
		"solarradiation":"--",
		"UV":"0","precip_1hr_string":"0.00 in ( 0 mm)",
		"precip_1hr_in":"0.00",
		"precip_1hr_metric":" 0",
		"precip_today_string":"0.27 in (7 mm)",
		"precip_today_in":"0.27",
		"precip_today_metric":"7",
		"icon":"mostlycloudy",
		"icon_url":"http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif",
		"forecast_url":"http://www.wunderground.com/global/stations/08545.html",
		"history_url":"http://www.wunderground.com/weatherstation/WXDailyHistory.asp?ID=IPORTOTR2",
		"ob_url":"http://www.wunderground.com/cgi-bin/findweather/getForecast?query=41.337067,-8.562834",
		"nowcast":""
	}
}
*/

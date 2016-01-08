package weather;

import org.json.JSONObject;

public class WUForecast {

	private JSONObject forecast = null;
	
	public WUForecast(JSONObject forecast_json) {
		setForecast(forecast_json);
	}
	
	public void setForecast(JSONObject forecast_json) {
		forecast = forecast_json;
	}
	
	public JSONObject getForecast() {
		return forecast;
	}

}

/*

{
  "response": {
  "version":"0.1",
  "termsofService":"http://www.wunderground.com/weather/api/d/terms.html",
  "features": {
  "forecast": 1
  }
	}
		,
	"forecast":{
		"txt_forecast": {
		"date":"10:36 AM WET",
		"forecastday": [
		{
		"period":0,
		"icon":"rain",
		"icon_url":"http://icons.wxug.com/i/c/k/rain.gif",
		"title":"Friday",
		"fcttext":"Cloudy. Periods of rain this morning. The rain may be heavy at times. High around 55F. Winds W at 5 to 10 mph. Chance of rain 100%. Rainfall around a quarter of an inch.",
		"fcttext_metric":"Rain, possibly heavy at times, ending this morning. Remaining cloudy in the afternoon. High 13C. Winds W at 10 to 15 km/h. Chance of rain 100%. Rainfall around 6mm.",
		"pop":"100"
		}
		,
		{
		"period":1,
		"icon":"nt_chancerain",
		"icon_url":"http://icons.wxug.com/i/c/k/nt_chancerain.gif",
		"title":"Friday Night",
		"fcttext":"Cloudy skies with periods of light rain late. Low near 45F. Winds SW at 5 to 10 mph. Chance of rain 50%.",
		"fcttext_metric":"Cloudy with occasional light rain late. Low 7C. Winds SW at 10 to 15 km/h. Chance of rain 50%.",
		"pop":"50"
		}
		,
		{
		"period":2,
		"icon":"rain",
		"icon_url":"http://icons.wxug.com/i/c/k/rain.gif",
		"title":"Saturday",
		"fcttext":"Periods of rain. High near 55F. Winds SW at 15 to 25 mph. Chance of rain 100%. 1 to 2 inches of rain expected.",
		"fcttext_metric":"Rain. High 13C. Winds SW at 25 to 40 km/h. Chance of rain 100%. 25 to 50mm of rain expected.",
		"pop":"100"
		}
		,
		{
		"period":3,
		"icon":"nt_rain",
		"icon_url":"http://icons.wxug.com/i/c/k/nt_rain.gif",
		"title":"Saturday Night",
		"fcttext":"Showers and thundershowers during the evening, then cloudy and windy overnight with periods of rain, heavy at times. Low 51F. Winds SW at 20 to 30 mph. Chance of rain 100%. 2 to 3 inches of rain expected.",
		"fcttext_metric":"Showers and thundershowers in the evening, windy overnight with rain likely - it will be heavy at times. Low 11C. Winds SW at 30 to 50 km/h. Chance of rain 100%. 50 to 75mm of rain expected.",
		"pop":"100"
		}
		,
		{
		"period":4,
		"icon":"rain",
		"icon_url":"http://icons.wxug.com/i/c/k/rain.gif",
		"title":"Sunday",
		"fcttext":"Cloudy with periods of rain...which may be heavy early. Becoming windy in the afternoon. High 56F. Winds SW at 25 to 35 mph. Chance of rain 100%. 1 to 2 inches of rain expected.",
		"fcttext_metric":"Rain likely...possibly heavy early. Becoming windy in the afternoon. High 13C. Winds SW at 30 to 50 km/h. Chance of rain 100%. 25 to 50mm of rain expected.",
		"pop":"100"
		}
		,
		{
		"period":5,
		"icon":"nt_rain",
		"icon_url":"http://icons.wxug.com/i/c/k/nt_rain.gif",
		"title":"Sunday Night",
		"fcttext":"Windy at times with periods of rain. Low 49F. Winds WSW at 25 to 35 mph. Chance of rain 100%. Rainfall near an inch.",
		"fcttext_metric":"Windy at times with periods of rain. Low around 10C. WSW winds at 40 to 55 km/h, decreasing to 15 to 30 km/h. Chance of rain 100%. Rainfall may reach 25mm.",
		"pop":"100"
		}
		,
		{
		"period":6,
		"icon":"rain",
		"icon_url":"http://icons.wxug.com/i/c/k/rain.gif",
		"title":"Monday",
		"fcttext":"Rain. High 53F. Winds W at 10 to 20 mph. Chance of rain 80%. Rainfall around a quarter of an inch.",
		"fcttext_metric":"Rain. High 12C. Winds W at 15 to 30 km/h. Chance of rain 80%. Rainfall near 6mm.",
		"pop":"80"
		}
		,
		{
		"period":7,
		"icon":"nt_chancerain",
		"icon_url":"http://icons.wxug.com/i/c/k/nt_chancerain.gif",
		"title":"Monday Night",
		"fcttext":"Cloudy with occasional light rain. Low around 45F. Winds W at 5 to 10 mph. Chance of rain 80%.",
		"fcttext_metric":"Cloudy. Some light rain is likely. Low 7C. Winds W at 10 to 15 km/h. Chance of rain 80%.",
		"pop":"80"
		}
		]
		},
		"simpleforecast": {
		"forecastday": [
		{"date":{
	"epoch":"1452279600",
	"pretty":"7:00 PM WET on January 08, 2016",
	"day":8,
	"month":1,
	"year":2016,
	"yday":7,
	"hour":19,
	"min":"00",
	"sec":0,
	"isdst":"0",
	"monthname":"January",
	"monthname_short":"Jan",
	"weekday_short":"Fri",
	"weekday":"Friday",
	"ampm":"PM",
	"tz_short":"WET",
	"tz_long":"Europe/Lisbon"
},
		"period":1,
		"high": {
		"fahrenheit":"55",
		"celsius":"13"
		},
		"low": {
		"fahrenheit":"45",
		"celsius":"7"
		},
		"conditions":"Rain",
		"icon":"rain",
		"icon_url":"http://icons.wxug.com/i/c/k/rain.gif",
		"skyicon":"",
		"pop":100,
		"qpf_allday": {
		"in": 0.74,
		"mm": 19
		},
		"qpf_day": {
		"in": 0.35,
		"mm": 9
		},
		"qpf_night": {
		"in": 0.04,
		"mm": 1
		},
		"snow_allday": {
		"in": 0.0,
		"cm": 0.0
		},
		"snow_day": {
		"in": 0.0,
		"cm": 0.0
		},
		"snow_night": {
		"in": 0.0,
		"cm": 0.0
		},
		"maxwind": {
		"mph": 10,
		"kph": 16,
		"dir": "W",
		"degrees": 276
		},
		"avewind": {
		"mph": 9,
		"kph": 14,
		"dir": "W",
		"degrees": 276
		},
		"avehumidity": 88,
		"maxhumidity": 0,
		"minhumidity": 0
		}
		,
		{"date":{
	"epoch":"1452366000",
	"pretty":"7:00 PM WET on January 09, 2016",
	"day":9,
	"month":1,
	"year":2016,
	"yday":8,
	"hour":19,
	"min":"00",
	"sec":0,
	"isdst":"0",
	"monthname":"January",
	"monthname_short":"Jan",
	"weekday_short":"Sat",
	"weekday":"Saturday",
	"ampm":"PM",
	"tz_short":"WET",
	"tz_long":"Europe/Lisbon"
},
		"period":2,
		"high": {
		"fahrenheit":"55",
		"celsius":"13"
		},
		"low": {
		"fahrenheit":"51",
		"celsius":"11"
		},
		"conditions":"Rain",
		"icon":"rain",
		"icon_url":"http://icons.wxug.com/i/c/k/rain.gif",
		"skyicon":"",
		"pop":100,
		"qpf_allday": {
		"in": 4.03,
		"mm": 102
		},
		"qpf_day": {
		"in": 1.24,
		"mm": 31
		},
		"qpf_night": {
		"in": 2.79,
		"mm": 71
		},
		"snow_allday": {
		"in": 0.0,
		"cm": 0.0
		},
		"snow_day": {
		"in": 0.0,
		"cm": 0.0
		},
		"snow_night": {
		"in": 0.0,
		"cm": 0.0
		},
		"maxwind": {
		"mph": 25,
		"kph": 40,
		"dir": "SW",
		"degrees": 223
		},
		"avewind": {
		"mph": 18,
		"kph": 29,
		"dir": "SW",
		"degrees": 223
		},
		"avehumidity": 89,
		"maxhumidity": 0,
		"minhumidity": 0
		}
		,
		{"date":{
	"epoch":"1452452400",
	"pretty":"7:00 PM WET on January 10, 2016",
	"day":10,
	"month":1,
	"year":2016,
	"yday":9,
	"hour":19,
	"min":"00",
	"sec":0,
	"isdst":"0",
	"monthname":"January",
	"monthname_short":"Jan",
	"weekday_short":"Sun",
	"weekday":"Sunday",
	"ampm":"PM",
	"tz_short":"WET",
	"tz_long":"Europe/Lisbon"
},
		"period":3,
		"high": {
		"fahrenheit":"56",
		"celsius":"13"
		},
		"low": {
		"fahrenheit":"49",
		"celsius":"9"
		},
		"conditions":"Rain",
		"icon":"rain",
		"icon_url":"http://icons.wxug.com/i/c/k/rain.gif",
		"skyicon":"",
		"pop":100,
		"qpf_allday": {
		"in": 2.78,
		"mm": 71
		},
		"qpf_day": {
		"in": 1.76,
		"mm": 45
		},
		"qpf_night": {
		"in": 1.02,
		"mm": 26
		},
		"snow_allday": {
		"in": 0.0,
		"cm": 0.0
		},
		"snow_day": {
		"in": 0.0,
		"cm": 0.0
		},
		"snow_night": {
		"in": 0.0,
		"cm": 0.0
		},
		"maxwind": {
		"mph": 35,
		"kph": 56,
		"dir": "SW",
		"degrees": 223
		},
		"avewind": {
		"mph": 25,
		"kph": 40,
		"dir": "SW",
		"degrees": 223
		},
		"avehumidity": 91,
		"maxhumidity": 0,
		"minhumidity": 0
		}
		,
		{"date":{
	"epoch":"1452538800",
	"pretty":"7:00 PM WET on January 11, 2016",
	"day":11,
	"month":1,
	"year":2016,
	"yday":10,
	"hour":19,
	"min":"00",
	"sec":0,
	"isdst":"0",
	"monthname":"January",
	"monthname_short":"Jan",
	"weekday_short":"Mon",
	"weekday":"Monday",
	"ampm":"PM",
	"tz_short":"WET",
	"tz_long":"Europe/Lisbon"
},
		"period":4,
		"high": {
		"fahrenheit":"53",
		"celsius":"12"
		},
		"low": {
		"fahrenheit":"45",
		"celsius":"7"
		},
		"conditions":"Rain",
		"icon":"rain",
		"icon_url":"http://icons.wxug.com/i/c/k/rain.gif",
		"skyicon":"",
		"pop":80,
		"qpf_allday": {
		"in": 0.47,
		"mm": 12
		},
		"qpf_day": {
		"in": 0.24,
		"mm": 6
		},
		"qpf_night": {
		"in": 0.24,
		"mm": 6
		},
		"snow_allday": {
		"in": 0.0,
		"cm": 0.0
		},
		"snow_day": {
		"in": 0.0,
		"cm": 0.0
		},
		"snow_night": {
		"in": 0.0,
		"cm": 0.0
		},
		"maxwind": {
		"mph": 20,
		"kph": 32,
		"dir": "W",
		"degrees": 264
		},
		"avewind": {
		"mph": 15,
		"kph": 24,
		"dir": "W",
		"degrees": 264
		},
		"avehumidity": 72,
		"maxhumidity": 0,
		"minhumidity": 0
		}
		]
		}
	}
}
*/
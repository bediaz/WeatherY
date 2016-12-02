package com.brighamdiaz.weathery.model;

import com.brighamdiaz.weathery.R;
/**
 * Created by Brigham on 11/30/2016.
 */

public class ConditionCode {

    /**
     * Source: https://developer.yahoo.com/weather/documentation.html#codes
     */
    private static final String[] conditions = new String[]{"tornado", "tropical storm", "hurricane", "severe thunderstorms", "thunderstorms", "mixed rain and snow", "mixed rain and sleet", "mixed snow and sleet", "freezing drizzle", "drizzle", "freezing rain", "showers", "showers", "snow flurries", "light snow showers", "blowing snow", "snow", "hail", "sleet", "dust", "foggy", "haze", "smoky", "blustery", "windy", "cold", "cloudy", "mostly cloudy (night)", "mostly cloudy (day)", "partly cloudy (night)", "partly cloudy (day)", "clear (night)", "sunny", "fair (night)", "fair (day)", "mixed rain and hail", "hot", "isolated thunderstorms", "scattered thunderstorms", "scattered thunderstorms", "scattered showers", "heavy snow", "scattered snow showers", "heavy snow", "partly cloudy", "thundershowers", "snow showers", "isolated thundershowers"};

    private static final int[] dayWeatherIcons = {R.drawable.weather_mist, R.drawable.weather_mist, R.drawable.weather_mist, R.drawable.weather_storm_day, R.drawable.weather_storm_day, R.drawable.weather_snow_rain, R.drawable.weather_hail, R.drawable.weather_hail, R.drawable.weather_drizzle_day, R.drawable.weather_drizzle_day, R.drawable.weather_snow_rain, R.drawable.weather_showers_day, R.drawable.weather_showers_day, R.drawable.weather_snow_scattered_night, R.drawable.weather_snow, R.drawable.weather_big_snow, R.drawable.weather_big_snow, R.drawable.weather_hail, R.drawable.weather_hail, R.drawable.weather_wind, R.drawable.weather_fog, R.drawable.weather_haze, R.drawable.weather_haze, R.drawable.weather_mist, R.drawable.weather_wind, R.drawable.weather_clear_night, R.drawable.weather_clouds, R.drawable.weather_clouds_night, R.drawable.weather_few_clouds, R.drawable.weather_few_clouds_night, R.drawable.weather_few_clouds, R.drawable.weather_clear_night, R.drawable.weather_clear, R.drawable.weather_clear_night, R.drawable.weather_clear, R.drawable.weather_hail, R.drawable.weather_clear, R.drawable.weather_storm_day, R.drawable.weather_storm_day, R.drawable.weather_storm_day, R.drawable.weather_showers_scattered_day, R.drawable.weather_big_snow, R.drawable.weather_snow_rain, R.drawable.weather_big_snow, R.drawable.weather_few_clouds, R.drawable.weather_storm, R.drawable.weather_snow_rain, R.drawable.weather_storm};
    private static final int[] nightWeatherIcons = {R.drawable.weather_mist,R.drawable.weather_mist,R.drawable.weather_mist,R.drawable.weather_storm_night,R.drawable.weather_storm_night,R.drawable.weather_snow_rain,R.drawable.weather_hail,R.drawable.weather_hail,R.drawable.weather_drizzle_night,R.drawable.weather_drizzle_night,R.drawable.weather_snow_rain,R.drawable.weather_showers_night,R.drawable.weather_showers_night,R.drawable.weather_snow_scattered_night,R.drawable.weather_snow,R.drawable.weather_big_snow,R.drawable.weather_big_snow,R.drawable.weather_hail,R.drawable.weather_hail,R.drawable.weather_fog,R.drawable.weather_fog,R.drawable.weather_haze,R.drawable.weather_haze,R.drawable.weather_mist,R.drawable.weather_mist,R.drawable.weather_clear_night,R.drawable.weather_clouds_night,R.drawable.weather_clouds_night,R.drawable.weather_few_clouds,R.drawable.weather_few_clouds_night,R.drawable.weather_few_clouds,R.drawable.weather_clear_night,R.drawable.weather_clear,R.drawable.weather_clear_night,R.drawable.weather_clear,R.drawable.weather_hail,R.drawable.weather_clear,R.drawable.weather_storm_night,R.drawable.weather_storm_night,R.drawable.weather_storm_night,R.drawable.weather_storm_night,R.drawable.weather_storm_night,R.drawable.weather_snow_rain,R.drawable.weather_snow_scattered_night,R.drawable.weather_clouds_night,R.drawable.weather_storm,R.drawable.weather_snow_rain,R.drawable.weather_storm};

    /**
     * Convert the condition code to a friendly description
     * @param code Yahoo weather condition code
     * @return friendly condition string
     */
    public static String getConditionString(String code) {
        try {
            return getConditionString(Integer.parseInt(code));
        } catch(NumberFormatException e) {
            return getConditionString(-1);
        }
    }
    /**
     * Convert the condition code to a friendly description
     * @param code Yahoo weather condition code
     * @return friendly condition string
     */
    public static String getConditionString(int code) {
        if (code > 0 && code < conditions.length) {
            return conditions[code];
        }
        return "not available"; // code #32000
    }

    /**
     * Match the condition code to an image resource
     * @param code Yahoo weather condition code
     * @return image resource
     */
    public static int getWeatherResId(boolean day, String code) {
        try {
            return getWeatherResId(day, Integer.parseInt(code));
        } catch(NumberFormatException e) {
            return getWeatherResId(day, -1);
        }
    }
    /**
     * Match the condition code to an image resource
     * @param code Yahoo weather condition code
     * @return image resource
     */
    public static int getWeatherResId(boolean day, int code) {
        if (code > 0 && code < conditions.length) {
            if (day) {
                return dayWeatherIcons[code];
            } else {
                return nightWeatherIcons[code];
            }
        }

        return R.drawable.weather_none_available; // code #32000
    }
}
package com.brighamdiaz.weathery.model;

/**
 * Created by Brigham on 11/30/2016.
 */

public class ConditionCode {

    /**
     * Source: https://developer.yahoo.com/weather/documentation.html#codes
     */
    private static final String[] conditions = new String[] {"tornado","tropical storm","hurricane","severe thunderstorms","thunderstorms","mixed rain and snow","mixed rain and sleet","mixed snow and sleet","freezing drizzle","drizzle","freezing rain","showers","showers","snow flurries","light snow showers","blowing snow","snow","hail","sleet","dust","foggy","haze","smoky","blustery","windy","cold","cloudy","mostly cloudy (night)","mostly cloudy (day)","partly cloudy (night)","partly cloudy (day)","clear (night)","sunny","fair (night)","fair (day)","mixed rain and hail","hot","isolated thunderstorms","scattered thunderstorms","scattered thunderstorms","scattered showers","heavy snow","scattered snow showers","heavy snow","partly cloudy","thundershowers","snow showers","isolated thundershowers"};

    public static String getConditionString(int code) {
        if(code > 0 && code < conditions.length) {
            return conditions[code];
        }
        return "not available"; // code #32000
    }
}

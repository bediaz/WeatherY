package com.brighamdiaz.weathery.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Brigham on 11/27/2016.
 *
 * POJO for Yahoo API forecast response
 */
public class ForecastResponse {

    @SerializedName("query")
    private Forecast query;
    /**
     * @return Object containing all the weather details for location
     */
    public Forecast getWeatherResult() {
        return query;
    }

    /**
     * @param query A Forecast object
     */
    public void setQuery(Forecast query) {
        this.query = query;
    }
}

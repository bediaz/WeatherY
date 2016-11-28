package com.brighamdiaz.weathery;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import com.brighamdiaz.weathery.model.ForecastResponse;

import java.util.Map;

/**
 * Created by Brigham on 11/27/2016.
 *
 * Java interface for Yahoo HTTP call
 */
public interface WeatherAPIInterface {
    /**
     * Example encoded URL: https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys
     select * from weather.forecast where woeid in (select woeid from geo.places(1) where text="nome, ak")
     * @param url Unencoded URL containing yahoo API query
     * @return If successful, ForecastResponse should contain forecast data.
     */
    @GET("yql/")
    Call<ForecastResponse> getForecast(@QueryMap(encoded=false) Map<String, String> url);

}

package com.brighamdiaz.weathery;

import android.content.Context;

import com.brighamdiaz.weathery.model.Forecast;
import com.brighamdiaz.weathery.model.ForecastResponse;

import java.util.LinkedHashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Brigham on 11/27/2016.
 *
 * Generate an implementation of the WeatherAPIInterface
 */
public class WeatherAPIClient {
    // base URL for all requests
    public static final String YAHOO_URL = "https://query.yahooapis.com/v1/public/";
    private static Retrofit mRetrofit;
    private OnForecastReceivedListener mListener;

    /**
     * Create a new Retrofit Yahoo weather client
     * @return Yahoo weather client
     */
    public static Retrofit getClient() {
        if(mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(YAHOO_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }

    public void requestForecast(Context context) {
        if(context instanceof OnForecastReceivedListener) {
            mListener = (OnForecastReceivedListener) context;
        }
        WeatherAPIInterface apiService = WeatherAPIClient.getClient().create(WeatherAPIInterface.class);
        // insert items into a linked hash map to preserve insertion order. Do not set encoded=true
        Map<String, String> query = new LinkedHashMap<>();
        query.put("q", "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"nome, AK\")");
        query.put("format", "json");
        query.put("env", "store://datatables.org/alltableswithkeys");

        Call<ForecastResponse> call = apiService.getForecast(query);
        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                if(mListener != null) {
                    mListener.onWeatherDataReceived(response.body().getWeatherResult());
                }
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public interface OnForecastReceivedListener {
        void onWeatherDataReceived(Forecast forecast);
    }

}

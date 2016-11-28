package com.brighamdiaz.weathery;

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
}

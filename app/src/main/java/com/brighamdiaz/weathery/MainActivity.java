package com.brighamdiaz.weathery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.brighamdiaz.weathery.fragment.ForecastFragment;
import com.brighamdiaz.weathery.model.Forecast;

public class MainActivity extends AppCompatActivity implements WeatherAPIClient.OnForecastReceivedListener {
    ForecastFragment forecastFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new WeatherAPIClient().requestForecast(this);
    }

    @Override
    public void onWeatherDataReceived(Forecast forecast) {
        if(forecastFragment == null) {
            forecastFragment = ForecastFragment.newInstance(forecast);
            getSupportFragmentManager().beginTransaction().add(R.id.frame, forecastFragment).commit();
        }
    }
}
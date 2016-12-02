package com.brighamdiaz.weathery.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brighamdiaz.weathery.R;
import com.brighamdiaz.weathery.WeatherAPIClient;
import com.brighamdiaz.weathery.adapter.CurrentForecastAdapter;
import com.brighamdiaz.weathery.adapter.ForecastListAdapter;
import com.brighamdiaz.weathery.model.Forecast;

/**
 * Created by Brigham on 11/30/2016.
 */

public class ForecastFragment extends Fragment {

    private Forecast forecast;
    private RecyclerView recyclerForecastView;
    private RecyclerView recyclerCurrentView;
    private static final String ARG_FORECAST = "forecast";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ForecastFragment() {
    }

    /**
     * Factory method creates a new instance of fragment using provided forecast data.
     *
     * @param forecast initialized forecast data
     * @return a new instance of fragment to pass to transaction
     */
    public static ForecastFragment newInstance(Forecast forecast) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_FORECAST, forecast);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.forecast = (Forecast)getArguments().getSerializable(ARG_FORECAST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);

        recyclerForecastView = (RecyclerView)rootView.findViewById(R.id.forecast_recycler_view);
        recyclerForecastView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        recyclerCurrentView = (RecyclerView)rootView.findViewById(R.id.forecast_current_view);
        recyclerCurrentView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        if(forecast == null) {
            // main activity should recreate fragment with data
            new WeatherAPIClient().requestForecast(getContext());
        } else {
            // no need to request forecast again, just update the view
            recyclerCurrentView.setAdapter(new CurrentForecastAdapter(forecast, R.layout.forecast_big_card, getContext()));
            Forecast forecastClone = forecast.deepClone();
            forecastClone.getResults().getChannel().getItem().getForecast().remove(0);
            recyclerForecastView.setAdapter(new ForecastListAdapter(forecastClone, R.layout.list_item_10_day_forecast, getContext()));

        }
        return rootView;
    }
}

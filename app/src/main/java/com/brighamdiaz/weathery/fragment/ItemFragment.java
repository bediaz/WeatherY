package com.brighamdiaz.weathery.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brighamdiaz.weathery.R;
import com.brighamdiaz.weathery.adapter.ForecastDetailedAdapter;
import com.brighamdiaz.weathery.model.Forecast;
import com.brighamdiaz.weathery.model.Forecast.Results.Channel.Item.ForecastData;

/**
 * Created by Brigham on 11/27/2016.
 *
 * A fragment representing a list of Items.
 */
public class ItemFragment extends Fragment {
    private ForecastData forecastDayDetail;
    private Forecast forecast;
    private static final String ARG_POSITION = "position";
    private static final String ARG_FORECAST = "forecast";

    public ItemFragment() {
    }

    /**
     * Factory method creates a new instance of fragment using provided forecast data.
     *
     * @param forecast initialized forecast data
     * @return a new instance of fragment to pass to transaction
     */
    public static ItemFragment newInstance(int position, Forecast forecast) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        args.putSerializable(ARG_FORECAST, forecast);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item, container, false);

        Bundle args = getArguments();
        if(args != null) {
            int position = args.getInt(ARG_POSITION);
            forecast = (Forecast) args.getSerializable(ARG_FORECAST);
            forecastDayDetail = forecast.getResults().getChannel().getItem().getForecast().get(position);

            // Set the adapter for the layout
            Context context = rootView.getContext();
            final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.forecast_detail_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ForecastDetailedAdapter(forecastDayDetail, R.layout.list_item_details, getContext()));
        }
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

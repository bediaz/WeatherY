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

/**
 * Created by Brigham on 11/27/2016.
 *
 * A fragment representing a list of Items.
 */
public class DetailedItemFragment extends Fragment {
    private Forecast forecast;
    private int position;
    private static final String ARG_POSITION = "position";
    private static final String ARG_FORECAST = "forecast";

    public DetailedItemFragment() {
    }

    /**
     * Factory method creates a new instance of fragment using provided forecast data.
     *
     * @return a new instance of fragment to pass to transaction
     */
    public static DetailedItemFragment newInstance(Forecast forecast, int position) {
        DetailedItemFragment fragment = new DetailedItemFragment();
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
            this.forecast = (Forecast) args.getSerializable(ARG_FORECAST);
            this.position = args.getInt(ARG_POSITION);

            // Set the adapter for the layout
            Context context = rootView.getContext();
            final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.forecast_detail_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ForecastDetailedAdapter(forecast, position, R.layout.list_item_details, getContext()));
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

package com.brighamdiaz.weathery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brighamdiaz.weathery.model.Forecast;

import java.util.List;

/**
 * Created by Brigham on 11/29/2016.
 *
 * Forecast adapter for forecast JSON data
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private int rowNumber;
    private List<Forecast> forecast;

    public ForecastAdapter(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowNumber, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {

        public ForecastViewHolder(View itemView) {
            super(itemView);
        }
    }
}

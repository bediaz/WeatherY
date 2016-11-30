package com.brighamdiaz.weathery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brighamdiaz.weathery.model.Forecast;

import java.util.List;
import com.brighamdiaz.weathery.R;
import com.brighamdiaz.weathery.model.Forecast.Results.Channel.Item.ForecastData;

import org.w3c.dom.Text;

/**
 * Created by Brigham on 11/29/2016.
 *
 * Forecast adapter for forecast JSON data
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private int rowNumber;
    private Forecast forecast;
    private List<ForecastData> forecastData;

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView txtDayOfWeek;
        TextView txtCondition;
        TextView txtHigh;
        TextView txtLow;


        public ForecastViewHolder(View itemView) {
            super(itemView);
            txtDayOfWeek = (TextView)itemView.findViewById(R.id.txtDayOfWeek);
            txtCondition = (TextView)itemView.findViewById(R.id.txtCondition);
            txtHigh = (TextView) itemView.findViewById(R.id.txtHigh);
            txtLow   = (TextView) itemView.findViewById(R.id.txtLow);
        }
    }

    public ForecastAdapter(Forecast forecast, int rowNumber, Context context) {
        this.forecast = forecast;
        this.rowNumber = rowNumber;
        this.forecastData = forecast.getResults().getChannel().getItem().getForecast();
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowNumber, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        holder.txtDayOfWeek.setText(forecastData.get(position).getDay());
        holder.txtCondition.setText(forecastData.get(position).getText());
        holder.txtHigh.setText(forecastData.get(position).getHigh());
        holder.txtLow.setText(forecastData.get(position).getLow());
    }

    @Override
    public int getItemCount() {
        return forecastData.size();
    }
}

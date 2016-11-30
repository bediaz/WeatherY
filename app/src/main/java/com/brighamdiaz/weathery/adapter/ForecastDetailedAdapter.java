package com.brighamdiaz.weathery.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brighamdiaz.weathery.R;
import com.brighamdiaz.weathery.model.ConditionCode;
import com.brighamdiaz.weathery.model.Forecast;
import com.brighamdiaz.weathery.model.Forecast.Results.Channel.Item.ForecastData;

/**
 * Created by Brigham on 11/29/2016.
 *
 * Forecast adapter for forecast JSON data
 */
public class ForecastDetailedAdapter extends RecyclerView.Adapter<ForecastDetailedAdapter.ForecastViewHolder> {
    private int layoutId;
    private Forecast.Results.Channel.Item.ForecastData forecastData;

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView txtDate;
        TextView txtDayOfWeek;
        TextView txtCondition;
        TextView txtHigh;
        TextView txtLow;
        TextView txtConditionStr;


        public ForecastViewHolder(View itemView) {
            super(itemView);
            txtDate = (TextView)itemView.findViewById(R.id.txtDate);
            txtDayOfWeek = (TextView)itemView.findViewById(R.id.txtDayOfWeek);
            txtCondition = (TextView)itemView.findViewById(R.id.txtCondition);
            txtConditionStr= (TextView)itemView.findViewById(R.id.txtConditionStr);
            txtHigh = (TextView) itemView.findViewById(R.id.txtHigh);
            txtLow   = (TextView) itemView.findViewById(R.id.txtLow);
        }
    }

    public ForecastDetailedAdapter(ForecastData forecastData, int layoutId, Context context) {
        this.forecastData = forecastData;
        this.layoutId = layoutId;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        holder.txtDayOfWeek.setText(forecastData.getDay());
        holder.txtCondition.setText(forecastData.getText());
        holder.txtHigh.setText(forecastData.getHigh());
        holder.txtLow.setText(forecastData.getLow());
        holder.txtDate.setText(forecastData.getDate());
        holder.txtConditionStr.setText(ConditionCode.getConditionString(Integer.valueOf(forecastData.getCode())));
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}

package com.brighamdiaz.weathery.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brighamdiaz.weathery.R;
import com.brighamdiaz.weathery.fragment.ItemFragment;
import com.brighamdiaz.weathery.model.ConditionCode;
import com.brighamdiaz.weathery.model.Forecast;
import com.brighamdiaz.weathery.model.Forecast.Results.Channel.Item.ForecastData;

import java.util.List;

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
        ImageView imgWeatherIcon;


        public ForecastViewHolder(View itemView) {
            super(itemView);
            txtDayOfWeek = (TextView)itemView.findViewById(R.id.txtDayOfWeek);
            txtCondition = (TextView)itemView.findViewById(R.id.txtCondition);
            txtHigh = (TextView) itemView.findViewById(R.id.txtHigh);
            txtLow   = (TextView) itemView.findViewById(R.id.txtLow);
            imgWeatherIcon = (ImageView) itemView.findViewById(R.id.imgWeatherIcon);
        }
    }

    public ForecastAdapter(Forecast forecast, int rowNumber, Context context) {
        this.forecast = forecast;
        this.rowNumber = rowNumber;
        this.forecastData = forecast.getResults().getChannel().getItem().getForecast();
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(rowNumber, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ForecastViewHolder holder, final int position) {
        ForecastData f = forecastData.get(position);
        holder.txtDayOfWeek.setText(f.getDay());
        holder.txtCondition.setText(f.getText());
        holder.txtHigh.setText(f.getHigh());
        holder.txtLow.setText(f.getLow());
        holder.imgWeatherIcon.setImageResource(ConditionCode.getWeatherResId(true, f.getCode()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ItemFragment is expecting forecast data
                if (forecast != null) {
                    ItemFragment itemFragment = ItemFragment.newInstance(position, forecast);
                    // could use an interface listener to make MainActivity.java do fragment transaction
                    FragmentActivity activity = (FragmentActivity) holder.itemView.getContext();
                    FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame, itemFragment)
                            .addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return forecastData.size();
    }
}

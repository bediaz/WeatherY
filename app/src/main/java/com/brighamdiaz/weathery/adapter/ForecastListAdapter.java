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
import com.brighamdiaz.weathery.fragment.DetailedItemFragment;
import com.brighamdiaz.weathery.model.ConditionCode;
import com.brighamdiaz.weathery.model.Forecast;
import com.brighamdiaz.weathery.model.Forecast.Results.Channel.Item.ForecastData;

import java.util.List;

/**
 * Created by Brigham on 11/29/2016.
 *
 * Forecast adapter for forecast JSON data
 */
public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder> {
    private int resourceID;
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

    public ForecastListAdapter(Forecast forecast, int resourceID, Context context) {

        this.forecast = forecast;
        this.resourceID = resourceID;
        this.forecastData = forecast.getResults().getChannel().getItem().getForecast();
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(resourceID, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ForecastViewHolder holder, final int position) {
//
        final ForecastData f = forecastData.get(position);
        holder.txtDayOfWeek.setText(f.getDay());
        holder.txtCondition.setText(f.getText());
        holder.txtHigh.setText("High: " + f.getHigh());
        holder.txtLow.setText("Low: " + f.getLow());
        holder.imgWeatherIcon.setImageResource(ConditionCode.getWeatherResId(true, f.getCode()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DetailedItemFragment is expecting forecast data
                if (forecast != null) {
                    // position+1 to account for removed item in CurrentForecastAdapter
                    DetailedItemFragment detailedItemFragment = DetailedItemFragment.newInstance(forecast, position+1);
                    // could use an interface listener to make MainActivity.java do fragment transaction
                    FragmentActivity activity = (FragmentActivity) holder.itemView.getContext();
                    FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_list, detailedItemFragment)
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

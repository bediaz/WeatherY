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
import java.util.List;

/**
 * Created by Brigham on 12/1/2016.
 *
 * Adapter to show big card
 */

public class CurrentForecastAdapter  extends RecyclerView.Adapter<CurrentForecastAdapter.ForecastViewHolder> {
    private int rowNumber;
    private Forecast forecast;
    private Forecast.Results.Channel channel;
    private Forecast.Results.Channel.Item.Condition condition;
    private List<Forecast.Results.Channel.Item.ForecastData> forecastData;

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView txtDayOfWeek;
        TextView txtCondition;
        ImageView imgWeatherIcon;
        TextView txtCurrent;
        TextView txtCurrentDegree;
        TextView txtHigh;
        TextView txtLow;
        TextView txtChanceRain;
        TextView txtHumidity;
        TextView txtWindSpeed;


        public ForecastViewHolder(View itemView) {
            super(itemView);
            txtDayOfWeek = (TextView)itemView.findViewById(R.id.txtDayOfWeek);
            txtCondition = (TextView)itemView.findViewById(R.id.txtCondition);
            txtHigh = (TextView) itemView.findViewById(R.id.txtHigh);
            txtLow   = (TextView) itemView.findViewById(R.id.txtLow);
            imgWeatherIcon = (ImageView) itemView.findViewById(R.id.imgWeatherIcon);
            txtChanceRain = (TextView)itemView.findViewById(R.id.txtSunsetTime);
            txtHumidity = (TextView)itemView.findViewById(R.id.txtHumidity);
            txtWindSpeed = (TextView)itemView.findViewById(R.id.txtWindSpeed);
            txtCurrent = (TextView)itemView.findViewById(R.id.txtCurrent);
            txtCurrentDegree = (TextView)itemView.findViewById(R.id.txtCurrentDegree);
        }
    }

    public CurrentForecastAdapter(Forecast forecast, int rowNumber, Context context) {
        this.forecast = forecast;
        this.channel = forecast.getResults().getChannel();
        this.condition= forecast.getResults().getChannel().getItem().getCondition();
        this.rowNumber = rowNumber;
        this.forecastData = forecast.getResults().getChannel().getItem().getForecast();
    }

    @Override
    public CurrentForecastAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(rowNumber, parent, false);
        return new CurrentForecastAdapter.ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CurrentForecastAdapter.ForecastViewHolder holder, final int position) {
        Forecast.Results.Channel.Item.ForecastData f = forecastData.get(0);
        holder.txtDayOfWeek.setText(f.getDay());
        holder.txtCondition.setText(f.getText());
        holder.txtHigh.setText(f.getHigh()+"°"+channel.getUnits().getTemperature());
        holder.txtLow.setText(f.getLow()+"°"+channel.getUnits().getTemperature());
        holder.imgWeatherIcon.setImageResource(ConditionCode.getWeatherResId(true, condition.getCode()));
        holder.txtChanceRain.setText(channel.getAstronomy().getSunset());
        holder.txtHumidity.setText(channel.getAtmosphere().getHumidity());
        holder.txtWindSpeed.setText(channel.getWind().getSpeed() + " " + channel.getUnits().getSpeed());
        holder.txtCurrent.setText(condition.getTemp());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DetailedItemFragment is expecting channel data
                if (channel != null) {
                    DetailedItemFragment detailedItemFragment = DetailedItemFragment.newInstance(forecast, position);
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
        return 1;
    }
}

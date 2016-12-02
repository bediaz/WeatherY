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

import java.util.List;

/**
 * Created by Brigham on 11/29/2016.
 *
 * Forecast adapter for forecast JSON data
 */
public class ForecastDetailedAdapter extends RecyclerView.Adapter<ForecastDetailedAdapter.ForecastViewHolder> {
    private int layoutId;
    private Forecast forecast;
    private Forecast.Results.Channel channel;
    private List<Forecast.Results.Channel.Item.ForecastData> forecastData;
    private int position;

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView txtDate;
        TextView txtDayOfWeek;
        TextView txtCondition;
        TextView txtHigh;
        TextView txtLow;
        TextView txtConditionStr;
        TextView txtChill;
        TextView txtDirection;
        TextView txtSpeed;
        TextView txtHumidity;
        TextView txtPressure;
        TextView txtRising;

        TextView txtVisibility;
        TextView txtSunrise;
        TextView txtSunset;

        TextView lblWind;
        TextView lblAtmosphere;
        TextView lblAstronomy;


        public ForecastViewHolder(View itemView) {
            super(itemView);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            txtDayOfWeek = (TextView) itemView.findViewById(R.id.txtDayOfWeek);
            txtCondition = (TextView) itemView.findViewById(R.id.txtCondition);
            txtConditionStr = (TextView) itemView.findViewById(R.id.txtConditionStr);
            txtHigh = (TextView) itemView.findViewById(R.id.txtHigh);
            txtLow = (TextView) itemView.findViewById(R.id.txtLow);

            txtChill = (TextView) itemView.findViewById(R.id.txtChill);
            txtDirection = (TextView) itemView.findViewById(R.id.txtDirection);
            txtSpeed = (TextView) itemView.findViewById(R.id.txtSpeed);
            txtHumidity = (TextView) itemView.findViewById(R.id.txtHumidity);
            txtPressure = (TextView) itemView.findViewById(R.id.txtPressure);
            txtRising = (TextView) itemView.findViewById(R.id.txtRising);
            txtVisibility = (TextView) itemView.findViewById(R.id.txtVisibility);
            txtSunrise = (TextView) itemView.findViewById(R.id.txtSunrise);
            txtSunset = (TextView) itemView.findViewById(R.id.txtSunset);

            lblAtmosphere = (TextView) itemView.findViewById(R.id.lblAtmosphere);
            lblAstronomy = (TextView) itemView.findViewById(R.id.lblAstronomy);
            lblWind = (TextView) itemView.findViewById(R.id.lblWind);
        }
    }

    public ForecastDetailedAdapter(Forecast forecast, int position, int layoutId, Context context) {
        this.forecast = forecast;
        this.position = position;
        this.forecastData = forecast.getResults().getChannel().getItem().getForecast();
        this.layoutId = layoutId;
        this.channel = forecast.getResults().getChannel();
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        if (this.position == 0) { // expecting data from CurrentForecastAdapter
            holder.txtDayOfWeek.setText(forecastData.get(this.position).getDay());
            holder.txtCondition.setText(forecastData.get(this.position).getText());
            holder.txtHigh.setText("High: " + forecastData.get(this.position).getHigh());
            holder.txtLow.setText("Low: " + forecastData.get(this.position).getLow());
            holder.txtDate.setText(forecastData.get(this.position).getDate());
            holder.txtConditionStr.setText(ConditionCode.getConditionString(forecastData.get(this.position).getCode()));
            holder.txtChill.setText(channel.getWind().getChill() + "°" + channel.getUnits().getTemperature());
            holder.txtDirection.setText(channel.getWind().getDirection() + "°");
            holder.txtSpeed.setText(channel.getWind().getSpeed() + channel.getUnits().getSpeed());
            holder.txtHumidity.setText(channel.getAtmosphere().getHumidity());
            holder.txtPressure.setText(channel.getAtmosphere().getPressure());
            holder.txtRising.setText(channel.getAtmosphere().getRising());
            holder.txtVisibility.setText(channel.getAtmosphere().getVisibility() + channel.getUnits().getDistance());
            holder.txtSunrise.setText(channel.getAstronomy().getSunrise());
            holder.txtSunset.setText(channel.getAstronomy().getSunset());
        } else {// expecting data from ForecastListAdapter
            holder.txtDayOfWeek.setText(forecastData.get(this.position - 1).getDay());
            holder.txtCondition.setText(forecastData.get(this.position - 1).getText());
            holder.txtHigh.setText("High: " + forecastData.get(this.position - 1).getHigh());
            holder.txtLow.setText("Low: " + forecastData.get(this.position - 1).getLow());
            holder.txtDate.setText(forecastData.get(this.position - 1).getDate());
            holder.txtConditionStr.setText(ConditionCode.getConditionString(forecastData.get(this.position - 1).getCode()));
            // using View.VISIBILITY and View.GONE isn't having the expected effect. Blanking text for now.
            holder.lblAtmosphere.setText("");
            holder.lblAstronomy.setText("");
            holder.lblWind.setText("");
            holder.txtChill.setText("");
            holder.txtDirection.setText("");
            holder.txtSpeed.setText("");
            holder.txtHumidity.setText("");
            holder.txtPressure.setText("");
            holder.txtRising.setText("");
            holder.txtVisibility.setText("");
            holder.txtSunrise.setText("");
            holder.txtSunset.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}

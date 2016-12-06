package com.brighamdiaz.weathery;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.brighamdiaz.weathery.fragment.ForecastFragment;
import com.brighamdiaz.weathery.model.Forecast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements WeatherAPIClient.OnForecastReceivedListener {
    ForecastFragment forecastFragment;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private final int LOCATION_PERMISSION_CHECK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        requestLocationPermission();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPause() {
        super.onPause();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (forecastFragment != null && forecastFragment.isAdded()) {
            fragmentTransaction.remove(forecastFragment).commit();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestForecast();
    }
    /**
     * Copied from Google doc: https://developer.android.com/training/permissions/requesting.html
     */
    private void requestLocationPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_CHECK);
        } else {
            startLocationListener();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.updateLocation:
                requestLocationPermission();
                requestForecast();
                break;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case LOCATION_PERMISSION_CHECK: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted
                    startLocationListener();
                }
                return;
            }
        }
    }

    protected void requestForecast() {
        setTitle(WeatherAPIClient.getCity() + ", " + WeatherAPIClient.getState());
        new WeatherAPIClient().requestForecast(this);
    }



    @Override
    public void onWeatherDataReceived(Forecast forecast) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (forecastFragment != null && forecastFragment.isAdded()) {
                fragmentTransaction.remove(forecastFragment).commit();
                getSupportFragmentManager().executePendingTransactions();
            }

            forecastFragment = ForecastFragment.newInstance(forecast);

            forecastFragment = ForecastFragment.newInstance(forecast);
            getSupportFragmentManager().beginTransaction().add(R.id.frame_list, forecastFragment).commitNow();

        } catch (Exception e) {
            // trying to catch an illegal state exception
            e.printStackTrace();
        }
    }

    protected  void startLocationListener() {
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                locationListener = new LocationListener();
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if(location != null) {
                    requestForecastForNewLocation(location);
                } else {

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1, locationListener);
                }
            }
    }

    protected void stopLocationListener() {
        if (locationManager != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                locationManager.removeUpdates(locationListener);


            }
        }
    }

    protected void requestForecastForNewLocation(Location location) {
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        List<Address> addresses;
        String city = null;
        String state = null;
        try {
            addresses = gcd.getFromLocation(location.getLatitude(),
                    location.getLongitude(), 1);
            if (addresses.size() > 0)

                System.out.println(addresses.get(0).getLocality());
            city = addresses.get(0).getLocality();
            state = addresses.get(0).getAdminArea();
            Toast.makeText(
                    getBaseContext(),
                    "Location updated: " + city + ", " + state, Toast.LENGTH_SHORT).show();
            WeatherAPIClient.setCity(city);
            WeatherAPIClient.setState(state);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(city != null && state != null) {
            requestForecast();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    private class LocationListener implements android.location.LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            requestForecastForNewLocation(location);
            stopLocationListener();
        }



        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub
        }
    }
}
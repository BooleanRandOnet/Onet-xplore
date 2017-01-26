package booleancorp.onetxplore.tools;

import android.Manifest;
import android.app.AlertDialog.Builder;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import static android.content.Context.LOCATION_SERVICE;


/**
 * Created by matthieubravo on 20/01/2017.
 */

public class UserLocationManager implements LocationListener {

    //TODO Faire que ca marche = Géolocaliser l'user ? A clarifier

    private Context context;

    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;

    Location location;

    double latitude;
    double longitude;

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0;
    private static final long MIN_TIME_BW_UPDATES = 5;

    protected LocationManager locationManager;

    /**
     * Gestion de la récupération de la position de l'utilisateur
     */
    public UserLocationManager(Context context) {
        this.context = context;
        getLocation();
    }

    /**
     * Obztnir la localisation de l'utilisateur
     * @return Location, objet contenant les coordonnées de l'utilsateur
     */
    public Location getLocation() {
        try {
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);


            if (!isGPSEnabled && !isNetworkEnabled) {
                showSettingsAlert();
            } else {
                this.canGetLocation = true;
                if (isNetworkEnabled) {
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        showSettingsAlert();
                    }
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);


                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }

                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                                Log.i("Latitude",""+latitude);
                                Log.i("longitude",""+longitude);
                            }

                        }

                    }
                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    /**
     * Arreter l'actualisation du GPS
     */
    public void stopUsingGPS() {
        if (locationManager != null) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                showSettingsAlert();
                return;
            }
            locationManager.removeUpdates(UserLocationManager.this);
        }
    }

    public double getLatitude()
    {
        if(location!=null)
        {
            latitude=location.getLatitude();
        }
        Log.i("Latitude",""+latitude);
        return latitude;

    }


    public double getLongitude()
    {
        if(location!=null)
        {
            longitude=location.getLongitude();
        }
        Log.i("longitude",""+longitude);
        return longitude;

    }

    public boolean canGetLocation(){

        return this.canGetLocation;

    }

    /**
     * Demander l'activation du GPS
     */
    public void showSettingsAlert(){
        Builder alertDialog=new Builder(context);
        alertDialog.setTitle("Votre localisation");
        alertDialog.setMessage("Le GPS n'est pas activé, il est primordial pour le bon fonctionnemnt de l'application ");
        alertDialog.setPositiveButton("Paramètres", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });

        alertDialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
    }
}


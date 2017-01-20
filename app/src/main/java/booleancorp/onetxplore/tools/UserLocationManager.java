package booleancorp.onetxplore.tools;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;


/**
 * Created by matthieubravo on 20/01/2017.
 */

public class UserLocationManager implements LocationListener {

    public UserLocationManager(){
        Log.i("Location---","Latitude----------------------------------------");
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i("Location","Latitude "+location.getLatitude()+"Longitude "+location.getLongitude());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

}

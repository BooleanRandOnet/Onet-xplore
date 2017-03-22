package booleancorp.onetxplore.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.SupportMapFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import booleancorp.onetxplore.R;
import booleancorp.onetxplore.tools.UserLocationManager;
import booleancorp.onetxplore.view.map.BottomBarFragment;

/**
 * Created by jo on 26/01/17.
 */

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    ImageView missionBt;

    ImageView centerBt;

    LatLng userLocation;

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.maps_view);

        missionBt = (ImageView) findViewById(R.id.mission_bt);

        centerBt = (ImageView) findViewById(R.id.center_bt);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BottomBarFragment bottomBar = (BottomBarFragment)
                getSupportFragmentManager().findFragmentById(R.id.bottom_bar);

        centerBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
            }
        });

        missionBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Mission en cours",Toast.LENGTH_LONG).show();
                Intent missionIntent = new Intent(getApplicationContext(),MissionActivity.class);
                startActivity(missionIntent);
            }
        });



    }


    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;
        UserLocationManager localisation = new UserLocationManager(this);
        Location posCurr = localisation.getLocation();
        Bitmap innerPlacemark = resizeMapIcons("inner_placemark",25,100);
        Bitmap outerPlacemark = resizeMapIcons("outer_placemark",150,150);
        map.getUiSettings().setMapToolbarEnabled(false);
        map.getUiSettings().setCompassEnabled(false);
        map.setPadding(0,0,0,345);


        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Add a marker in Sydney, Australia, and move the camera.
        userLocation = new LatLng(localisation.getLatitude(), localisation.getLongitude());
        map.addMarker(new MarkerOptions().position(userLocation)
                .icon(BitmapDescriptorFactory.fromBitmap(innerPlacemark))
                .anchor(0.5f, 0.5f) // Anchors the marker on the bottom left
                .position(userLocation));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,18));

        // You can customize the marker image using images bundled with
        // your app, or dynamically generated bitmaps.
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromBitmap(outerPlacemark))
                .anchor(0.5f, 0.5f) // Anchors the marker on the bottom left
                .position(userLocation).flat(true));

        // Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(userLocation)      // Sets the center of the map to Mountain View
                .zoom(18)                  // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


    }

    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}

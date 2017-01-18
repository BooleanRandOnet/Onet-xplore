package booleancorp.onetxplore.view.map;

import android.app.Activity;
import android.widget.RelativeLayout;

import booleancorp.onetxplore.R;

/**
 * Created by matthieubravo on 17/01/2017.
 */

public class MapActivity extends Activity {
    //TODO Structure

    public MapActivity(){
        setContentView(R.layout.map_view);

        MapView mapView = new MapView();
    }

}

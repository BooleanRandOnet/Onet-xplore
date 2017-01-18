package booleancorp.onetxplore.view.map;

import android.os.Bundle;

import booleancorp.onetxplore.R;

/**
 * Created by matthieubravo on 17/01/2017.
 */

public class MapViewActivity extends MapActivity {
    //TODO Structure

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}

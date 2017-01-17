package booleancorp.onetxplore.Constants;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

public class Constante {

    /**taille d'écran*/
    public final int screenHeight;
    public final int screenWidth;

    public Constante(Activity actualAcivity){

        /////////////////////////////////////Taille d'écran/////////////////////////////////////////
        DisplayMetrics metrics = new DisplayMetrics();
        actualAcivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        screenHeight = metrics.heightPixels;
        screenWidth = metrics.widthPixels;
        ////////////////////////////////////////////////////////////////////////////////////////////

    }
}

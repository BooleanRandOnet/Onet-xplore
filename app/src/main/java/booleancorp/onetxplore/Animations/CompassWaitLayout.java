package booleancorp.onetxplore.Animations;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import booleancorp.onetxplore.Constants.Constante;
import booleancorp.onetxplore.R;

import static java.lang.Math.round;

/**
 * Created by matthieubravo on 18/01/2017.
 */

public class CompassWaitLayout extends RelativeLayout {

    /**Aiguille de la boussole*/
    private static ImageView compassPeak;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CompassWaitLayout(Context context){
        super(context);

        Constante constante = new Constante();

        //création de l'aspect taille de la vue
        int size = (int)round(constante.getScreenWidth()*0.55);
        LayoutParams paramsCW = new LayoutParams(size,size);
        paramsCW.addRule(CENTER_IN_PARENT);
        setLayoutParams(paramsCW);

        setBackgroundResource(R.drawable.bg_compas_wait);

        ImageView compassBG = new ImageView(context);
        LayoutParams paramsCB = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramsCB.setMargins(30,30,30,30);
        paramsCB.addRule(CENTER_IN_PARENT);
        compassBG.setLayoutParams(paramsCB);
        compassBG.setImageResource(R.drawable.compass_part1);
        addView(compassBG);

        compassPeak = new ImageView(context);
        LayoutParams paramsCP = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramsCP.setMargins(30,30,30,30);
        paramsCP.addRule(CENTER_IN_PARENT);
        compassPeak.setLayoutParams(paramsCP);
        compassPeak.setImageResource(R.drawable.compass_part2);
        compassPeak.setRotation(-40);
        addView(compassPeak);

        //animer l'entrée
        setAlpha(0);
        animate().alpha(1).setDuration(400);

        animCompass();
    }


    /**
     * Animer l'aiguille de la boussole de gauche à droite indéfiniment
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void animCompass(){
        compassPeak.animate().rotation(40).setDuration(2500).withEndAction(new Runnable() {
            @Override
            public void run() {
                compassPeak.animate().rotation(-40).setDuration(2500).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        animCompass();
                    }
                });
            }
        });
    }
}

package booleancorp.onetxplore;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.*;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import booleancorp.onetxplore.Constants.*;
import booleancorp.onetxplore.view.map.MapActivity;

public class MainActivity extends Activity {

    /**Constante*/
    private Constante constante;

    /**Element de la vue*/
    private ImageView bg;
    private TextView tvPseudo;
    private TextView tvMdp;
    private EditText etPseudo;
    private EditText mdpTV;
    private TextView tvConnexion;
    private RelativeLayout bgConn;
    private ImageButton actionBT;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //création des constante
        constante = new Constante(this);

        super.onCreate(savedInstanceState);
        // Cacher la barre du titre et de notifications
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.inscription);


        //récupérationd des éléments du XML
        bg = (ImageView) findViewById(R.id.bg);
        RelativeLayout.LayoutParams paramsBG = new RelativeLayout.LayoutParams(constante.screenWidth*3, ViewGroup.LayoutParams.MATCH_PARENT);
        paramsBG.rightMargin = -constante.screenWidth*3;
        bg.setLayoutParams(paramsBG);
        animBackground(bg);

        tvPseudo = (TextView)findViewById(R.id.tvPseudo);
        tvMdp = (TextView)findViewById(R.id.tvMdp);
        etPseudo = (EditText) findViewById(R.id.pseudoField);
        mdpTV = (EditText) findViewById(R.id.mdpField);
        tvConnexion = (TextView) findViewById(R.id.tvConnexion);
        actionBT = (ImageButton) findViewById(R.id.btnValider);
        actionBT.getBackground().setAlpha(0);
        actionBT.setTag(1);
        bgConn = (RelativeLayout) findViewById(R.id.bg_insc);

        //animation d'ouverture
        bgConn.setY(constante.screenHeight);
        bgConn.animate().translationY(0).setDuration(500).setInterpolator(new LinearOutSlowInInterpolator());

        createContent((int)actionBT.getTag());

        // Police personnalisée sur les TextView > Avenir Next
        try {
            Typeface avenirNextBold = Typeface.createFromAsset(getAssets(), "fonts/avenirnext_bold.otf");
            Typeface avenirNextItalic = Typeface.createFromAsset(getAssets(), "fonts/avenirnext_italic.otf");
            Typeface avenirNext = Typeface.createFromAsset(getAssets(), "fonts/avenirnext.otf");
            tvPseudo.setTypeface(avenirNextBold);
            tvMdp.setTypeface(avenirNextBold);
            tvConnexion.setTypeface(avenirNext);
            etPseudo.setTypeface(avenirNextItalic);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        ////////////CACHER LA BARRE DE NAVIGATION
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        decorView.setSystemUiVisibility(uiOptions);
        /////////////


    }

    /**
     * Anime une vue de droite a gauche et vice versa.
     * @param bg vue animer, a savoir le BG
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void animBackground(final ImageView bg){
        bg.animate().translationX(-constante.screenWidth*2).setDuration(15000).withEndAction(new Runnable() {
            @Override
            public void run() {
                bg.animate().translationX(0).setDuration(15000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        animBackground(bg);
                    }
                });
            }
        });
    }

    /**
     * Création du contenu
     * @param type 1 -> connexion, 0 -> inscription
     */
    public void createContent(int type){

        if(type == 1) {
            actionBT.setImageResource(R.drawable.connexion);
            actionBT.setTag(0);
            tvConnexion.setText("-Inscription-");
        } else {
            actionBT.setImageResource(R.drawable.inscription);
            actionBT.setTag(1);
            tvConnexion.setText("-Connexion-");
        }
    }

    /**
     * Capture l'évènement du lien connexion en bas de la page
     * Change le layout pour celui de connexion et non inscription
     * @param view Lien Connexion
     */
    public void clicChangeStatu(View view) {
        createContent((int)actionBT.getTag());
    }

    /**
     * Capture l'évènement du bouton de connexion/inscription
     * Procède a la connexion ou a l'inscription
     * @param view bouton de connexion/inscription
     */
    public void clicConnexion(View view) {
        Intent mapIntent = new Intent(this, MapActivity.class);
        startActivity(mapIntent);
    }
}

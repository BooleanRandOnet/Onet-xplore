package booleancorp.onetxplore.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import booleancorp.onetxplore.animations.CompassWaitLayout;
import booleancorp.onetxplore.constants.*;
import booleancorp.onetxplore.R;
import booleancorp.onetxplore.tools.UserLocationManager;
import booleancorp.onetxplore.view.map.MapsActivity;

import static java.lang.Math.round;

public class MainActivity extends Activity implements View.OnTouchListener{

    /**Constante*/
    private Constante constante;

    /**Element de la vue*/
    private ImageView bg;

    private RelativeLayout bgConn;

    private LinearLayout contentLL;

    private RelativeLayout imgLog;
    private View imgStrokeBack;
    private Button plusBt;

    private View strokeColorUp;
    private View strokeColorDown;

    private TextView tvPseudo;
    private TextView tvMdp;
    private EditText etPseudo;
    private EditText etMdp;
    private TextView tvConnexion;


    private RelativeLayout btlayout;
    private ImageButton actionBT;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //création des constantes
        constante = new Constante(this);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.inscription);


        //récupération des éléments du XML
        bg = (ImageView) findViewById(R.id.bg);
        RelativeLayout.LayoutParams paramsBG = new RelativeLayout.LayoutParams(constante.getScreenHeight()*3, ViewGroup.LayoutParams.MATCH_PARENT);
        paramsBG.rightMargin = -constante.getScreenWidth()*3;
        bg.setLayoutParams(paramsBG);
        animBackground(bg);

        //----background arrondi blanc
        bgConn = (RelativeLayout) findViewById(R.id.bg_insc);

        RelativeLayout.LayoutParams paramsBGC = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        int margin = (int)round(constante.getScreenWidth()*0.2/2);
        paramsBGC.setMargins(margin,margin,margin,-margin);
        bgConn.setLayoutParams(paramsBGC);

        //animation d'ouverture
        bgConn.setY(constante.getScreenHeight());
        bgConn.animate().translationY(0).setDuration(500).setInterpolator(new LinearOutSlowInInterpolator());
        //----

        //----layout de contenu
        contentLL = (LinearLayout) findViewById(R.id.lin_lay_content);

        RelativeLayout.LayoutParams paramsCLL = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        int marginCLL = (int)round(constante.getScreenWidth()*0.108);
        paramsCLL.setMargins(marginCLL,0,marginCLL,0);
        contentLL.setLayoutParams(paramsCLL);
        //----

        //----layout de la vue de la photo de profil

        int parentIMGLogWidth = (int)round(constante.getScreenWidth()-constante.getScreenWidth()*0.2);


        imgLog = (RelativeLayout) findViewById(R.id.img_log);

        int sizeIL = (int)round(parentIMGLogWidth*0.37);
        LinearLayout.LayoutParams paramsIL = new LinearLayout.LayoutParams(sizeIL, sizeIL);
        int marginIL = (int)round(constante.getScreenHeight()*0.078);
        paramsIL.setMargins(0,marginIL,0,0);
        imgLog.setLayoutParams(paramsIL);


        imgStrokeBack = (View) findViewById(R.id.img_stroke_back);

        int sizeISB = (int)round(parentIMGLogWidth*0.086);
        RelativeLayout.LayoutParams paramsISB = new RelativeLayout.LayoutParams(sizeISB, sizeISB);
        //margin car peut pas mettre de rule et ca écrase le XML
        int marginISB = sizeIL-sizeISB;
        paramsISB.setMargins(marginISB,marginISB,0,0);
        imgStrokeBack.setLayoutParams(paramsISB);


        plusBt = (Button) findViewById(R.id.plus_bt);

        int sizePB = sizeISB-4;
        RelativeLayout.LayoutParams paramsPB = new RelativeLayout.LayoutParams(sizePB, sizePB);
        int marginPB = (sizeIL-sizeISB)+2;
        paramsPB.setMargins(marginPB,marginPB,0,0);
        plusBt.setLayoutParams(paramsPB);


        //----

        //----vues formant les trait de délimitation

        strokeColorUp = (View) findViewById(R.id.stroke_color_up);

        int widthSCU = (int)round(parentIMGLogWidth*0.6);
        LinearLayout.LayoutParams paramsSCU = new LinearLayout.LayoutParams(widthSCU, 2);
        int marginSCU = (int) round(constante.getScreenHeight()*0.086);
        paramsSCU.setMargins(0,marginSCU,0,0);
        strokeColorUp.setLayoutParams(paramsSCU);


        strokeColorDown = (View) findViewById(R.id.stroke_color_down);

        int widthSCD = (int)round(parentIMGLogWidth*0.6);
        LinearLayout.LayoutParams paramsSCD = new LinearLayout.LayoutParams(widthSCD, 2);
        int marginSCD = (int) round(constante.getScreenHeight()*0.047);
        paramsSCD.setMargins(0,marginSCD,0,0);
        strokeColorDown.setLayoutParams(paramsSCD);

        //----

        //----vues formant le formulaire d'inscription/connexion

        int fieldViewHeight = (int) round(constante.getScreenHeight()*0.65-constante.getScreenHeight()*0.33) ;


        tvPseudo = (TextView)findViewById(R.id.tvPseudo);

        int heightPTV = (int) round(fieldViewHeight*0.109) ;
        LinearLayout.LayoutParams paramsPTV = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightPTV);
        int marginPTV = (int) round(constante.getScreenHeight()*0.034);
        paramsPTV.setMargins(0,marginPTV,0,0);
        tvPseudo.setLayoutParams(paramsPTV);


        etPseudo = (EditText) findViewById(R.id.pseudoField);

        int heightPET = (int) round(fieldViewHeight*0.168) ;
        LinearLayout.LayoutParams paramsPET = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightPET);
        int marginPET = (int) round(constante.getScreenHeight()*0.014);
        paramsPET.setMargins(0,marginPET,0,0);
        etPseudo.setLayoutParams(paramsPET);


        tvMdp = (TextView)findViewById(R.id.tvMdp);

        int heightMTV = (int) round(fieldViewHeight*0.109) ;
        LinearLayout.LayoutParams paramsMTV = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightMTV);
        int marginMTV = (int) round(constante.getScreenHeight()*0.034);
        paramsMTV.setMargins(0,marginMTV,0,0);
        tvMdp.setLayoutParams(paramsMTV);


        etMdp = (EditText) findViewById(R.id.mdpField);

        int heightMET = (int) round(fieldViewHeight*0.168) ;
        LinearLayout.LayoutParams paramsMET = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightMET);
        int marginMET = (int) round(constante.getScreenHeight()*0.014);
        paramsMET.setMargins(0,marginMET,0,0);
        etMdp.setLayoutParams(paramsMET);

        //----

        //----boutons d'intéraction

        btlayout = (RelativeLayout) findViewById(R.id.button_layout);

        int heightBL = (int) round(parentIMGLogWidth*0.538) ;
        LinearLayout.LayoutParams paramsBL = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightBL);
        int marginBL = (int) round(constante.getScreenHeight()*0.063);
        paramsBL.setMargins(0,marginBL,0,0);
        btlayout.setLayoutParams(paramsBL);


        actionBT = (ImageButton) findViewById(R.id.btnValider);

        actionBT.getBackground().setAlpha(0);
        actionBT.setTag(1);
        actionBT.setOnTouchListener(this);

        tvConnexion = (TextView) findViewById(R.id.tvConnexion);

        LinearLayout.LayoutParams paramsTC = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int marginTC = (int) round(constante.getScreenHeight()*0.028);
        paramsTC.setMargins(0,marginTC,0,0);
        btlayout.setLayoutParams(paramsTC);

        //----

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

        ////////////CACHER LA BARRE DE NAVIGATION ET DE NOTIFICATION
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
        bg.animate().translationX(-constante.getScreenWidth()*2).setDuration(10000).withEndAction(new Runnable() {
            @Override
            public void run() {
                bg.animate().translationX(0).setDuration(10000).withEndAction(new Runnable() {
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
     * @param sender bouton de connexion/inscription
     * @param motionEvent type d'évènement effectué sur le bouton
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onTouch(View sender, MotionEvent motionEvent) {

        //TEST//
        Intent mapIntent = new Intent(this, MapsActivity.class);
        startActivity(mapIntent);
        //TEST//




        final int action = motionEvent.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                float offset = sender.getWidth() * 0.011f;
                sender.animate().translationX(offset).translationY(offset).setDuration(65);
                break;
            case MotionEvent.ACTION_UP:
                sender.animate().translationX(0).translationY(0).setDuration(200);
                if (etPseudo.getText().length() > 0 && etPseudo.getText().length() > 0) {
                    //animer le chargement
                    final CompassWaitLayout compassWaitLayout = new CompassWaitLayout(getApplicationContext());
                    bgConn.addView(compassWaitLayout);

                    Log.i("Connection", "en cours...");

                    bg.animate().alpha(100).setDuration(400);
                    bgConn.animate().alpha(100).setDuration(400);

                    if ((int) sender.getTag() == 1) {
                        Log.i("Connection", "en cours...");
                        //TODO  charger les informations de la BD et après appelé l'ouverture de la vue
                        boolean connexion = false; // STUB En attendant la fonction connexion de la bd
                        if(!connexion) {
                            // TODO Matthieu : Gérer les modifications graphiques en cas de bad mp
                            etPseudo.setBackgroundResource(R.drawable.inputshape_error);
                            etMdp.setBackgroundResource(R.drawable.inputshape_error);
                            compassWaitLayout.removeFromParent();
                        } else {
                            //ouvrir la nouvelle page (simuler le temps de chargement)
                            final MainActivity that = this;
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent mapIntent = new Intent(that, MapsActivity.class);
                                    startActivity(mapIntent);
                                }
                            }, 4000);
                        }
                    } else {
                        Log.i("Inscription", "en cours...");
                        //TODO charger les informations de la BD et après appelé l'ouverture de la vue
                        boolean inscription = false; // STUB En attendant la fonction inscription de la bd
                        if(!inscription) {
                            // TODO Matthieu : Gérer les modifications graphiques en cas de bad mp
                            etPseudo.setBackgroundResource(R.drawable.inputshape_error);
                            etMdp.setBackgroundResource(R.drawable.inputshape_error);
                            compassWaitLayout.removeFromParent();
                        } else {
                            //ouvrir la nouvelle page (simuler le temps de chargement)
                            final MainActivity that = this;
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent mapIntent = new Intent(that, MapsActivity.class);
                                    startActivity(mapIntent);
                                }
                            }, 4000);
                        }
                    }
                } else {
                    etPseudo.setBackgroundResource(R.drawable.inputshape_error);
                    etMdp.setBackgroundResource(R.drawable.inputshape_error);
                }
            case MotionEvent.ACTION_CANCEL:
                sender.animate().translationX(0).translationY(0).setDuration(200);
                break;
        }
        return false;
    }
}

package booleancorp.onetxplore;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConnexionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Cacher la barre du titre et de notifications
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.connexion);

        TextView tvPseudo = (TextView)findViewById(R.id.tvPseudo);
        TextView tvMdp = (TextView)findViewById(R.id.tvMdp);
        EditText etPseudo = (EditText) findViewById(R.id.pseudoField);
        TextView tvConnexion = (TextView) findViewById(R.id.tvConnexion);

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
    }

    /**
     * Clic sur le lien connexion en bas de la page
     * Change le layout pour celui de connexion et non inscription
     * @param view Lien Connexion
     */
    public void clicConnexion(View view) {
        Toast.makeText(this, "Clic", Toast.LENGTH_LONG).show();
    }
}

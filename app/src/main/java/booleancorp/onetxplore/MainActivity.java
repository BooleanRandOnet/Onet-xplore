package booleancorp.onetxplore;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Cacher la barre du titre et de notifications
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        TextView tvPseudo = (TextView)findViewById(R.id.tvPseudo);
        TextView tvMdp = (TextView)findViewById(R.id.tvMdp);
        EditText etPseudo = (EditText) findViewById(R.id.pseudoField);
        try {
            Typeface avenirNextBold = Typeface.createFromAsset(getAssets(), "fonts/avenirnext_bold.otf");
            Typeface avenirNextItalic = Typeface.createFromAsset(getAssets(), "fonts/avenirnext_italic.otf");
            tvPseudo.setTypeface(avenirNextBold);
            tvMdp.setTypeface(avenirNextBold);
            etPseudo.setTypeface(avenirNextItalic);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}

package booleancorp.onetxplore.view.map;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import booleancorp.onetxplore.R;
import booleancorp.onetxplore.constants.Constante;
import booleancorp.onetxplore.controller.MainActivity;

/**
 * Created by jo on 26/01/17.
 */
public class BottomBarFragment extends Fragment {


    TextView backgroundTv;

    ImageView avatarIv;

    TextView levelTv;

    TextView arrowTv;

    Constante constante;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_bar_view, container, false);

        constante = new Constante(this.getActivity());

  /*      backgroundTv = (TextView) view.findViewById(R.id.background_tv);
        backgroundTv.setHeight((int)(view.getHeight() * 0.534));

        avatarIv = (ImageView) view.findViewById(R.id.avatar_iv);
        avatarIv.setMaxHeight((int)(constante.getScreenHeight()*0.095));
        avatarIv.setPadding((int)(constante.getScreenWidth()*0.026),0,0,0); */

        return view;
    }
}

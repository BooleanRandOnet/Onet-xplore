package booleancorp.onetxplore.view.map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import booleancorp.onetxplore.R;

/**
 * Created by jo on 26/01/17.
 */
public class BottomBarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_bar_view, container, false);

        return view;
    }
}

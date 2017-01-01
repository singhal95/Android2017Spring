package in.championswimmer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by championswimmer on 01/01/17.
 */

public class BlueFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView  = inflater.inflate(R.layout.fragment_blue, container, false);

        Button btn = (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // call showToast() function
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).showToast();
                }



            }
        });

        return rootView;
    }
}

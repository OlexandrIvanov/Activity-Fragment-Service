package com.example.saa.task4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class UpperFragmentTwo extends Fragment {

    Fragment frgm1;
    Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.upperfragmenttwo, null);

        btn = (Button) v.findViewById(R.id.buttonFG2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frgm1 = new UpperFragmentOne();
                getFragmentManager().beginTransaction().replace(R.id.Frame1, frgm1).commit();
                onDestroy();
            }
        });

        return v;
    }
}

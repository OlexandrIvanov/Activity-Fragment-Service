package com.example.saa.task4;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class UpperFragmentOne extends Fragment {

    Fragment frgm2;
    Button btn;
    TextView textView;


//    String a ;
//
//    public void setTextView(String a) {
//        this.a = a;
//        textView.setText(this.a);
//    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.upperfragmentone, null);

        textView =(TextView)v.findViewById(R.id.textView1);

        Intent intent = getActivity().getIntent();
        textView.setText(intent.getStringExtra("login"));

        btn = (Button) v.findViewById(R.id.buttonFG1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              frgm2 = new UpperFragmentTwo();
                getFragmentManager().beginTransaction().replace(R.id.Frame1, frgm2).commit();
                onDestroy();
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}

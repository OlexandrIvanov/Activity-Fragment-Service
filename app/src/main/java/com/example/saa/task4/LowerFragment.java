package com.example.saa.task4;




import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LowerFragment extends Fragment {

   private Button btnstart;
   private Button btnstop;
   private Button btntime;
   private Button btnexit;

    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lowerfragment, null);


        btnstart = (Button) v.findViewById(R.id.button6);
        btnstop = (Button) v.findViewById(R.id.button7);
        btntime = (Button) v.findViewById(R.id.button8);
        btnexit = (Button) v.findViewById(R.id.button9);



        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new Dialog1();
                dialogFragment.show(getFragmentManager(), "dlg");

            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new Dialog2();
                dialogFragment.show(getFragmentManager(), "dlg2");
            }
        });
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new Dialog3();
                dialogFragment.show(getFragmentManager(), "dlg3");
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new Dialog4();
                dialogFragment.show(getFragmentManager(), "dlg4");
            }
        });

        return v;
    }


   void ServiceOn(){
        btnstart.setEnabled(false);
        btnstop.setEnabled(true);
        btntime.setEnabled(true);

   }

   void ServiceOff(){
       btnstart.setEnabled(true);
       btnstop.setEnabled(false);
       btntime.setEnabled(false);

   }


}




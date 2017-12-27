package com.example.saa.task4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;




public class Dialog2 extends DialogFragment implements DialogInterface.OnClickListener {


     public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
            .setTitle("Are you sure?")
            .setPositiveButton(R.string.yes,this)
            .setNegativeButton(R.string.no,this);

             return adb.create();
        }
     @Override
     public void onClick(DialogInterface dialog, int which) {

          switch (which){
          case Dialog.BUTTON_POSITIVE:
          ((MainActivity)getActivity()).serviceOFF();
          }
     }

}
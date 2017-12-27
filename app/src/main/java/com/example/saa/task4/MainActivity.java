package com.example.saa.task4;

import android.app.ActivityManager;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private final   String serviceName = "com.example.saa.task4.MyService";

    private   UpperFragmentOne frgm1;
    private   LowerFragment frgm3;

    Intent intent;

    MyService.LocalBinder binder;

    MyService myService;

    Fragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frgm1 = new UpperFragmentOne();
        frgm3 = new LowerFragment();
        getFragmentManager().beginTransaction().replace(R.id.Frame1,frgm1).commit();
        getFragmentManager().beginTransaction().replace(R.id.Frame2,frgm3).commit();

//        Intent intent = getIntent();
//        login = intent.getStringExtra("login");

    }

    @Override
    protected void onStart() {
        super.onStart();
//        Fragment fragment = getFragmentManager().findFragmentById(R.id.Frame1);
//        if(fragment instanceof UpperFragmentOne){
//            ((UpperFragmentOne) fragment).setTextView(login);
//        }

        fragment2 = getFragmentManager().findFragmentById(R.id.Frame2);
        if (ifServiceOn()) {
            ((LowerFragment) fragment2).ServiceOn();
        } else ((LowerFragment) fragment2).ServiceOff();


        intent = new Intent(this,MyService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

    }

    void serviceOn (){
            startService(intent);

        fragment2 = getFragmentManager().findFragmentById(R.id.Frame2);
            ((LowerFragment) fragment2).ServiceOn();

    }

    void serviceOFF (){
        stopService(intent);
//        unbindService(mConnection);
        fragment2 = getFragmentManager().findFragmentById(R.id.Frame2);
        ((LowerFragment) fragment2).ServiceOff();

    }

    boolean  ifServiceOn(){
        ActivityManager activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo serviceInfo: activityManager.getRunningServices(Integer.MAX_VALUE)){
            if (serviceName.equals(serviceInfo.service.getClassName())){
                return true;
            }
        }
        return false;
    }



    public  void getServiceWorkTime (){
        long totaltime;

        int min;
        int seconds;

               totaltime = System.currentTimeMillis() - myService.getStarttime();

                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(totaltime);

                min = cal.get(Calendar.MINUTE);
                seconds = cal.get(Calendar.SECOND);
                Toast.makeText(this, "Service worked "+min+" minutes and "+seconds+" seconds"
                        , Toast.LENGTH_SHORT).show();

        Log.d("Log"," "+myService.getStarttime());
    }


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            Log.d("Log","Connection is ON");
            binder = (MyService.LocalBinder) iBinder;
            myService = binder.getService();

//            myService.background();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("Log","Connection is OFF");

        }
    };

}

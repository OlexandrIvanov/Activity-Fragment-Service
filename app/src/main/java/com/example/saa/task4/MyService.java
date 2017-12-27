package com.example.saa.task4;



import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class MyService extends Service {

    private final IBinder mBinder = new LocalBinder();

     long starttime;

    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    public long getStarttime(){
        return starttime;
    }


    @Override
    public void onCreate() {

        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        starttime = System.currentTimeMillis();

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
                .setContentTitle("Service On")
                .setTicker("Service On");
              startForeground(8,notification.build());

        return START_STICKY;

    }

    @Override
    public void onDestroy() {


        super.onDestroy();
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {


        super.onTaskRemoved(rootIntent);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {



        return mBinder;
    }

    public void background() {
        stopForeground(true);
    }
}

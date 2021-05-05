package com.example.learning.services;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import androidx.annotation.Nullable;

public class IntentServiceDemo extends android.app.IntentService {

    private static final String TAG = "dh_"+IntentServiceDemo.class.getSimpleName();

    public IntentServiceDemo() {
        super("Intent Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent == null) return;

        ResultReceiver resultReceiver = intent.getParcelableExtra("result_receiver");

        int delaySeconds = intent.getIntExtra("delay_seconds",1);
        int count = 1;
        while(count <= delaySeconds){
            Log.i(TAG,"Counter is now " + count);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            count++;
        }

        Bundle bundle = new Bundle();
        bundle.putString("result","Counter finished");
        resultReceiver.send(100,bundle);
    }

    @Override
    public void onCreate() {
        Log.i(TAG," OnCreate thread name: "+ Thread.currentThread().getName());
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG," OnDestroy thread name: "+ Thread.currentThread().getName());
        super.onDestroy();
    }
}

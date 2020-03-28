package com.example.learning.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.learning.R;

public class ServicesActivity extends AppCompatActivity {

    private TextView startedServiceResult;
    private TextView intentServiceResult;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startedServiceResult = findViewById(R.id.start_service_result);
        intentServiceResult = findViewById(R.id.intent_service_result);

    }

    public void startStartedService(View view){
        Intent intent  = new Intent(this, StartedService.class);
        intent.putExtra("delay_seconds",10);
        startService(intent);
    }

    public void stopStartedService(View view){
        Intent intent = new Intent(this, StartedService.class);
        stopService(intent);
    }

    public void startIntentService(View view){
        ResultReceiverDemo resultReceiverDemo = new ResultReceiverDemo(null);

        Intent intent = new Intent(this, IntentServiceDemo.class);
        intent.putExtra("delay_seconds",10);
        intent.putExtra("result_receiver", resultReceiverDemo); // ResultReceiver implements Parcelable, so can be passed in an intent
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.to.service");
        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String result = intent.getStringExtra("start_service_result");
            startedServiceResult.setText(result);
        }
    };

    //For receiving the result of the intent service
    private class ResultReceiverDemo extends ResultReceiver{

        public ResultReceiverDemo(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) { //Runs in worker thread
            super.onReceiveResult(resultCode, resultData);
            Log.i("dh_OnReceiveResult","OnReceiveResult on " + Thread.currentThread().getName());
            if(resultCode == 100 && resultData != null){
                final String result = resultData.getString("result");
                //intentServiceResult.setText(result);  -> It would be nice to do this, but we can't access the View directly from worker threads
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("dh_OnReceiveResult_handler","OnReceiveResult Handler on " + Thread.currentThread().getName());
                        intentServiceResult.setText(result);
                    }
                });
            }
        }
    }
}

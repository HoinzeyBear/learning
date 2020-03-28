package com.example.learning.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class StartedService extends Service {

    private static final String tag_started_service ="dh_started_service";
    private static final String tag_started_service_async ="dh_started_service_async";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(tag_started_service,"OnStartCommand " + Thread.currentThread().getName());
        int delaySeconds = intent.getIntExtra("delay_seconds",1);
        new MyAsyncTask().execute(delaySeconds);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        Log.i(tag_started_service,"OnCreate " + Thread.currentThread().getName());
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(tag_started_service,"OnBind " + Thread.currentThread().getName());
        return null;
    }

    @Override
    public boolean stopService(Intent name) {
        Log.i(tag_started_service,"StopService " + Thread.currentThread().getName());
        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        Log.i(tag_started_service,"OnDestroy " + Thread.currentThread().getName());
        super.onDestroy();
    }

    class MyAsyncTask extends android.os.AsyncTask<Integer, String, String> {

        @Override
        protected String doInBackground(Integer... voids) {
            //This is the only method that works in the Background/Worker thread.
            // The rest all work on the UI thread
            Log.i(tag_started_service_async,"DoInBackground " + Thread.currentThread().getName());
            int delaySeconds = voids[0];
            int count = 1;
            while(count <= delaySeconds){
                publishProgress("Counter is now " + count);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
            }
            return "Counter Finished";
        }

        @Override
        protected void onPreExecute() {
            Log.i(tag_started_service,"OnPreExecute " + Thread.currentThread().getName());
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            Log.i(tag_started_service,"OnProgressUpdate " + Thread.currentThread().getName());
            Toast.makeText(StartedService.this, values[0], Toast.LENGTH_SHORT).show();
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            Log.i(tag_started_service,"OnPostExecute " + Thread.currentThread().getName());
            super.onPostExecute(result);
            stopSelf();

            Intent intent = new Intent("action.to.service");
            intent.putExtra("start_service_result", result);
            sendBroadcast(intent);
        }
    }
}

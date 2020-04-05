package com.example.learning.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.learning.R;

public class BoundServiceActivity extends AppCompatActivity {

    private EditText leftInput;
    private EditText rightInput;
    private TextView result;

    boolean isBound = false;
    private BoundServiceDemo boundService;

    private ServiceConnection boundConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundServiceDemo.BinderDemo binder = (BoundServiceDemo.BinderDemo) service;
            boundService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);
        leftInput = findViewById(R.id.textView);
        rightInput = findViewById(R.id.textView2);
        result = findViewById(R.id.resulttext);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = new Intent(this, BoundServiceDemo.class);
        bindService(intent,boundConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBound){
            unbindService(boundConnection);
            isBound = false;
        }
    }

    public void onClickEvent(View view){
        if(isBound == false){
            return;
        }
        leftInput = findViewById(R.id.textView);
        rightInput = findViewById(R.id.textView2);
        result = findViewById(R.id.resulttext);

        int leftInputInt = Integer.valueOf(leftInput.getText().toString());
        int rightInputInt = Integer.valueOf(rightInput.getText().toString());

        final int functionResult;


        switch (view.getId()){
            case R.id.addbutton:
                functionResult = boundService.add(leftInputInt, rightInputInt);
                break;
            case R.id.subtractbutton:
                functionResult = boundService.subtract(leftInputInt,rightInputInt);
                break;
            case R.id.multiplybutton:
                functionResult = boundService.multiply(leftInputInt, rightInputInt);
                break;
            case R.id.divisionbutton:
                functionResult = boundService.divide(leftInputInt,rightInputInt);
                break;
            default:
                functionResult = 0;
        }

        result.setText(String.valueOf(functionResult));
    }
}

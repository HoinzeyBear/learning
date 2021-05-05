package com.example.learning.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class BoundServiceDemo extends Service {

    private BinderDemo binder = new BinderDemo();

    public class BinderDemo extends Binder{

        BoundServiceDemo getService(){
            return BoundServiceDemo.this;
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        return  Math.abs(a / b);
    }
}

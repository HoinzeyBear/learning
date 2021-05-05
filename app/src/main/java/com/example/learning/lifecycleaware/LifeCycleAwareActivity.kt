package com.example.learning.lifecycleaware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.learning.R

class LifeCycleAwareActivity : AppCompatActivity() {

    var lifecycleComponent: LifeCycleAwareComponent = LifeCycleAwareComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_aware)

        lifecycle.addObserver(lifecycleComponent)

        Log.d(LifeCycleAwareComponent.TAG, "Activity onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LifeCycleAwareComponent.TAG, "Activity onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LifeCycleAwareComponent.TAG, "Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LifeCycleAwareComponent.TAG, "Activity onDestroy")
    }
}

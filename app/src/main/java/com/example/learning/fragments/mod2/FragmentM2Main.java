package com.example.learning.fragments.mod2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.example.learning.R;

public class FragmentM2Main extends AppCompatActivity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_m2_main);
        manager = getSupportFragmentManager();
    }

    public void addFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();

        manager.beginTransaction()
                .add(R.id.fragment_container,fragmentA, "fragA")
                .commit();
    }

    public void removeFragmentA(View view) {
        Fragment fragA = manager.findFragmentByTag("fragA");
        if(fragA != null) {
            manager.beginTransaction()
                    .remove(fragA)
                    .commit();
        }
    }

    public void addFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();
        manager.beginTransaction()
                .add(R.id.fragment_container,fragmentB, "fragB")
                .commit();
    }

    public void removeFragmentB(View view) {
        Fragment fragB = manager.findFragmentByTag("fragB");
        if(fragB != null) {
            manager.beginTransaction()
                    .remove(fragB)
                    .commit();
        }
    }

    public void replaceWithA(View view){
        FragmentA fragmentA = new FragmentA();
        manager.beginTransaction()
                .replace(R.id.fragment_container, fragmentA,"fragA")
                .commit();
    }

    public void replaceWithB(View view){
        FragmentB fragmentB = new FragmentB();
        manager.beginTransaction()
                .replace(R.id.fragment_container, fragmentB,"fragB")
                .commit();
    }

    public void attatchA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        if(fragmentA == null) {
            fragmentA = new FragmentA();
        }
        manager.beginTransaction()
                .attach(fragmentA)
                .commit();
    }

    public void detatchA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");

        if(fragmentA == null) return;

        manager.beginTransaction()
                .detach(fragmentA)
                .commit();
    }

    public void showA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");

        if(fragmentA == null) return;

        manager.beginTransaction()
                .show(fragmentA)
                .commit();
    }

    public void hideA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");

        if(fragmentA == null) return;

        manager.beginTransaction()
                .hide(fragmentA)
                .commit();
    }

}

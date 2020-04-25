package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.learning.fragments.mod1.FragmentM1Main;
import com.example.learning.fragments.mod2.FragmentM2Main;
import com.example.learning.grid_layout.ExploreActivity;
import com.example.learning.paged_list_adapter.roomdb.PagedListActivity;
import com.example.learning.recyclerview.RecyclerActivity;
import com.example.learning.recyclerview_2.Recycler2MainActivity;
import com.example.learning.services.BoundServiceActivity;
import com.example.learning.services.ServicesActivity;
import com.example.learning.viewpager2.ViewPagerMainActivity;

public class rootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
    }

    public void goToViewPager2(View view) {
        Intent intent = new Intent(this, ViewPagerMainActivity.class);
        startActivity(intent);
    }

    public void goToServicesActivity(View view) {
        Intent intent = new Intent(this, ServicesActivity.class);
        startActivity(intent);
    }

    public void goToBoundServiceActivity(View view) {
        Intent intent = new Intent(this, BoundServiceActivity.class);
        startActivity(intent);
    }

    public void goToRecyclerView(View view) {
        Intent intent = new Intent(this, RecyclerActivity.class);
        startActivity(intent);
    }

    public void goToRecyclerViewTwo(View view) {
        Intent intent = new Intent(this, Recycler2MainActivity.class);
        startActivity(intent);
    }

    public void goToPagedlist(View view) {
        Intent intent = new Intent(this, PagedListActivity.class);
        startActivity(intent);
    }

    public void goToGridView(View view) {
        Intent intent = new Intent(this, ExploreActivity.class);
        startActivity(intent);
    }

    public void goToFragmentOne(View view) {
        Intent intent = new Intent(this, FragmentM1Main.class);
        startActivity(intent);
    }

    public void goToFragmentTwo(View view) {
        Intent intent = new Intent(this, FragmentM2Main.class);
        startActivity(intent);
    }
}

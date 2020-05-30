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
import com.example.learning.lifecycleaware.LifeCycleAwareActivity;
import com.example.learning.paged_list_adapter.roomdb.PagedListActivity;
import com.example.learning.recyclerview.RecyclerActivity;
import com.example.learning.recyclerview_2.Recycler2MainActivity;
import com.example.learning.services.BoundServiceActivity;
import com.example.learning.services.ServicesActivity;
import com.example.learning.threads.AsyncTaskActivity;
import com.example.learning.threads.HandlerThreadActivity;
import com.example.learning.threads.ThreadLooperHandlerActivity;
import com.example.learning.viewmodel.BasicViewModelActivity;
import com.example.learning.viewmodel.ViewModelLiveDataActivity;
import com.example.learning.viewpager2.ViewPagerMainActivity;

public class rootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
    }

    public void goToLiveDataViewModel(View view) {
        Intent intent = new Intent(this, ViewModelLiveDataActivity.class);
        startActivity(intent);
    }

    public void goToBasicViewModel(View view) {
        Intent intent = new Intent(this, BasicViewModelActivity.class);
        startActivity(intent);
    }

    public void goToLifecycleAwareActivity(View view) {
        Intent intent = new Intent(this, LifeCycleAwareActivity.class);
        startActivity(intent);
    }

    public void goToAsyncTaskActivity(View view) {
        Intent intent = new Intent(this, AsyncTaskActivity.class);
        startActivity(intent);
    }

    public void goToTLHActivity(View view) {
        Intent intent = new Intent(this, ThreadLooperHandlerActivity.class);
        startActivity(intent);
    }

    public void goToHTActivity(View view) {
        Intent intent = new Intent(this, HandlerThreadActivity.class);
        startActivity(intent);
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

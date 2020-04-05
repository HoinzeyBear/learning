package com.example.learning.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
//import com.google.android.material.appbar.AppBarLayout;

import com.example.learning.R;

import java.util.List;

import com.example.learning.recyclerview.model.NoteInfo;
import com.example.learning.recyclerview.model.NoteRecyclerAdapter;

public class RecyclerActivity extends AppCompatActivity {

    NoteRecyclerAdapter noteRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(NoteListActivity.this, NoteActivity.class));
//            }
//        });

        initializeDisplayContent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteRecyclerAdapter.notifyDataSetChanged();
    }

    private void initializeDisplayContent() {
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        final LinearLayoutManager noteLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(noteLayoutManager);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        noteRecyclerAdapter = new NoteRecyclerAdapter(this, notes);
        recyclerView.setAdapter(noteRecyclerAdapter);
    }
}

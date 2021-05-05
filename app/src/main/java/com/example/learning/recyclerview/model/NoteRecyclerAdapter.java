package com.example.learning.recyclerview.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.R;

import java.util.List;

import com.example.learning.recyclerview.NoteActivity;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>{

    private final Context context;
    private final List<NoteInfo> notesList;
    LayoutInflater layoutInflater;

    public NoteRecyclerAdapter(Context context, List<NoteInfo> notesList) {
        this.context = context;
         layoutInflater = LayoutInflater.from(context);
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_note_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NoteInfo noteInfo = notesList.get(position);
        holder.courseTextView.setText(noteInfo.getCourse().getTitle());
        holder.titleTextView.setText(noteInfo.getTitle());
        holder.currentPosition = position;
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView courseTextView;
        public TextView titleTextView;
        public int currentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             courseTextView = itemView.findViewById(R.id.text_course);
             titleTextView = itemView.findViewById(R.id.text_title);

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(context, NoteActivity.class);
                     intent.putExtra(NoteActivity.NOTE_POSITION,currentPosition);
                     context.startActivity(intent);
                 }
             });
        }


    }
}

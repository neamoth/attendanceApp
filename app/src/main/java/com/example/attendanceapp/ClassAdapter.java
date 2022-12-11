package com.example.attendanceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {
    ArrayList<ClassItem> classItems;
    Context context;
    private onItemClickListener onItemClickListener;
    public interface  onItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(ClassAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ClassAdapter(Context context, ArrayList<ClassItem> classItems) {
        this.classItems = classItems;
        this.context = context;
    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder{
        TextView courseCode;
        TextView courseSection;

        public ClassViewHolder(@NonNull View itemView, onItemClickListener onItemClickListener) {
            super(itemView);
            courseCode = itemView.findViewById(R.id.courseTv);
            courseSection = itemView.findViewById(R.id.sectionTv);
            itemView.setOnClickListener(v->onItemClickListener.onClick(getAdapterPosition()));
        }
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        return new ClassViewHolder(itemView,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        holder.courseCode.setText(classItems.get(position).getCourseCode());
        holder.courseSection.setText(classItems.get(position).getCourseSection());


    }

    @Override
    public int getItemCount() {
        return classItems.size();
    }
}

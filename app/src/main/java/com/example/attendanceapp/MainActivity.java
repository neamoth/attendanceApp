package com.example.attendanceapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnFloat;
    RecyclerView recyclerView;
    ClassAdapter classAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ClassItem> classItems = new ArrayList<>();

    EditText courseCode;
    EditText courseSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFloat = findViewById(R.id.btnFloat);
        btnFloat.setOnClickListener(v -> showDialog());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        classAdapter = new ClassAdapter(this, classItems);
        recyclerView.setAdapter(classAdapter);
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        courseCode = view.findViewById(R.id.edt01);
        courseSection = view.findViewById(R.id.edt02);

        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnAdd = view.findViewById(R.id.btnAdd);

        btnCancel.setOnClickListener(v -> dialog.dismiss());
        btnAdd.setOnClickListener(v -> {
            addClass();
            dialog.dismiss();
        });

    }

    private void addClass() {
        String CourseCode = courseCode.getText().toString();
        String CourseSection = courseSection.getText().toString();
        classItems.add(new ClassItem(CourseCode, CourseSection));
        classAdapter.notifyDataSetChanged();
    }
}
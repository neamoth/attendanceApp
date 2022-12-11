package com.example.attendanceapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {
    public static final String CLASS_ADD_DIALOG ="addClass";
    public static final String STUDENT_ADD_DIALOG ="addStudent";

    private onClickListener listener;
    public interface onClickListener {

        void onClick(String text1, String text2);
    }

    public void setListener(onClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = null;
        if(getTag().equals(CLASS_ADD_DIALOG))dialog=getAddClassDialog();
        if(getTag().equals(STUDENT_ADD_DIALOG))dialog=getAddStudentDialog();
        return dialog;
    }

    private Dialog getAddStudentDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);

        TextView title = view.findViewById(R.id.titleDialog);
        title.setText("Add New Student");
        EditText id_edt = view.findViewById(R.id.edt01);
        EditText name_edt = view.findViewById(R.id.edt02);

        id_edt.setHint("ID");
        name_edt.setHint("Name");

        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnAdd = view.findViewById(R.id.btnAdd);

        btnCancel.setOnClickListener(v -> dismiss());
        btnAdd.setOnClickListener(v -> {
            String id = id_edt.getText().toString();
            String name = name_edt.getText().toString();
            id_edt.setText(String.valueOf(Integer.parseInt(id)+1));
            name_edt.setText("");
            listener.onClick(id,name);
        });
        return builder.create();
    }

    private Dialog getAddClassDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);

        TextView title = view.findViewById(R.id.titleDialog);
        title.setText("Add New Class");
        EditText courseCode = view.findViewById(R.id.edt01);
        EditText courseSection = view.findViewById(R.id.edt02);

        courseCode.setHint("Course Code");
        courseSection.setHint("Course Section");

        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnAdd = view.findViewById(R.id.btnAdd);

        btnCancel.setOnClickListener(v -> dismiss());
        btnAdd.setOnClickListener(v -> {
            String courseName = courseCode.getText().toString();
            String sectionName = courseSection.getText().toString();
            listener.onClick(courseName,sectionName);
            dismiss();
        });
        return builder.create();
    }
}

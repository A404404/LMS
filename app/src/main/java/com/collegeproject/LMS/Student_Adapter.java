package com.collegeproject.LMS;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Student_Adapter extends ArrayAdapter<Student_arraylist> {

    public Student_Adapter(Activity context,ArrayList<Student_arraylist> Student_arraylist){
        super(context,0,Student_arraylist);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.student_listview,parent,false);
        }

        Student_arraylist currentstudent = getItem(position);

        TextView Name = listItemView.findViewById(R.id.Name);

        Name.setText(currentstudent.getName());

        TextView DOB = listItemView.findViewById(R.id.DOB);

        DOB.setText(currentstudent.getAge());

        TextView Gender = listItemView.findViewById(R.id.gender);

        Gender.setText(currentstudent.getGender());

        TextView Phone = listItemView.findViewById(R.id.number);

        Phone.setText(currentstudent.getNumber());

        TextView address = listItemView.findViewById(R.id.address);

        address.setText(currentstudent.getBooks());


        return listItemView;
    }
}

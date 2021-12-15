package com.collegeproject.LMS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.collegeproject.LMS.data.LibraryDbHelper;
import com.collegeproject.LMS.data.LibraryContract.Lib_student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Students_Activity extends AppCompatActivity {

    ArrayList<Student_arraylist> arraylists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students);

        arraylists = new ArrayList<>();

        FloatingActionButton fab = findViewById(R.id.Add_New_Student);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Students_Activity.this,Add_students.class);
                startActivity(intent);
            }
        });

        displayDataBaseinfo();
    }




    public void displayDataBaseinfo(){

        LibraryDbHelper mDbHelper = new LibraryDbHelper(this);

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                     Lib_student._ID,
                     Lib_student.COLUMN_STUDENT_NAME,
                     Lib_student.COLUMN_STUDENT_EMAIL,
                    Lib_student.COLUMN_STUDENT_AGE,
                    Lib_student.COLUMN_STUDENT_GENDER,
                    Lib_student.COLUMN_STUDENT_NUMBER,
                    Lib_student.COLUMN_STUDENT_ADDRESS,
                    Lib_student.COLUMN_STUDENT_BOOKS
        };

        Cursor cursor = db.query(
                Lib_student.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );


        try {
            int idColumnIndex = cursor.getColumnIndex(Lib_student._ID);
            int nameColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_NAME);
            int emailColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_EMAIL);
            int ageColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_AGE);
            int genderColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_GENDER);
            int numberColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_NUMBER);
            int addressColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_ADDRESS);
            int booksColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_BOOKS);


        while (cursor.moveToNext()){

            int currentId = cursor.getInt(idColumnIndex);
            String currentName = cursor.getString(nameColumnIndex);
            String currentemail = cursor.getString(emailColumnIndex);
            String currentage = cursor.getString(ageColumnIndex);
            String currentgender = cursor.getString(genderColumnIndex);
            String currentnumber = cursor.getString(numberColumnIndex);
            String currentaddress = cursor.getString(addressColumnIndex);
            String currentbooks = cursor.getString(booksColumnIndex);

            arraylists.add(new Student_arraylist(currentId,currentName,currentemail,currentage,
                    currentgender,currentnumber,currentaddress,currentbooks));
        }

            Student_Adapter itemsAdapter = new Student_Adapter(this,arraylists);

            ListView listView = findViewById(R.id.list);

            listView.setAdapter(itemsAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  Intent intent = new Intent(Students_Activity.this,Individual_student.class);
                  int yourInt = 10;
                  intent.putExtra("yourIntName", i);
                  startActivity(intent);
                }
            });



    }finally {
        cursor.close();
    }

    }
}
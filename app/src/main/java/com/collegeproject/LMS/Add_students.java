package com.collegeproject.LMS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.collegeproject.LMS.data.LibraryContract.Lib_student;
import com.collegeproject.LMS.data.LibraryDbHelper;

public class Add_students extends AppCompatActivity {

    EditText mName;
    EditText mEmail;
    EditText mAge;
    EditText mGender;
    EditText mNumber;
    EditText mAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_students);

        Button add_book = findViewById(R.id.Add_Student);

        mName = findViewById(R.id.Name_book);
        mEmail = findViewById(R.id.email);
        mAge = findViewById(R.id.Age);
        mGender = findViewById(R.id.Gender);
        mNumber = findViewById(R.id.Phone_number);
        mAddress = findViewById(R.id.Address);

        add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Insert();
            }
        });

    }

    public void Insert(){

        LibraryDbHelper mDbHelper = new LibraryDbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Lib_student.COLUMN_STUDENT_NAME,  mName.getText().toString().trim());
        values.put(Lib_student.COLUMN_STUDENT_EMAIL, mEmail.getText().toString().trim());
        values.put(Lib_student.COLUMN_STUDENT_AGE, mAge.getText().toString().trim());
        values.put(Lib_student.COLUMN_STUDENT_GENDER, mGender.getText().toString().trim());
        values.put(Lib_student.COLUMN_STUDENT_NUMBER, mNumber.getText().toString().trim());
        values.put(Lib_student.COLUMN_STUDENT_ADDRESS, mAddress.getText().toString().trim());

        long newRowId = db.insert(Lib_student.TABLE_NAME, null, values);

        finish();
    }
}
package com.collegeproject.LMS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.collegeproject.LMS.data.LibraryDbHelper;

import com.collegeproject.LMS.data.LibraryContract.Lib_books;

public class Add_book extends AppCompatActivity {

    EditText mNameEditText;
    EditText mAuthor;
    EditText mPrice;
    EditText mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book);

        Button add_book = findViewById(R.id.Add_Student);

         mNameEditText = findViewById(R.id.Name_book);
         mAuthor = findViewById(R.id.Author_book);
         mPrice = findViewById(R.id.Price_book);
         mStatus = findViewById(R.id.Address);

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

        values.put(Lib_books.COLUMN_BOOK_NAME,  mNameEditText.getText().toString().trim());
        values.put(Lib_books.COLUMN_BOOK_AUTHOR, mAuthor.getText().toString().trim());
        values.put(Lib_books.COLUMN_BOOK_PRICE, mPrice.getText().toString().trim());
        values.put(Lib_books.COLUMN_BOOK_STATUS, mStatus.getText().toString().trim());

        long newRowId = db.insert(Lib_books.TABLE_NAME, null, values);

        finish();
    }
}
package com.collegeproject.LMS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.collegeproject.LMS.data.LibraryDbHelper;
import com.collegeproject.LMS.data.LibraryContract.Lib_books;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class All_books_activity extends AppCompatActivity {

     ArrayList<Book_arraylist> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_books);


        arrayList = new ArrayList<>();


        FloatingActionButton fab = findViewById(R.id.Add_New_book);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(All_books_activity.this,Add_book.class);
                startActivity(intent);
            }
        });


        displayDatabaseInfo();
    }


    private void displayDatabaseInfo(){

        LibraryDbHelper mDbHelper = new LibraryDbHelper(this);

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                Lib_books._ID,
                Lib_books.COLUMN_BOOK_NAME,
                Lib_books.COLUMN_BOOK_AUTHOR,
                Lib_books.COLUMN_BOOK_PRICE,
                Lib_books.COLUMN_BOOK_STATUS
        };

        Cursor cursor = db.query(
                Lib_books.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );



        try {

            int idColumnIndex = cursor.getColumnIndex(Lib_books._ID);
            int nameColumnIndex = cursor.getColumnIndex(Lib_books.COLUMN_BOOK_NAME);
            int authorColumnIndex = cursor.getColumnIndex(Lib_books.COLUMN_BOOK_AUTHOR);
            int PriceColuumIndex = cursor.getColumnIndex(Lib_books.COLUMN_BOOK_PRICE);
            int StatusColumnIndex = cursor.getColumnIndex(Lib_books.COLUMN_BOOK_STATUS);

            while (cursor.moveToNext()){

                int currentId = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentAuthor = cursor.getString(authorColumnIndex);
                String currentPrice = cursor.getString(PriceColuumIndex);
                String currentStatus = cursor.getString(StatusColumnIndex);

               arrayList.add(new Book_arraylist(currentId,currentName,currentAuthor,
                       currentPrice,currentStatus));

            }

            Book_Adapter itemsAdapter = new Book_Adapter(this,arrayList);

            ListView listView = findViewById(R.id.list_book);

            listView.setAdapter(itemsAdapter);


        }finally {
            cursor.close();
        }
    }
}
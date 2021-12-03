package com.collegeproject.LMS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.collegeproject.LMS.data.LibraryDbHelper;
import com.collegeproject.LMS.data.LibraryContract.Lib_books;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class All_books_activity extends AppCompatActivity {

    TextView displayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_books);


//        if (bool){
//            Toast.makeText(All_books_activity.this, "Came here from All books  Button ", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(All_books_activity.this, "Came here from Avaliable books buttons ", Toast.LENGTH_SHORT).show();
//        }

        FloatingActionButton fab = findViewById(R.id.Add_New_book);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(All_books_activity.this,Add_book.class);
                startActivity(intent);
            }
        });
         displayView = findViewById(R.id.Books_View);

        displayDatabaseInfo();
    }

    @Override
    protected void onStart() {
        super.onStart();
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

        displayView.setText(Lib_books._ID + " - " +
                Lib_books.COLUMN_BOOK_NAME + " - " +
                Lib_books.COLUMN_BOOK_AUTHOR + " - " +
                Lib_books.COLUMN_BOOK_PRICE + " - " +
                Lib_books.COLUMN_BOOK_STATUS);

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

                displayView.append("\n "+currentId + " - " +currentName + " - "
                +currentAuthor+ " - "+ currentPrice+ " - "+ currentStatus);

            }
        }finally {
            cursor.close();
        }
    }
}
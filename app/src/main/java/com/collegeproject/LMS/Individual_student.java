package com.collegeproject.LMS;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.collegeproject.LMS.data.LibraryContract.Lib_books;
import com.collegeproject.LMS.data.LibraryContract.Lib_student;
import com.collegeproject.LMS.data.LibraryDbHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Individual_student extends AppCompatActivity {

    ArrayList<Student_arraylist> arraylists;

    ArrayList<Book_arraylist> Book_list;

    String value;

    Dialog myDialog;

    String book_student_taken;

    String[] books_taken;

    int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_student);

        arraylists = new ArrayList<>();

        Book_list = new ArrayList<>();

        a = getIntent().getIntExtra("yourIntName",0);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayData_InDialogBox();
            }
        });


        displayInfo_of_Student();



        if(books_taken != null){
            displayInfo_of_Books();
        }

    }


    public void displayInfo_of_Student(){

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

        // to display detailed data of the student
        Cursor cursor = db.query(
                Lib_student.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        try{
            int idColumnIndex = cursor.getColumnIndex(Lib_student._ID);
            int nameColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_NAME);
            int emailColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_EMAIL);
            int ageColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_AGE);
            int genderColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_GENDER);
            int numberColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_NUMBER);
            int addressColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_ADDRESS);
            int booksColumnIndex = cursor.getColumnIndex(Lib_student.COLUMN_STUDENT_BOOKS);


                cursor.moveToPosition(a);

                int currentId = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentemail = cursor.getString(emailColumnIndex);
                String currentage = cursor.getString(ageColumnIndex);
                String currentgender = cursor.getString(genderColumnIndex);
                String currentnumber = cursor.getString(numberColumnIndex);
                String currentaddress = cursor.getString(addressColumnIndex);
                String currentbooks = cursor.getString(booksColumnIndex);

                book_student_taken = currentbooks;

                if(currentbooks != null)
                books_taken = currentbooks.split(",");

                TextView Name = findViewById(R.id.In_name);

                Name.setText(currentName);

                TextView Number = findViewById(R.id.In_number);

                Number.setText(currentnumber);

                TextView Address = findViewById(R.id.In_address);

                Address.setText(currentaddress);

                TextView Email = findViewById(R.id.In_email);

                Email.setText(currentemail);

        }finally {
            cursor.close();
        }
    }

    public void displayInfo_of_Books(){


        // This method will display the books the student has taken

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

        try{

            int idColumnIndex = cursor.getColumnIndex(Lib_books._ID);
            int nameColumnIndex = cursor.getColumnIndex(Lib_books.COLUMN_BOOK_NAME);
            int authorColumnIndex = cursor.getColumnIndex(Lib_books.COLUMN_BOOK_AUTHOR);
            int PriceColuumIndex = cursor.getColumnIndex(Lib_books.COLUMN_BOOK_PRICE);
            int StatusColumnIndex = cursor.getColumnIndex(Lib_books.COLUMN_BOOK_STATUS);

            for(String seleted : books_taken){

                cursor.moveToPosition(Integer.valueOf(seleted));

                int currentId = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentAuthor = cursor.getString(authorColumnIndex);
                String currentPrice = cursor.getString(PriceColuumIndex);
                String currentStatus = cursor.getString(StatusColumnIndex);

                Book_list.add(new Book_arraylist(currentId,currentName,currentAuthor,
                        currentPrice,currentStatus));
            }

            Book_Adapter itemsAdapter = new Book_Adapter(this,Book_list);

            ListView listView = findViewById(R.id.StudentBook_list);

            listView.setAdapter(itemsAdapter);

        }finally {
            cursor.close();
        }
    }


    private void displayData_InDialogBox() {

        // Choose which book the student has taken
        Dialog myDialog = new Dialog(this);

        myDialog.setContentView(R.layout.which_book_taken);
        myDialog.getWindow().setBackgroundDrawable((new ColorDrawable(Color.TRANSPARENT)));
        myDialog.show();

        ArrayList<Book_arraylist> arrayList;

        arrayList = new ArrayList<>();

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

            while (cursor.moveToNext()) {

                int currentId = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentAuthor = cursor.getString(authorColumnIndex);
                String currentPrice = cursor.getString(PriceColuumIndex);
                String currentStatus = cursor.getString(StatusColumnIndex);

                arrayList.add(new Book_arraylist(currentId, currentName, currentAuthor,
                        currentPrice, currentStatus));

            }

            Book_Adapter itemsAdapter = new Book_Adapter(this, arrayList);

            ListView listView = myDialog.findViewById(R.id.list_dialog);

            listView.setAdapter(itemsAdapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    LibraryDbHelper mDbHelper = new LibraryDbHelper(Individual_student.this);


                    if (book_student_taken != null){
                       value =  book_student_taken+ ","+i;
                    }else{
                        value =  String.valueOf(i);
                    }


                    Toast.makeText(Individual_student.this, ""+value, Toast.LENGTH_SHORT).show();

                  mDbHelper.updatedata(String.valueOf(a + 1),value);



                  myDialog.dismiss();

                }
            });

        } finally {
            cursor.close();
        }
    }
}
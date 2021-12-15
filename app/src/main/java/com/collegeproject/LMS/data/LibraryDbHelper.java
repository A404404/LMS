package com.collegeproject.LMS.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.collegeproject.LMS.data.LibraryContract.*;


public class LibraryDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Library.db";

    private static final int DATABASE_VERSION = 1;

//    public LibraryDbHelper(Context context){
//        super(context,DATABASE_NAME,null,DATABASE_VERSION);
//    }
public LibraryDbHelper(Context context){
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_LIBRARY_TABLE_STUDENT = "CREATE TABLE "+ Lib_student.TABLE_NAME + " ("
                +Lib_student._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Lib_student.COLUMN_STUDENT_NAME+ " TEXT NOT NULL, "
                +Lib_student.COLUMN_STUDENT_EMAIL+ " TEXT, "
                +Lib_student.COLUMN_STUDENT_AGE+ " INTEGER , "
                +Lib_student.COLUMN_STUDENT_GENDER+ " TEXT ,"
                +Lib_student.COLUMN_STUDENT_NUMBER+ " INTEGER ,"
                +Lib_student.COLUMN_STUDENT_ADDRESS+ " TEXT ,"
                +Lib_student.COLUMN_STUDENT_BOOKS + " INTEGER );";

        sqLiteDatabase.execSQL(SQL_CREATE_LIBRARY_TABLE_STUDENT);

    String SQL_CREATE_LIBRARY_TABLE_BOOKS = "CREATE TABLE "+ Lib_books.TABLE_NAME + " ("
            +Lib_books._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +Lib_books.COLUMN_BOOK_NAME+ " TEXT NOT NULL, "
            +Lib_books.COLUMN_BOOK_AUTHOR+ " TEXT, "
            +Lib_books.COLUMN_BOOK_PRICE+ " INTEGER NOT NULL, "
            +Lib_books.COLUMN_BOOK_STATUS+ " INTEFER NOT NULL DEFAULT 0);" ;

    sqLiteDatabase.execSQL(SQL_CREATE_LIBRARY_TABLE_BOOKS);
    }

    public boolean updatedata(String id, String books) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Lib_student.COLUMN_STUDENT_BOOKS, books);
        return db.update("Library_Student", contentValues, Lib_student._ID + " = ?", new String[]{id}) > 0;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Lib_student.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}

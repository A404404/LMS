package com.collegeproject.LMS.data;

import android.provider.BaseColumns;

public class LibraryContract {

    private LibraryContract(){}

    public static final class Lib_books implements BaseColumns{

        public final static String TABLE_NAME = "Library_Books";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_BOOK_NAME = "name";
        public final static String COLUMN_BOOK_AUTHOR = "author";
        public final static String COLUMN_BOOK_PRICE = "price";
        public final static String COLUMN_BOOK_STATUS = "status";
    }

    public static final class Lib_student implements BaseColumns{

        public final static String TABLE_NAME = "Library_Student";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_STUDENT_NAME = "name";
        public final static String COLUMN_STUDENT_EMAIL = "email";
        public final static String COLUMN_STUDENT_AGE = "age";
        public final static String COLUMN_STUDENT_GENDER = "gender";
        public final static String COLUMN_STUDENT_NUMBER = "number";
        public final static String COLUMN_STUDENT_ADDRESS = "address";
        public final static String COLUMN_STUDENT_BOOKS = "books";


    }
}

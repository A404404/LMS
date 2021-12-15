package com.collegeproject.LMS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout Students = findViewById(R.id.students);

        Students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Students_Activity.class);
                startActivity(intent);
            }
        });

        LinearLayout Books = findViewById(R.id.Books);

        Books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,All_books_activity.class);
                startActivity(intent);
            }
        });

        LinearLayout about_us = findViewById(R.id.About_us);

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this,About_us.class );
               startActivity(intent);
            }
        });

        LinearLayout status = findViewById(R.id.Statatics);

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Status.class);
                startActivity(intent);

            }
        });

    }
}
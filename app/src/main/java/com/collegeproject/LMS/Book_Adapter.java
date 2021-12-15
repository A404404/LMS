package com.collegeproject.LMS;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Book_Adapter extends ArrayAdapter<Book_arraylist>{

    public Book_Adapter(Activity context, ArrayList<Book_arraylist> Book_arraylist){
        super(context,0,Book_arraylist);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.book_listview,parent,false);
        }

        Book_arraylist currentstudent = getItem(position);

        TextView Name = listItemView.findViewById(R.id.Book_Name);

        Name.setText(currentstudent.getBook_Name());

        TextView Author = listItemView.findViewById(R.id.Author_Name);

        Author.setText(currentstudent.getAuthor());

        TextView Price = listItemView.findViewById(R.id.Price);

        Price.setText(currentstudent.getPrice());

        TextView Status = listItemView.findViewById(R.id.Status);

        Status.setText(currentstudent.getStatus());


        return listItemView;
    }
}

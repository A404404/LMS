package com.collegeproject.LMS;

public class Book_arraylist {

    private int id;

    private String Book_Name;

    private String Author;

    private String Price;

    private String Status;

    public Book_arraylist(int id,
                          String Book_Name,
                          String Author,
                          String Price,
                          String Status){

        this.Book_Name = Book_Name;

        this.Author = Author;

        this.Price = Price;

        this.Status = Status;
    }

    public int getId(){
        return id;
    }

    public String getBook_Name(){
        return Book_Name;
    }

    public String getAuthor(){
        return Author;
    }

    public String getPrice(){
        return Price;
    }

    public String getStatus(){
        return Status;
    }
}

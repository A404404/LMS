package com.collegeproject.LMS;

import android.provider.Telephony;

public class Student_arraylist {

    private int id;

    private String Name;

    private String Email;

    private String Age;

    private String Gender;

    private String Number;

    private String Address;

    private String books;

    public Student_arraylist(int id,
                            String Name,
                            String Email,
                            String Age,
                            String Gender,
                            String Number,
                            String Address,
                            String books){

        this.id = id;

        this.Name = Name;

        this.Email = Email;

        this.Age = Age;

        this.Gender = Gender;

        this.Number = Number;

        this.Address = Address;

        this.books = books;

    }

    public int getId(){
        return id;
    }

    public String getName(){
        return Name;
    }

    public String getEmail(){
        return Email;
    }

    public String getAge(){
        return Age;
    }

    public String getGender(){
        return Gender;
    }

    public String getNumber(){
        return Number;
    }

    public String getAddress(){
        return Address;
    }

    public String getBooks(){
        return books;
    }

}

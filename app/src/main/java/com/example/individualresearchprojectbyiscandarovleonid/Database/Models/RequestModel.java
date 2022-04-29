package com.example.individualresearchprojectbyiscandarovleonid.Database.Models;

public class RequestModel {
    private int id ;
    private int day;
    private int month ;
    private int year ;
    private String name ;
    private int category_id ;
    private int amount ;

    public RequestModel(int id , int day , int month , int year , String name , int category_id , int amount) {
        this.id = id;
        this.day = day ;
        this.month = month;
        this.year = year ;
        this.name = name ;
        this.category_id = category_id ;
        this.amount = amount ;
    }


    @Override
    public String toString() {
        return "RequestModel{" +
                "id=" + id +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", name='" + name + '\'' +
                ", category_id=" + category_id +
                ", amount=" + amount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

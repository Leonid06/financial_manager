package com.example.individualresearchprojectbyiscandarovleonid.Fragments.Dialogs;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.Button;

import java.util.Calendar;


public class MyDatePicker {
    Calendar calendar = Calendar.getInstance() ;
    DatePickerDialog datePickerDialog ;
    Button datePickButton ;
    public int day , month , year;


     public MyDatePicker(Button datePickButton , Context context) {
        this.datePickButton = datePickButton ;
        this.datePickButton.setText(this.getCurrentDate());
        this.day = calendar.get(Calendar.DAY_OF_MONTH) ;
        this.month = calendar.get(Calendar.MONTH) ;
        this.year = calendar.get(Calendar.YEAR) ;
        
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
                month += 1;
                String date = makeDateString(day , month , year) ;
                changeDate(day , month , year) ;
                datePickButton.setText(date);
            }
        };




        this.datePickerDialog = new DatePickerDialog(context,
                DatePickerDialog.THEME_HOLO_DARK ,
                dateSetListener , year , month , day);

    }

    private String getCurrentDate() {
        int curDay = calendar.get(Calendar.DAY_OF_MONTH) ;
        int curMonth = calendar.get(Calendar.MONTH) + 1 ;
        int curYear = calendar.get(Calendar.YEAR) ;

        return makeDateString(curDay , curMonth , curYear) ;
    }

    public void showDatePickerDialog(){
        datePickerDialog.show();
    }

    public DatePickerDialog getDatePickerDialog(){
        return  this.datePickerDialog ;
    }

    private String makeDateString(int day, int month, int year) {
            return day + "/" + month  + "/" + year ;
    }

    private void changeDate(int day , int month , int year){
         this.day =  day ;
         this.year = year ;
         this.month = month ;
    }





}

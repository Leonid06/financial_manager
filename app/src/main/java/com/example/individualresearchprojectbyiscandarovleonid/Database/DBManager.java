//package com.example.individualresearchprojectbyiscandarovleonid.Database;
//
//import android.annotation.SuppressLint;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.widget.Toast;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class DBManager {
//    private Context context ;
//    private DBHelper dbHelper ;
//    private SQLiteDatabase db ;
//
//    public DBManager(Context context){
//        this.context = context ;
//        dbHelper = new DBHelper(context) ;
//    }
//    public void openDB(){
//        db = dbHelper.getWritableDatabase();
//    }
//
//    public void insertDB(String date , String name , String category , int price){
//        ContentValues contentValues = new ContentValues() ;
//        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        contentValues.put(DBConstants.MAIN_COLUMN_DATE, dateFormat.format(new Date()));
//        contentValues.put(DBConstants.MAIN_COLUMN_NAME, name);
//        contentValues.put( DBConstants.MAIN_COLUMN_CATEGORY_ID, category);
//        contentValues.put(DBConstants.MAIN_COLUMN_PRICE,price );
//
//        db.insert(DBConstants.MAIN_TABLE_NAME , null , contentValues) ;
//
//    }
//    public void insertDB(String category){
//        ContentValues contentValues = new ContentValues() ;
//        contentValues.put(DBConstants.CATEGORY_COLUMN_NAME ,  category);
//
//        db.insert(DBConstants.CATEGORY_TABLE_NAME, null , contentValues) ;
//
//    }
//}

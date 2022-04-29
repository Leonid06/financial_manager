package com.example.individualresearchprojectbyiscandarovleonid.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.individualresearchprojectbyiscandarovleonid.Database.Models.CategoryModel;
import com.example.individualresearchprojectbyiscandarovleonid.Database.Models.RequestModel;
import com.example.individualresearchprojectbyiscandarovleonid.Debug.Tags;

import java.util.ArrayList;
import java.util.HashMap;


public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private final Context context;


    public DBHelper(@Nullable Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }


    public boolean addNewRequest(RequestModel requestModel, CategoryModel categoryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        try {
            cv.put(DBConstants.MAIN_COLUMN_DAY, requestModel.getDay());
            cv.put(DBConstants.MAIN_COLUMN_MONTH, requestModel.getMonth());
            cv.put(DBConstants.MAIN_COLUMN_YEAR, requestModel.getYear());
            cv.put(DBConstants.MAIN_COLUMN_NAME, requestModel.getName());
            cv.put(DBConstants.MAIN_COLUMN_CATEGORY_ID, categoryModel.getId());
            cv.put(DBConstants.MAIN_COLUMN_AMOUNT, requestModel.getAmount());
            db.insert(DBConstants.MAIN_TABLE_NAME , null , cv);
        } catch (Exception e) {
            Log.e(Tags.ERROR, e.toString());
            return false;
        }

//        final long insert = db.insert(DBConstants.MAIN_TABLE_NAME, null, cv);

        db.close();

        return true;

    }

    public HashMap<Integer, String> getCategories() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBConstants.CATEGORY_TABLE_NAME, null);
        HashMap<Integer, String> categories = new HashMap<>();

        try {
            if (cursor.moveToFirst()) {
                do {
                    categories.put(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            Log.e(Tags.ERROR, e.toString());
        }

        return categories;
    }

    public String getIdByCategoryName(String categoryName) {
        String name = "";

        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT " + DBConstants.CATEGORY_COLUMN_ID +
                    " FROM " + DBConstants.CATEGORY_TABLE_NAME + " WHERE " + DBConstants.CATEGORY_COLUMN_NAME +
                    " = \"" + categoryName + "\"", null);

            if (cursor.moveToFirst()) {
                do {
                    name = cursor.getString(0);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            Log.e(Tags.ERROR, e.toString());
        }


        return name;

    }

    public void addCategory(CategoryModel categoryModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBConstants.CATEGORY_COLUMN_NAME, categoryModel.getName());
        db.insert(DBConstants.CATEGORY_TABLE_NAME, null, values);

        db.close();


    }

    public int getAmountByMonthAndCategory(int month , int category_id){
        int amount  = -1;
         try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT " + "sum(" + DBConstants.MAIN_COLUMN_AMOUNT +") FROM " +
                    DBConstants.MAIN_TABLE_NAME + " WHERE " + DBConstants.MAIN_COLUMN_MONTH + " = " +
                    month + " AND " + DBConstants.MAIN_COLUMN_CATEGORY_ID + " = " + category_id + ";", null);

            if (cursor.moveToFirst()) {
                do {
                    amount = cursor.getInt(0); ;

                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            Log.e(Tags.ERROR, e.toString());
        }
//         Log.i(Tags.INFO , "category_id = " + category_id + " : " + String.valueOf(amount));
         return  amount ;
    }

    public int getSumForMonthByCategoryId(int month , int category_id){
        int sum = 0 ;

        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT sum( " +DBConstants.MAIN_COLUMN_AMOUNT + " )," +
                    DBConstants.MAIN_COLUMN_CATEGORY_ID + " FROM " + DBConstants.MAIN_TABLE_NAME +
                    " WHERE month = " + month + " AND " +
                    DBConstants.MAIN_COLUMN_CATEGORY_ID + " = " + category_id +" GROUP BY " +
                    DBConstants.MAIN_COLUMN_CATEGORY_ID , null);

            if (cursor.moveToFirst()) {
                do {
                  sum = cursor.getInt(0) ;

                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            Log.e(Tags.ERROR, e.toString());
        }

        return  sum;


    }

     public ArrayList<String> getDates(){

        ArrayList<String> dates = new ArrayList<>();
        String day , month , year ;

        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT " + DBConstants.MAIN_COLUMN_DAY + ", "
                            + DBConstants.MAIN_COLUMN_MONTH + ", " + DBConstants.MAIN_COLUMN_YEAR + " FROM "
                            + DBConstants.MAIN_TABLE_NAME +  " ORDER BY " + DBConstants.MAIN_COLUMN_YEAR + " DESC , " + DBConstants.MAIN_COLUMN_MONTH +
                            " DESC," + DBConstants.MAIN_COLUMN_DAY + " DESC;"

                    , null);



            if (cursor.moveToFirst()) {
                do {
                     day = cursor.getString(0);
                     month = cursor.getString(1) ;
                     year = cursor.getString(2) ;
                    if(Integer.parseInt(day) < 10){
                        day = "0" + day ;
                    }
                    if(Integer.parseInt(month) < 10){
                        month = "0" + month ;
                    }
                    dates.add(  day+ "/" +month  + "/" + year
                            ) ;

                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            Log.e(Tags.ERROR, e.toString());
        }

        return  dates;

    }

    public ArrayList<String> getAmounts() {

        ArrayList<String> amounts = new ArrayList<>();


        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT " + DBConstants.MAIN_COLUMN_AMOUNT + " FROM "
                            + DBConstants.MAIN_TABLE_NAME +  " ORDER BY " + DBConstants.MAIN_COLUMN_YEAR + " DESC , " + DBConstants.MAIN_COLUMN_MONTH +
                            " DESC," + DBConstants.MAIN_COLUMN_DAY + " DESC;"

                    , null);


            if (cursor.moveToFirst()) {
                do {
                    amounts.add(String.valueOf(cursor.getInt(0)));

                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            Log.e(Tags.ERROR, e.toString());
        }

        return  amounts;

    }

    public ArrayList<String> getCategoryNames() {

        ArrayList<String> names = new ArrayList<>();

        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery( ("SELECT " + DBConstants.CATEGORY_TABLE_NAME + "." +
                            DBConstants.CATEGORY_COLUMN_NAME + " FROM "
                            + DBConstants.MAIN_TABLE_NAME + " LEFT JOIN " + DBConstants.CATEGORY_TABLE_NAME +
                            " ON " + DBConstants.MAIN_TABLE_NAME + "." + DBConstants.MAIN_COLUMN_CATEGORY_ID +
                            " = " + DBConstants.CATEGORY_TABLE_NAME + "." + DBConstants.CATEGORY_COLUMN_ID +
                            " ORDER BY " + DBConstants.MAIN_COLUMN_YEAR + " DESC , " + DBConstants.MAIN_COLUMN_MONTH +
                            " DESC," + DBConstants.MAIN_COLUMN_DAY + " DESC;" )

                    , null);


            if (cursor.moveToFirst()) {
                do {
                    names.add(cursor.getString(0));

                } while (cursor.moveToNext());
            }
            cursor.close();
            String log = "" ;
            for(int i = 0 ; i < names.size() ; i++){
                log += i + ":" + names.get(i) + "\n";
            }
            Log.i(Tags.INFO , log);
        } catch (Exception e) {
            Log.e(Tags.ERROR, e.toString());
        }

        return  names;

    }
}


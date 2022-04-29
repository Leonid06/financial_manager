package com.example.individualresearchprojectbyiscandarovleonid.Database;

public class DBConstants {
    public static final String DATABASE_NAME = "management.db";
    public static final int DATABASE_VERSION = 1 ;
    public static final String MAIN_TABLE_NAME = "requests";
    public static final String MAIN_COLUMN_CATEGORY_ID = "category_id";
    public static final String MAIN_COLUMN_AMOUNT = "amount" ;
    public static final String MAIN_COLUMN_DAY = "day" ;
    public static final String MAIN_COLUMN_MONTH = "month" ;
    public static final String MAIN_COLUMN_YEAR = "year" ;
    public static final String MAIN_COLUMN_NAME = "name" ;

    public static final String CATEGORY_TABLE_NAME = "category";
    public static final String CATEGORY_COLUMN_ID = "id" ;
    public static final String CATEGORY_COLUMN_NAME = "name" ;


//    public static final String CREATE_MAIN_TABLE =
//            "CREATE TABLE IF NOT EXISTS" + MAIN_TABLE_NAME + "("
//                    + MAIN_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    MAIN_COLUMN_DATE + " TEXT," +
//                    MAIN_COLUMN_NAME + " TEXT," +
//                    MAIN_COLUMN_CATEGORY_ID + " INTEGER," +
//                    MAIN_COLUMN_AMOUNT + " INTEGER)" +
//                    "FOREIGN KEY(" +MAIN_COLUMN_CATEGORY_ID + ") " +
//                    "REFERENCES " + CATEGORY_TABLE_NAME +"(" + CATEGORY_COLUMN_ID +"));";
//
//    public static final String CREATE_CATEGORY_TABLE =
//            "CREATE TABLE IF NOT EXISTS" + CATEGORY_TABLE_NAME + "("
//                    + CATEGORY_COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    CATEGORY_COLUMN_NAME + " TEXT);" ;


//    public static final String DROP_TABLE =
//            "DROP TABLE IF EXISTS " + MAIN_TABLE_NAME ;

}

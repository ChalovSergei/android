package com.example.o;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "financialAccountingDB";
    public static final String TABLE_INCOME = "income";
    public static final String TABLE_EXPENSES = "expenses";
    public static final String TABLE_FINANCE = "finance";
    public static final String KEY_ID = "id";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_MONEY = "money";
    public static final String KEY_DATE = "date";
    public static final String CREATE_INCOME_TABLE = "CREATE TABLE " + TABLE_INCOME + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CATEGORY + " TEXT,"
            + KEY_MONEY + " INTEGER,"
            + KEY_DATE + " TEXT" + ")";
    public static final String CREATE_EXPENSES_TABLE = "CREATE TABLE " + TABLE_EXPENSES + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CATEGORY + " TEXT,"
            + KEY_MONEY + " INTEGER,"
            + KEY_DATE + " TEXT" + ")";
    public static final String CREATE_FINANCE_TABLE = "CREATE TABLE " + TABLE_FINANCE + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_MONEY + " INTEGER" + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_INCOME_TABLE);
        db.execSQL(CREATE_EXPENSES_TABLE);
        db.execSQL(CREATE_FINANCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INCOME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FINANCE);
        String sql = "INSERT INTO TABLE_FINANCE (KEY_ID, KEY_MONEY) VALUES ('2', '0');";
        db.execSQL(sql);
        onCreate(db);
    }

    public void getIncomeInfo(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_INCOME, null,
                null, null, null, null, null);
        if(cursor.moveToFirst()){
            int categoryIndex = cursor.getColumnIndex(DBHelper.TABLE_INCOME);
            int moneyIndex = cursor.getColumnIndex(DBHelper.TABLE_INCOME);
            int dateIndex = cursor.getColumnIndex(DBHelper.TABLE_INCOME);
        }
        cursor.close();
    }
    public void getExpensesInfo(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_EXPENSES, null,
                null, null, null, null, null);
        if(cursor.moveToFirst()){
            int getMoney = cursor.getColumnIndex(DBHelper.TABLE_EXPENSES);
        }
        cursor.close();
    }
}

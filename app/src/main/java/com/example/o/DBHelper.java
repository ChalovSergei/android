package com.example.o;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "financialAccountingDB";
    public static final String TABLE_INCOME = "income";
    public static final String TABLE_EXPENSES = "expenses";
    public static final String TABLE_FINANCE = "finance";
    public static final String TABLE_PLANNING_EXPENSES = "planningExpenses";
    public static final String KEY_ID = "id";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_MONEY = "money";
    public static final String KEY_DATE = "date";
    public static final String KEY_DATE_START = "date_start";
    public static final String KEY_DATE_END = "date_end";

    public static final String CREATE_INCOME_TABLE = "CREATE TABLE " + TABLE_INCOME + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CATEGORY + " TEXT,"
            + KEY_MONEY + " INTEGER,"
            + KEY_DATE + " INTEGER" + ")";
    public static final String CREATE_EXPENSES_TABLE = "CREATE TABLE " + TABLE_EXPENSES + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CATEGORY + " TEXT,"
            + KEY_MONEY + " INTEGER,"
            + KEY_DATE + " INTEGER" + ")";
    public static final String CREATE_FINANCE_TABLE = "CREATE TABLE " + TABLE_FINANCE + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_MONEY + " INTEGER" + ")";
    public static final String CREATE_PLANNING_EXPENSES_TABLE = "CREATE TABLE " + TABLE_PLANNING_EXPENSES + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_MONEY + " INTEGER,"
            + KEY_DATE_START + " INTEGER,"
            + KEY_DATE_END + " INTEGER"+ ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_INCOME_TABLE);
        db.execSQL(CREATE_EXPENSES_TABLE);
        db.execSQL(CREATE_FINANCE_TABLE);
        db.execSQL(CREATE_PLANNING_EXPENSES_TABLE);
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_MONEY, 0);
        db.insert(TABLE_FINANCE, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INCOME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FINANCE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANNING_EXPENSES);
        onCreate(db);
    }
}

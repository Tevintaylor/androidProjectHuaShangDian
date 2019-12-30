package com.example.huashangdian.DataBasePack;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.huashangdian.DataBasePack.FlowersContract.FlowersEntry;

public class FlowerDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "flowerList.db";
    public static final int DATABASE_VERSION = 1;

    public FlowerDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_FLOWERLIST_TABLE = "CREATE TABLE "+
                FlowersEntry.TABLE_NAME + " ("+
                FlowersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                FlowersEntry.COLUMN_NAME + " TEXT NOT NULL, "+
                FlowersEntry.COLUMN_PRICE + " DECIMAL NOT NULL, "+
                FlowersEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, "+
                FlowersEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP"+
                ");";

        sqLiteDatabase.execSQL(SQL_CREATE_FLOWERLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ FlowersEntry.TABLE_NAME);
    }

    public void removeAll()
    {
        // db.delete(String tableName, String whereClause, String[] whereArgs);
        // If whereClause is null, it will delete all rows.
        SQLiteDatabase db = this.getWritableDatabase(); // helper is object extends SQLiteOpenHelper
        db.delete(FlowerDBHelper.DATABASE_NAME, null, null);
    }
}

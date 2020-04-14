package com.example.faellesskabet.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BorrowBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME= "BorrowDataBase.db";

    public BorrowBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + BorrowDbSchema.ItemTable.NAME + "(" +
                BorrowDbSchema.ItemTable.Cols.NAME + ", " +
                BorrowDbSchema.ItemTable.Cols.ROOMNUMBER + "," +
                BorrowDbSchema.ItemTable.Cols.PHONENUMBER + "," +
                BorrowDbSchema.ItemTable.Cols.DATE +"," +
                BorrowDbSchema.ItemTable.Cols.DEPOSIT + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

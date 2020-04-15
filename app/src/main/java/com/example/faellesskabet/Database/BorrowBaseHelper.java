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
        db.execSQL("create table " + BorrowDbSchema.BorrowTable.NAME + "(" +
                //BorrowDbSchema.BorrowTable.Cols.ID + ", " +
                BorrowDbSchema.BorrowTable.Cols.NAME + ", " +
                BorrowDbSchema.BorrowTable.Cols.ROOMNUMBER + "," +
                BorrowDbSchema.BorrowTable.Cols.PHONENUMBER + "," +
                //BorrowDbSchema.BorrowTable.Cols.DATE +"," +
                BorrowDbSchema.BorrowTable.Cols.DEPOSIT + ")"
        );

        db.execSQL("create table " + BorrowDbSchema.Itemtable.NAME + "(" +
                //BorrowDbSchema.Itemtable.Cols.ID + ", " +
                BorrowDbSchema.Itemtable.Cols.WHAT + ", " +
                BorrowDbSchema.Itemtable.Cols.COLOUR + ")"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

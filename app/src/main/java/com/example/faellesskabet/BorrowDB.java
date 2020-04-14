package com.example.faellesskabet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.faellesskabet.Database.BorrowBaseHelper;

public class BorrowDB {

    private static BorrowDB sBorrowDB;
    private static SQLiteDatabase mDatabase;

    private BorrowDB(Context context) {

    }

    public static synchronized BorrowDB get(Context context) {
        if (sBorrowDB == null) {
            mDatabase = new BorrowBaseHelper(context.getApplicationContext()).getWritableDatabase();
            sBorrowDB = new BorrowDB(context);
        }
        return sBorrowDB;
    }
}

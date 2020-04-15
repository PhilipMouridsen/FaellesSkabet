package com.example.faellesskabet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.faellesskabet.Database.BorrowBaseHelper;
import com.example.faellesskabet.Database.BorrowCursorWrapper;
import com.example.faellesskabet.Database.BorrowDbSchema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class BorrowDB extends Observable {

    //private List<Borrow> Borrower;

    private static BorrowDB sBorrowDB;
    private static SQLiteDatabase mDatabase;
    private Context mContext;


    private BorrowDB(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new BorrowBaseHelper(mContext).getWritableDatabase();

    }

    public static BorrowDB get(Context context) {
        if (sBorrowDB == null) {
            mDatabase = new BorrowBaseHelper(context.getApplicationContext()).getWritableDatabase();
            sBorrowDB = new BorrowDB(context);
        }
        return sBorrowDB;
    }

    public void addBorrower(String name, int roomNumber, int phoneNumber, int deposit) {
        Borrow borrower = new Borrow(name, roomNumber, phoneNumber, deposit);
        ContentValues values = getContentValues(borrower);
        mDatabase.insert(BorrowDbSchema.BorrowTable.NAME, null, values);
        this.setChanged();
    }

    public ArrayList<Borrow> getBorrowers() {
        ArrayList<Borrow> borrowers = new ArrayList<Borrow>();
        BorrowCursorWrapper cursor = queryItems(null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            borrowers.add(cursor.getBorrow());
            cursor.moveToNext();
        }
        cursor.close();
        return borrowers;
    }


    private BorrowCursorWrapper queryItems(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                BorrowDbSchema.BorrowTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new BorrowCursorWrapper(cursor);
        }

    private static ContentValues getContentValues(Borrow borrow) {
        ContentValues values = new ContentValues();
        //values.put(BorrowDbSchema.BorrowTable.Cols.ID, borrow.getID());
        values.put(BorrowDbSchema.BorrowTable.Cols.NAME, borrow.getName());
        values.put(BorrowDbSchema.BorrowTable.Cols.ROOMNUMBER, borrow.getRoomNo());
        values.put(BorrowDbSchema.BorrowTable.Cols.PHONENUMBER, borrow.getPhoneNo());
        values.put(BorrowDbSchema.BorrowTable.Cols.DEPOSIT, borrow.getDeposit());
        return values;
    }



}

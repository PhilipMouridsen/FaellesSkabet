package com.example.faellesskabet.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.faellesskabet.Borrow;

import java.util.Date;

public class BorrowCursorWrapper extends CursorWrapper {
    public BorrowCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Borrow getItem() {
        String name = getString(getColumnIndex(BorrowDbSchema.ItemTable.Cols.NAME));
        int roomnumber = getInt(getColumnIndex(BorrowDbSchema.ItemTable.Cols.ROOMNUMBER));
        int phonenumber = getInt(getColumnIndex(BorrowDbSchema.ItemTable.Cols.PHONENUMBER));
        long date = getLong(getColumnIndex(BorrowDbSchema.ItemTable.Cols.DATE));
        int deposit = getInt(getColumnIndex(BorrowDbSchema.ItemTable.Cols.DEPOSIT));

        Borrow borrow = new Borrow(name, roomnumber, phonenumber, deposit);

        /*borrow.setName(name);
        borrow.setRoomNo(roomnumber);
        borrow.setPhoneNo(phonenumber);
        borrow.setDate(new Date(date));
        borrow.setDeposit(deposit);*/
        return borrow; //:)
    }
}


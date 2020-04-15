package com.example.faellesskabet.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.faellesskabet.Borrow;
import com.example.faellesskabet.Item;

import java.util.Date;
import java.util.UUID;

public class BorrowCursorWrapper extends CursorWrapper {
    public BorrowCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Borrow getBorrow() {
        String name = getString(getColumnIndex(BorrowDbSchema.BorrowTable.Cols.NAME));
        //String UUIDString = getString(getColumnIndex(BorrowDbSchema.BorrowTable.Cols.ID));
        int roomnumber = getInt(getColumnIndex(BorrowDbSchema.BorrowTable.Cols.ROOMNUMBER));
        int phonenumber = getInt(getColumnIndex(BorrowDbSchema.BorrowTable.Cols.PHONENUMBER));
        //long date = getLong(getColumnIndex(BorrowDbSchema.BorrowTable.Cols.DATE));
        int deposit = getInt(getColumnIndex(BorrowDbSchema.BorrowTable.Cols.DEPOSIT));

        Borrow borrow = new Borrow(name, roomnumber, phonenumber, deposit);

        /*borrow.setName(name);
        borrow.setRoomNo(roomnumber);
        borrow.setPhoneNo(phonenumber);
        borrow.setDate(new Date(date));
        borrow.setDeposit(deposit);*/
        return borrow; //:)
    }

    public Item getItem() {
        //String UUID = getString(getColumnIndex(BorrowDbSchema.Itemtable.Cols.ID));
        String what = getString(getColumnIndex(BorrowDbSchema.Itemtable.Cols.WHAT));
        String colour = getString(getColumnIndex(BorrowDbSchema.Itemtable.Cols.COLOUR));

        Item item = new Item(what, colour);

        return item;

    }
}


package com.example.faellesskabet;

import java.util.Date;
import java.util.List;

public class Borrow {

    private String mName;
    private int mRoomNo;
    private int mPhoneNo;
    private Date mDate;
    private int mDeposit;
    private List<Item> mItems;

    public Borrow(String name, int roomNo, int phoneNo, int deposit){
        mName = name;
        mRoomNo = roomNo;
        mPhoneNo = phoneNo;
        mDate = new Date();
        mDeposit = deposit;
    }

    public String getName() {
        return mName;
    }

    public int getRoomNo() {
        return mRoomNo;
    }

    public int getPhoneNo() {
        return mPhoneNo;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public int getDeposit() {
        return mDeposit;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setRoomNo(int roomNo) {
        mRoomNo = roomNo;
    }

    public void setPhoneNo(int phoneNo) {
        mPhoneNo = phoneNo;
    }

    public void setDeposit(int deposit) {
        mDeposit = deposit;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }

    public void setName(String name) {
        mName = name;
    }
}

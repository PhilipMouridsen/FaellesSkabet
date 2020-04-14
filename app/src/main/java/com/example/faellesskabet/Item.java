package com.example.faellesskabet;

public class Item {

    private String mWhat;
    private String mColor;

    public Item(String what, String color){
        mWhat = what;
        mColor = color;
        // Also niiiiiiice
    }

    public String getWhat() {
        return mWhat;
    }

    public String getColor() {
        return mColor;
    }

    public void setWhat(String what) {
        mWhat = what;
    }

    public void setColor(String color) {
        mColor = color;
    }

}

package com.example.faellesskabet.Database;

import java.util.UUID;

public class BorrowDbSchema {
    public static final class BorrowTable {
        public static final String NAME = "Borrow";

        public static final class Cols {
           // public static final String ID = "ID";
            public static final String NAME = "name";
            public static final String ROOMNUMBER = "room number";
            public static final String PHONENUMBER = "phone number";
            //public static final String DATE = "date";
            public static final String DEPOSIT = "deposit";
        }
    }

    public static final class Itemtable {

        public static final String NAME = "Items";

        public static final class Cols {
            public static final String ID = "ID";
            public static final String WHAT = "Category";
            public static final String COLOUR = "Colour";
        }
    }
}

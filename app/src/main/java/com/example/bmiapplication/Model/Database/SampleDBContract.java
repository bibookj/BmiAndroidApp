package com.example.bmiapplication.Model.Database;

import android.provider.BaseColumns;

public final class SampleDBContract {
    private SampleDBContract() {
    }

    public static class Bmi implements BaseColumns {
        public static final String TABLE_NAME = "BmiTable";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_BMI = "bmi";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SURNAME = "surname";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BMI + " REAL NOT NULL, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_SURNAME + " TEXT NOT NULL " + ")";


    }
}
package com.example.bmiapplication.Model.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BmiDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bmi_database";

    public BmiDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SampleDBContract.Bmi.CREATE_TABLE);
    }

    public void insertBmi(float bmi, String name, String surname){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO "+SampleDBContract.Bmi.TABLE_NAME+
                " ("+SampleDBContract.Bmi.COLUMN_BMI+
                ", "+SampleDBContract.Bmi.COLUMN_NAME+
                ", "+SampleDBContract.Bmi.COLUMN_SURNAME+
                ") VALUES ("+bmi+",\""+name+"\",\""+surname+"\")");

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+SampleDBContract.Bmi.TABLE_NAME,null);
        return res;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

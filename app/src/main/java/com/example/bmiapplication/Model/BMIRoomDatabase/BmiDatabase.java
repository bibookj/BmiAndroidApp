package com.example.bmiapplication.Model.BMIRoomDatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Bmi.class}, version = 1, exportSchema = false)
public abstract class BmiDatabase extends RoomDatabase {

    public abstract BmiDAO bmiDAO();

    private static volatile BmiDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static BmiDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BmiDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BmiDatabase.class, "bmi_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}


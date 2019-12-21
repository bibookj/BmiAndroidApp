package com.example.bmiapplication.Model.BMIRoomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface BmiDAO {

    @Insert()
    void insert(Bmi bmi);


    @Query("SELECT * from bmi_table ORDER BY id DESC")
    List<Bmi> getAllBmi();

}



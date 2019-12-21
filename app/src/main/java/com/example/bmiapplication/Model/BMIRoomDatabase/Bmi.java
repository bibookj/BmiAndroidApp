package com.example.bmiapplication.Model.BMIRoomDatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName="bmi_table")
public class Bmi {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @NonNull
    @ColumnInfo(name = "surname")
    private String surname;
    @NonNull
    @ColumnInfo(name = "bmi")
    private float bmi;

    public Bmi(String name, String surname, float bmi) {
        this.name = name;
        this.surname = surname;
        this.bmi = bmi;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getBmi() {
        return bmi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

}

package com.example.bmiapplication.Model.Database;

public class BmiItem {
    private String name;
    private String surname;
    private float bmi;

    public BmiItem(String name, String surname, float bmi) {
        this.name = name;
        this.surname = surname;
        this.bmi = bmi;
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

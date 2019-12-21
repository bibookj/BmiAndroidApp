package com.example.bmiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmiapplication.Model.BmiCalculator;
import com.example.bmiapplication.Model.Database.BmiDatabase;
import com.example.bmiapplication.Model.Database.SampleDBContract;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    Button btnSave;
    Button btnShow;
    TextView textViewBMI;
    EditText editTextHeight;
    EditText editTextWeight;
    BmiCalculator bmiCalculator;
    float weight;
    float height;
    String bmi;
    int color;
    float bmiVal;
    BmiDatabase bmiDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bmiCalculator = new BmiCalculator();

        editTextHeight=findViewById(R.id.heightInput);
        editTextWeight=findViewById(R.id.weightInput);
        textViewBMI=findViewById(R.id.textViewBMI);
        bmiDatabase = new BmiDatabase(this);
        btnShow=findViewById(R.id.btnShow);
        btnSave=findViewById(R.id.btnSave);
        btnCalculate=findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight=Float.parseFloat(editTextWeight.getText().toString());
                height=Float.parseFloat(editTextHeight.getText().toString());
                bmi = bmiCalculator.CalculateToString(height,weight);
                textViewBMI.setText(bmi);
                bmiVal=Float.parseFloat(bmi);
                if(bmiVal<15||bmiVal>30)color=getColor(R.color.colorAccent);
                else if(bmiVal<18.5||bmiVal>25)color=getColor((R.color.colorOrange));
                else color=getColor(R.color.colorGreen);
                textViewBMI.setTextColor(color);
                textViewBMI.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.VISIBLE);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("bmi", bmi);
                intent.putExtra("color",color);
                startActivity(intent);
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Działa",Toast.LENGTH_SHORT).show();
                Cursor res = bmiDatabase.getAllData();
                if(res.getCount() == 0) {
                    // show message
                    Toast.makeText(getApplicationContext(),"Nie działą",Toast.LENGTH_SHORT).show();
                    //showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("Bmi :"+ res.getString(1)+"\n");
                    buffer.append("Name :"+ res.getString(2)+"\n");
                    buffer.append("Surname :"+ res.getString(3)+"\n\n");

                }

                // Show all data
                Log.i("Data",buffer.toString());
            }
        });

    }
}

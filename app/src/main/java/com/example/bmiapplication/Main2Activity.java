package com.example.bmiapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmiapplication.Model.BMIRoomDatabase.Bmi;
import com.example.bmiapplication.Model.BMIRoomDatabase.BmiRepository;
import com.example.bmiapplication.Model.Database.BmiDatabase;


public class Main2Activity extends AppCompatActivity {

    TextView textView;
    Button btnConfirm;
    Button btnListView;
    EditText inputName;
    EditText inputSurname;
    String name;
    String surname;
    String strBmi;
    float fBmi;
    BmiDatabase bmiDatabase;
    BmiRepository bmiRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bmiRepository = new BmiRepository(getApplication());
        bmiDatabase = new BmiDatabase(this);
        textView=findViewById(R.id.TextViewCalculatedBmi);
        final Intent intent = getIntent();
        strBmi=intent.getStringExtra("bmi");
        textView.setText(strBmi);
        textView.setTextColor(intent.getIntExtra("color",getColor(R.color.colorBlue)));
        inputName=findViewById(R.id.NameEdit);
        inputSurname=findViewById(R.id.SurnameEdit);
        btnConfirm=findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name =inputName.getText().toString();
                surname = inputSurname.getText().toString();
                fBmi=Float.parseFloat(strBmi);
                //bmiDatabase.insertBmi(fBmi,name,surname);
                bmiRepository.insert(new Bmi(name,surname,fBmi));
                Toast.makeText(getApplicationContext(),"Poprawnie zapisano",Toast.LENGTH_SHORT).show();
            }
        });
        btnListView=findViewById(R.id.btnListView);
        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentList = new Intent(Main2Activity.this, ListViewActivity.class);
                startActivity(intentList);
            }
        });
    }

}

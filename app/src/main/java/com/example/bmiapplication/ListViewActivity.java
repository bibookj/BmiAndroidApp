package com.example.bmiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bmiapplication.Model.BMIRoomDatabase.Bmi;
import com.example.bmiapplication.Model.BMIRoomDatabase.BmiRepository;
import com.example.bmiapplication.Model.Database.BmiDatabase;
import com.example.bmiapplication.Model.Database.BmiItem;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

//    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
//            "WebOS","Ubuntu","Windows7","Max OS X"};
    BmiDatabase bmiDatabase;
    BmiRepository bmiRepository;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        bmiRepository = new BmiRepository(getApplication());
        bmiDatabase = new BmiDatabase(this);
        Cursor res = bmiDatabase.getAllData();
        if(res.getCount() == 0) {
            // show message
            Toast.makeText(getApplicationContext(),"Nie działą",Toast.LENGTH_SHORT).show();
            //showMessage("Error","Nothing found");
            return;
        }

        ArrayList<BmiItem> arrayList = new ArrayList<BmiItem>();
        List<Bmi> list = bmiRepository.getmAllBmis();
//        while (res.moveToNext()) {
//            arrayList.add(new BmiItem(res.getString(2),res.getString(3),res.getFloat(1)));
//
//        }
        for (Bmi bmi:list) {
            arrayList.add(new BmiItem(bmi.getName(),bmi.getSurname(),bmi.getBmi()));
        }

        ArrayAdapter adapter = new BmiItemAdapter(this, arrayList );

        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);
    }
}

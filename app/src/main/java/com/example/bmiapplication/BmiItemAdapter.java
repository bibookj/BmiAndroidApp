package com.example.bmiapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bmiapplication.Model.Database.BmiItem;

import java.util.ArrayList;
import java.util.List;

public class BmiItemAdapter extends ArrayAdapter<BmiItem> {

    private Context mContext;
    private List<BmiItem> bmiList = new ArrayList<>();

    public BmiItemAdapter(@NonNull Context context, ArrayList<BmiItem> list) {
        super(context, 0 , list);
        mContext = context;
        bmiList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.adapter_view_layout,parent,false);

        BmiItem currentBmiItem = bmiList.get(position);


        TextView name = (TextView) listItem.findViewById(R.id.textViewName);
        name.setText(currentBmiItem.getName());

        TextView surname = (TextView) listItem.findViewById(R.id.textViewSurname);
        surname.setText(currentBmiItem.getSurname());

        TextView bmi = (TextView) listItem.findViewById(R.id.textViewBmi);
        bmi.setText(Float.toString(currentBmiItem.getBmi()));

        return listItem;
    }

}

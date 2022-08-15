package com.example.demau1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NgoVanKhai_Adapter extends BaseAdapter {


    Activity activity;
    ArrayList<Contact_NgoVanKhai> data;
    ArrayList<Contact_NgoVanKhai> dataBackup;
    LayoutInflater inflater;

    public NgoVanKhai_Adapter(Activity activity, ArrayList<Contact_NgoVanKhai> data) {
        this.activity = activity;
        this.data = data;
        this.inflater =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null){
            v = inflater.inflate(R.layout.activity_ngo_van_khai_adapter, null);
            TextView txtId =v.findViewById(R.id.txtId);

            txtId.setText("" +data.get(position).getId());
            TextView txtName = v.findViewById(R.id.txtName);
            txtName.setText(data.get(position).getName());
            TextView txtPhone = v.findViewById(R.id.txtPhone);
            txtPhone.setText(data.get(position).getPhone());

        }
        return v;
    }
}
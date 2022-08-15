package com.example.baithi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NgoVanKhai_Adapter extends BaseAdapter {


    Activity activity;
    ArrayList<Vetau> data;
    ArrayList<Vetau> dataBackup;
    LayoutInflater inflater;

    public NgoVanKhai_Adapter(Activity activity, ArrayList<Vetau> data) {
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
            TextView txtTotal =v.findViewById(R.id.txtTotal);

            txtTotal.setText("" +data.get(position).getTotal());
            TextView txtStation = v.findViewById(R.id.txtStation);
            txtStation.setText(data.get(position).getStart() + " -> " + data.get(position).getFinish());
            TextView txtType = v.findViewById(R.id.txtType);
            txtType.setText(data.get(position).isRevert()?"Khứ hồi" : "Một chiều");

        }
        return v;
    }
}
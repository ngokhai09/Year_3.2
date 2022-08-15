package com.example.baitap2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<Item> data;
    LayoutInflater inflater;

    public MyAdapter(Activity activity, ArrayList<Item> data) {
        this.activity = activity;
        this.data = data;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    //lay gia tri cua phan tu co index = i
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    // lay id cua phan tu co index = i
    public long getItemId(int i) {
        return data.get(i).getId();
    }

    @Override
    //lay view
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = inflater.inflate(R.layout.data_item, null);

            TextView txtName = v.findViewById(R.id.txtName);
            txtName.setText(data.get(i).getName());

            TextView txtCongSuat = v.findViewById(R.id.txtCongSuat);
            txtCongSuat.setText(data.get(i).getDescription());
            Switch swStatus = v.findViewById(R.id.swStatus);
            swStatus.setChecked(data.get(i).getStatus() == 1);
//            ImageView img = v.findViewById(R.id.txt_img);

            swStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    data.get(i).setStatus(b ? 1 : 0);
                }
            });
        }
        return v;
    }

}

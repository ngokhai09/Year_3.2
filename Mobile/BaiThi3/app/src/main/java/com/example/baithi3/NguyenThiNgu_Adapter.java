package com.example.baithi3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NguyenThiNgu_Adapter extends BaseAdapter  {

    Activity activity;
    ArrayList<HoaDon_NguyenThiNgu> data;
    ArrayList<HoaDon_NguyenThiNgu> dataOld;
    LayoutInflater inflater;

    public NguyenThiNgu_Adapter(Activity activity, ArrayList<HoaDon_NguyenThiNgu> data) {
        this.activity = activity;
        this.data = data;
//        this.dataOld = data;
        this.inflater =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getID();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =view;
        if(v == null){
            v = inflater.inflate(R.layout.list_view, null);
            TextView txtName =v.findViewById(R.id.txtName);
            txtName.setText(data.get(i).getName());
            TextView txtSoPhong = v.findViewById(R.id.txtSoPhong);
            txtSoPhong.setText("Phòng: "+data.get(i).getSoPhong());
            TextView txtTongTien =v.findViewById(R.id.txtTongTiem);
            txtTongTien.setText(""+data.get(i).tongTien());
        }
        return v;
    }
}

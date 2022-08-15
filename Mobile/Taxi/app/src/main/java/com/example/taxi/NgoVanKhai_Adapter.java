package com.example.taxi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class NgoVanKhai_Adapter extends BaseAdapter implements Filterable {

    Activity activity;
    ArrayList<Taxi> data;
    ArrayList<Taxi> dataBackup;
    LayoutInflater inflater;

    public NgoVanKhai_Adapter(Activity activity, ArrayList<Taxi> data) {
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

            TextView txtNumber = v.findViewById(R.id.txtNumber);
            txtNumber.setText(data.get(position).getNumber());
            TextView txtRoad = v.findViewById(R.id.txtRoad);
            txtRoad.setText("" +data.get(position).getRoad());
            TextView txtTotal = v.findViewById(R.id.txtTotal);
            txtTotal.setText(""+ data.get(position).getTotal());

        }
        return v;
    }
    @Override
    public Filter getFilter() {
        Filter f = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults fr = new FilterResults();
                if(dataBackup == null){
                    dataBackup = new ArrayList<>(data);
                }
                if(charSequence == null || charSequence.length() == 0){
                    fr.count = dataBackup.size();
                    fr.values = dataBackup;
                }else{
                    try{
                        int total = Integer.parseInt(charSequence.toString());
                        ArrayList<Taxi> newData = new ArrayList<>();
                        for(Taxi u: dataBackup){
                            if(total < u.getTotal()){
                                newData.add(u);
                            }}
                            fr.count = newData.size();
                            fr.values = newData;

                    }catch (NumberFormatException ignored){

                    }

                }
                return fr;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                data = new ArrayList<Taxi>();
                ArrayList<Taxi> tmp = (ArrayList<Taxi>) filterResults.values;
                data.addAll(tmp);
                notifyDataSetChanged();
            }
        };
        return f;
    }

}
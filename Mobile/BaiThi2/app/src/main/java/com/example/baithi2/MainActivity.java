package com.example.baithi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    SearchView editSearch;
    ListView listView;
    ArrayList<HoaDon_3107> arrayList ;
    Adapter_De02 adapter_de02;

    Sqlite_De02 mysql = new Sqlite_De02(this, "HoaDon_3107", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSearch = findViewById(R.id.editSearch);
        listView = findViewById(R.id.listView);

//        mysql.addContact(new HoaDon_3107("Nguyễn Thị Ngũ", 405, 500000, 5));
//        mysql.addContact(new HoaDon_3107("Lê Hải Hà", 501, 23000, 100));
//        mysql.addContact(new HoaDon_3107("Lê Đình Đức", 754, 21000, 100));
//        mysql.addContact(new HoaDon_3107("Mai Văn Đức", 405, 12500, 100));
//        mysql.addContact(new HoaDon_3107("Hà Thị Thu", 417, 12500, 100));
//        mysql.addContact(new HoaDon_3107("Mạc Văn Minh", 802, 10500, 100));

        arrayList = (ArrayList<HoaDon_3107>) mysql.getAllContact();
       Collections.sort(arrayList);

        adapter_de02 = new Adapter_De02(this, arrayList);
        listView.setAdapter(adapter_de02);

        editSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                adapter_de02.getFilter().filter(s);
//                arrayList = adapter_de02.data;
//                adapter_de02.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter_de02.getFilter().filter(s);

                return false;
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int count = 0;
                int money = arrayList.get(i).tongTien();
                for (HoaDon_3107 x: arrayList ) {
                    if(x.tongTien() > money){
                        count++;
                    }
                }
                Toast.makeText(MainActivity.this, arrayList.get(i).toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,"Số lượng hóa đơn: " + count, Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
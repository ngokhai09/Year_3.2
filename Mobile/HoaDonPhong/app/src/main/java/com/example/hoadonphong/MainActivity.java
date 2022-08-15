package com.example.hoadonphong;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    Button btnAdd;
    ArrayList<HoaDon_NgoVanKhai> arrayList;
    NgoVanKhai_Adapter adapter;
    int Pos = -1;
    NgoVanKhai_DB sqlite = new NgoVanKhai_DB(this, "NgoVanKhai_DB", null, 1);
    AlertDialog.Builder dlgAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listview);
        btnAdd = findViewById(R.id.btnAdd);
//        registerForContextMenu(listView);


//        sqlite.addContact(new HoaDon_NgoVanKhai("Nam", 404, 100, 1));
//        sqlite.addContact(new HoaDon_NgoVanKhai("Hữu Thắng", 402, 150, 10));
//        sqlite.addContact(new HoaDon_NgoVanKhai("Toàn", 405, 100, 7));
//        sqlite.addContact(new HoaDon_NgoVanKhai("Ngô Văn Khải", 401,50,15));
//        sqlite.addContact(new HoaDon_NgoVanKhai("Minh Hiếu", 302, 20, 9));
//        sqlite.addContact(new HoaDon_NgoVanKhai("Hoàng Anh", 301,100,6));


        arrayList = sqlite.getAllContact();
        Collections.sort(arrayList);
        adapter = new NgoVanKhai_Adapter(this, arrayList);
        listView.setAdapter(adapter);
        dlgAlert  = new AlertDialog.Builder(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivityForResult(intent, 100);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int cnt = 0;
                for(HoaDon_NgoVanKhai tmp : arrayList){
                    if(tmp.getTotal() > arrayList.get(position).getTotal() ){
                        cnt++;
                    }
                }
                Toast.makeText(MainActivity.this, arrayList.get(position).getName() + " - " + cnt, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == 200) {
            Bundle bundle = data.getExtras();
            HoaDon_NgoVanKhai contact_ngoVanKhai = (HoaDon_NgoVanKhai) bundle.getSerializable("result");
            sqlite.addContact(contact_ngoVanKhai);
            arrayList = sqlite.getAllContact();
            Collections.sort(arrayList);
            adapter = new NgoVanKhai_Adapter(MainActivity.this, arrayList);
            listView.setAdapter(adapter);
        }
    }
}
package com.example.baithi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    Button btnAdd;
    ArrayList<Vetau> arrayList;
    NgoVanKhai_Adapter adapter;
    int Pos = -1;
    NgoVanKhai_Sqlite sqlite = new NgoVanKhai_Sqlite(this, "NgoVanKhai_Sqlite", null, 1);
    AlertDialog.Builder dlgAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listview);
        btnAdd = findViewById(R.id.btnAdd);
        registerForContextMenu(listView);


        sqlite.addContact(new Vetau( "Hà Nội", "Nam Định", 200f, true));
        sqlite.addContact(new Vetau("Hà Nội", "Bắc Giang", 150f, false));
        sqlite.addContact(new Vetau( "Hà Nội", "Ba Vì", 150f, true));
        sqlite.addContact(new Vetau( "Bắc Giang", "Hà Nội", 200f, false));
        sqlite.addContact(new Vetau( "Ninh Bình", "Hà Nội", 105.601f, false));
        sqlite.addContact(new Vetau( "Nam Định", "Ba Vì", 190f, false));



        arrayList = sqlite.getAllContact();
        Collections.sort(arrayList);
        adapter = new NgoVanKhai_Adapter(this, arrayList);
        listView.setAdapter(adapter);
        dlgAlert  = new AlertDialog.Builder(this);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Pos = position;
                return false;
            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit:
                break;
            case R.id.delete:
                String finish = arrayList.get(Pos).getFinish();
                float arg = 0;
                int cnt = 0;
                for(Vetau vetau : arrayList){
                    if(vetau.getFinish().equals(finish)){
                        arg += vetau.getTotal();
                        cnt++;
                    }
                }
                dlgAlert.setMessage("Bạn có chắc chắn xóa không?\nGiá trị trung bình: " + (arg/cnt))
                        .setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                for(Vetau vetau : arrayList){
                                    if(vetau.getFinish().equals(finish)){
                                        sqlite.deleteContact(vetau.getId());
                                    }
                                }
                                sqlite.deleteContact(arrayList.get(Pos).getId());
                                arrayList = sqlite.getAllContact();
                                Collections.sort(arrayList);
                                adapter = new NgoVanKhai_Adapter(MainActivity.this, arrayList);
                                listView.setAdapter(adapter);
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = dlgAlert.create();
                alert.show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
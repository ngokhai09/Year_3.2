package com.example.taxi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    ArrayList<Taxi> arrayList;
    NgoVanKhai_Adapter adapter;
    int Pos = -1;
    AlertDialog.Builder dlgAlert;
    Sqlite_2209 sqlite = new Sqlite_2209(this, "Sqlite_2209", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listview);
        btnAdd = findViewById(R.id.btnAdd);
        registerForContextMenu(listView);



//        sqlite.addContact(new Taxi("30k-2363", 13, 100, 1));
//        sqlite.addContact(new Taxi("Hữu Thắng", 402, 150, 10));
//        sqlite.addContact(new Taxi("Toàn", 405, 100, 7));
//        sqlite.addContact(new Taxi("Ngô Văn Khải", 401,50,15));
//        sqlite.addContact(new Taxi("Minh Hiếu", 302, 20, 9));
//        sqlite.addContact(new Taxi("Hoàng Anh", 301,100,6));


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
                Intent intent = new Intent(MainActivity.this, EditItem.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("edit", arrayList.get(Pos));
                intent.putExtras(bundle);
                startActivityForResult(intent, 101);
                break;
            case R.id.delete:
                dlgAlert.setMessage("Bạn có chắc chắn xóa không?")
                        .setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                sqlite.deleteContact(arrayList.get(Pos).getId());
                                arrayList.remove(Pos);
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == 101 && resultCode == 201){
            Bundle bundle = data.getExtras();
            Taxi taxi = (Taxi) bundle.getSerializable("result");
            taxi.setId(arrayList.get(Pos).getId());
            sqlite.updateContact(arrayList.get(Pos).getId(), taxi);
            arrayList = sqlite.getAllContact();
            Collections.sort(arrayList);
            adapter = new NgoVanKhai_Adapter(MainActivity.this, arrayList);
            listView.setAdapter(adapter);
        }
    }
}
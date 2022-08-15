package com.example.deuyen;

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
    ArrayList<Contact_NgoVanKhai> arrayList;
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


//        sqlite.addContact(new Contact_NgoVanKhai("SBD01", "Ngô Văn Khải", 8, 10, 9));
//        sqlite.addContact(new Contact_NgoVanKhai("SBD02", "Nguyễn Thị Ngũ", 10, 10, 10));
//        sqlite.addContact(new Contact_NgoVanKhai("SBD03", "Mạc Văn Minh", 7, 8, 9));
//        sqlite.addContact(new Contact_NgoVanKhai("SBD04", "Vũ Trường An", 8, 7, 8));
//        sqlite.addContact(new Contact_NgoVanKhai("SBD05", "Lê Hải Hà", 8, 8, 7));
//        sqlite.addContact(new Contact_NgoVanKhai("SBD06", "Ngô Văn Thái", 10, 9, 9));


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
            Contact_NgoVanKhai contact_ngoVanKhai = (Contact_NgoVanKhai) bundle.getSerializable("result");
            sqlite.updateContact(arrayList.get(Pos).getId(), contact_ngoVanKhai);
            arrayList = sqlite.getAllContact();
            Collections.sort(arrayList);
            adapter = new NgoVanKhai_Adapter(MainActivity.this, arrayList);
            listView.setAdapter(adapter);
        }
    }
}
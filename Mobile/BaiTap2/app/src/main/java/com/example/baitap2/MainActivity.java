package com.example.baitap2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> lstItem;
    MyAdapter lstAdapter;
    ListView listView;
    Button btnThem, btnXoa;
    EditText txtTB;
    AlertDialog.Builder checkItem;
    MyDB mysqlitedb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtTB = findViewById(R.id.txtThietBi);
        listView = findViewById(R.id.list_Item);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        checkItem = new AlertDialog.Builder(this);

        mysqlitedb = new MyDB(this, "ItemDB", null, 1);
//        lstItem = new ArrayList<>();
//        lstItem.add(new Item(1, "Quạt trần", "Công suất 500W", "Goodbye", 1));
//        lstItem.add(new Item(2, "Bóng lét", "Công suất 100W", "Hi", 1));
//        mysqlitedb.addItem(new Item(1, "Quạt trần", "Công suất 500W", "Goodbye", 1));
//        mysqlitedb.addItem(new Item(2, "Bóng đèn dây tóc", "Công suất 200W", "Chao", 1));
        lstItem = mysqlitedb.getAllItem();
        lstAdapter = new MyAdapter(this, lstItem);
        listView.setAdapter(lstAdapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 100);
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                checkItem.setMessage("Bạn có chắc chắn xóa không?")
                        .setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
//                                for (int i = 0; i < lstItem.size(); i++) {
//                                    if (lstItem.get(i).getStatus() == 0) {
//                                        mysqlitedb.deleteItem(lstItem.get(i).getId());
//                                        lstItem.remove(lstItem.get(i));
//                                        i--;
//                                    }
//                                }
////                                lstAdapter.notifyDataSetChanged();
//                                listView.setAdapter(lstAdapter);
                                Toast.makeText(MainActivity.this, id, Toast.LENGTH_LONG).show();
                            }

                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = checkItem.create();
                alert.show();
                return true;
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkItem.setMessage("Bạn có chắc chắn xóa không?")
                        .setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
//                                for (int i = 0; i < lstItem.size(); i++) {
//                                    if (lstItem.get(i).getStatus() == 0) {
//                                        mysqlitedb.deleteItem(lstItem.get(i).getId());
//                                        lstItem.remove(lstItem.get(i));
//                                        i--;
//                                    }
//                                }
////                                lstAdapter.notifyDataSetChanged();
//                                listView.setAdapter(lstAdapter);
                            }

                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = checkItem.create();
                alert.show();

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        Item item = (Item) bundle.getSerializable("item");
        if(requestCode == 100 && resultCode == 200) {
            mysqlitedb.addItem(item);
            lstItem.add(item);
        }
        lstAdapter.notifyDataSetChanged();
        listView.setAdapter(lstAdapter);
    }

}

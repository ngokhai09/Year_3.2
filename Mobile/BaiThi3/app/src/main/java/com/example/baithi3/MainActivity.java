package com.example.baithi3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThem;
    ListView listView;
    ArrayList<HoaDon_NguyenThiNgu> arrayList ;
    NguyenThiNgu_Adapter adapter_Ngu;

    NguyenThiNgu_DB mysql = new NguyenThiNgu_DB(this, "HoaDon_NguyenThiNgu", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThem = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);


        mysql.addContact(new HoaDon_NguyenThiNgu("Nguyễn Thị Ngũ", 405, 500000, 5));
        mysql.addContact(new HoaDon_NguyenThiNgu("Lê Hải Hà", 501, 23000, 100));
        mysql.addContact(new HoaDon_NguyenThiNgu("Lê Đình Đức", 754, 21000, 100));
        mysql.addContact(new HoaDon_NguyenThiNgu("Ngô Văn Khải", 244, 20000, 100));
        mysql.addContact(new HoaDon_NguyenThiNgu("Mai Văn Đức", 405, 12500, 100));
        mysql.addContact(new HoaDon_NguyenThiNgu("Hà Thị Thu", 417, 12500, 100));
//        mysql.addContact(new HoaDon_NguyenThiNgu("Mạc Văn Minh", 802, 10500, 100));

        arrayList = mysql.getAllContact();

        adapter_Ngu = new NguyenThiNgu_Adapter(this, arrayList);
        listView.setAdapter(adapter_Ngu);

        for(HoaDon_NguyenThiNgu x: arrayList){
            Toast.makeText(MainActivity.this, x.toString(), Toast.LENGTH_LONG).show();
        }

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivityForResult(intent, 150);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        HoaDon_NguyenThiNgu item = (HoaDon_NguyenThiNgu) bundle.getSerializable("result");

        if(requestCode ==150 && resultCode == 250) {

            mysql.addContact(item);
            arrayList.clear();
            arrayList = mysql.getAllContact();
            adapter_Ngu = new NguyenThiNgu_Adapter(MainActivity.this, arrayList);
            listView.setAdapter(adapter_Ngu);

        }
    }
}
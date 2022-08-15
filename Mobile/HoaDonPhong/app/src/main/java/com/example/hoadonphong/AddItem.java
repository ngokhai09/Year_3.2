package com.example.hoadonphong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddItem extends AppCompatActivity {
    Button btnAdd, btnBack;
    EditText txtRoom, txtName, txtPhone, txtPrice, txtDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        btnAdd = findViewById(R.id.btnAddItem);
        btnBack = findViewById(R.id.btnBack);
        txtName = findViewById(R.id.editName);
        txtRoom = findViewById(R.id.editRoom);
        txtPrice = findViewById(R.id.editPrice);
        txtDay = findViewById(R.id.editDay);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                HoaDon_NgoVanKhai hoaDon_ngoVanKhai = new HoaDon_NgoVanKhai(txtName.getText().toString(), Integer.parseInt(txtRoom.getText().toString()),Integer.parseInt(txtPrice.getText().toString()),Integer.parseInt(txtDay.getText().toString()));
                bundle.putSerializable("result", hoaDon_ngoVanKhai);
                intent.putExtras(bundle);
                setResult(200, intent);
                finish();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(201);
                finish();
            }
        });
    }
}
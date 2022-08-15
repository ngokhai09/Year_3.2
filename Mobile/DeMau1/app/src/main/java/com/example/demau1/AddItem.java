package com.example.demau1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {
    Button btnAdd, btnBack;
    EditText txtId, txtName, txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        btnAdd = findViewById(R.id.btnAddItem);
        btnBack = findViewById(R.id.btnBack);
        txtId = findViewById(R.id.editId);
        txtName = findViewById(R.id.editName);
        txtPhone = findViewById(R.id.editPhone);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                Contact_NgoVanKhai contact_ngoVanKhai = new Contact_NgoVanKhai(Integer.parseInt(txtId.getText().toString()), txtName.getText().toString(), txtPhone.getText().toString());
                bundle.putSerializable("result", contact_ngoVanKhai);
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
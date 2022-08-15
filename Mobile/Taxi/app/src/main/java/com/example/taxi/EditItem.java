package com.example.taxi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditItem extends AppCompatActivity {
    Button btnEdit, btnBack;
    EditText txtNumber, txtRoad, txtPrice, txtDiscount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        btnEdit = findViewById(R.id.btnEditItem);
        btnBack = findViewById(R.id.btnBack1);
        txtNumber = findViewById(R.id.editNumber);
        txtRoad = findViewById(R.id.editRoad);
        txtPrice = findViewById(R.id.editPrice);
        txtDiscount = findViewById(R.id.editDiscount);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {

            Taxi data = (Taxi) bundle.getSerializable("edit");
            txtNumber.setText(data.getNumber());
            txtRoad.setText(""+data.getRoad());
            txtPrice.setText(""+data.getPrice());
            txtDiscount.setText(""+data.getDiscount());
        }
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                Taxi contact_ngoVanKhai = new Taxi(txtNumber.getText().toString(), Float.parseFloat(txtRoad.getText().toString()), Float.parseFloat(txtPrice.getText().toString()), Float.parseFloat(txtDiscount.getText().toString()));
                bundle.putSerializable("result", contact_ngoVanKhai);
                intent.putExtras(bundle);
                setResult(201, intent);
                finish();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(202);
                finish();
            }
        });
    }
}
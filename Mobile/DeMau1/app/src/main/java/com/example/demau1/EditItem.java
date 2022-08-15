package com.example.demau1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItem extends AppCompatActivity {
    Button btnEdit, btnBack;
    EditText txtId, txtName, txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        btnEdit = findViewById(R.id.btnEditItem);
        btnBack = findViewById(R.id.btnBack1);
        txtId = findViewById(R.id.editId1);
        txtName = findViewById(R.id.editName1);
        txtPhone = findViewById(R.id.editPhone1);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {

            Contact_NgoVanKhai data = (Contact_NgoVanKhai) bundle.getSerializable("edit");
            txtId.setText("" +data.getId());
            txtName.setText(data.getName());
            txtPhone.setText(data.getPhone());
        }
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                Contact_NgoVanKhai contact_ngoVanKhai = new Contact_NgoVanKhai(Integer.parseInt(txtId.getText().toString()), txtName.getText().toString(), txtPhone.getText().toString());
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
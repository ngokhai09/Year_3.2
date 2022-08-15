package com.example.deuyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditItem extends AppCompatActivity {
    Button btnEdit, btnBack;
    EditText txtId, txtName, txtMath, txtPhysic, txtChemistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        btnEdit = findViewById(R.id.btnEditItem);
        btnBack = findViewById(R.id.btnBack1);
        txtId = findViewById(R.id.editId1);
        txtName = findViewById(R.id.editName1);
        txtMath = findViewById(R.id.editMath);
        txtPhysic = findViewById(R.id.editPhysic);
        txtChemistry = findViewById(R.id.editChemistry);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {

            Contact_NgoVanKhai data = (Contact_NgoVanKhai) bundle.getSerializable("edit");
            txtId.setText(data.getId());
            txtName.setText(data.getName());
            txtMath.setText("" +data.getMath());
            txtPhysic.setText("" +data.getPhysic());
            txtChemistry.setText("" +data.getChemistry());
        }
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                Contact_NgoVanKhai contact_ngoVanKhai =
                        new Contact_NgoVanKhai(txtId.getText().toString(),
                                txtName.getText().toString(),
                                Float.parseFloat(txtMath.getText().toString()),
                                Float.parseFloat(txtPhysic.getText().toString()),
                                Float.parseFloat(txtChemistry.getText().toString()));
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
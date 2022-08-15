package com.example.baitap2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.io.Serializable;

public class AddActivity extends AppCompatActivity {
    Button btnAdd;
    EditText txt_TB;
    EditText txt_CS;
    EditText txt_Img;
    Switch sw_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btnAdd = findViewById(R.id.btnAdd);
        txt_TB = findViewById(R.id.txt_TB);
        txt_CS = findViewById(R.id.txt_CS);
        txt_Img = findViewById(R.id.txt_img);
        sw_status = findViewById(R.id.sw_status);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validate = Validate(txt_TB.getText().toString(), txt_CS.getText().toString());
                if (validate.equals("")) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();

                    Item item1 = new Item(5,
                            txt_TB.getText().toString(), txt_CS.getText().toString(), txt_Img.getText().toString(), sw_status.isChecked()? 1: 0);
                    bundle.putSerializable("item", item1);
                    intent.putExtras(bundle);
                    setResult(200, intent);
                    finish();
                } else {
                    Toast.makeText(AddActivity.this, validate, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private String Validate(String name, String congsuat) {
        if (name.equals("")) {
            return "Chưa nhập tên thiết bị";
        }
        if (congsuat.equals("")) {
            return "Chưa nhập công suất";
        }
        return "";
    }


}
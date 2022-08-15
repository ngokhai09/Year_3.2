package com.example.baithi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddItem extends AppCompatActivity {

    TextView editName, editSoPhong, editDonGia, editSoNgay;
    Button btnThem, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        editName = findViewById(R.id.editName);
        editSoPhong = findViewById(R.id.editSoPhong);
        editDonGia = findViewById(R.id.editDonGia);
        editSoNgay = findViewById(R.id.editSoNgay);

        btnThem = findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.btnThoat);

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddItem.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validate = isValidate(editName.getText().toString(), editSoPhong.getText().toString(),
                        editDonGia.getText().toString(), editSoNgay.getText().toString());
                if(validate.equals("")){
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();

                    HoaDon_NguyenThiNgu item = new HoaDon_NguyenThiNgu( editName.getText().toString(),
                            Integer.parseInt(editSoPhong.getText().toString()), Integer.parseInt(editDonGia.getText().toString()),
                            Integer.parseInt(editSoNgay.getText().toString()));

                    bundle.putSerializable("result", item);
                    intent.putExtras(bundle);
                    setResult(250, intent);
                    finish();
                }
                else {
                    Toast.makeText(AddItem.this, validate, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private String isValidate(String name, String soPhong, String donGia, String soNgay){
        if(name.equals("")) return "Tên không được để trống";
        if(soPhong.equals("")) return "Số phòng không được để trống";
        if(donGia.equals("")) return "Đơn giá không được để trống";
        if(soNgay.equals("")) return "Số ngày không được để trống";
        return "";
    }
}
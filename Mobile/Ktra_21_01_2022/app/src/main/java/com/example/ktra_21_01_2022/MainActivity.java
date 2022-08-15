package com.example.ktra_21_01_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtName;
    EditText txtPhone;
    RadioButton rdNam;
    RadioButton rdNu;
    Spinner spQue;
    Button btnAdd;
    ListView listView;
    ArrayAdapter<Person> listAdapter;
    ArrayList<Person> arrayList;
    ArrayAdapter<String> queAdapter;
    ArrayList<String> arrQue;
    String que;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spQue = findViewById(R.id.spQue);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);
        btnAdd = findViewById(R.id.btnAdd);
        arrayList = new ArrayList<>();
        arrayList.add(new Person("Ngô Văn Khải", "0394229171", "Hà Nội", "Nam"));
        arrayList.add(new Person("Mai Văn Chiến", "0963113494", "Hà Nam", "Nam"));
        listAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        listView = findViewById(R.id.List);
        listView.setAdapter(listAdapter);
        arrQue = new ArrayList<>();
        arrQue.add("Quê quán");
        arrQue.add("Hà Nội");
        arrQue.add("Nam Định");
        arrQue.add("Hải Phòng");
        arrQue.add("Bình Định");
        arrQue.add("Thái Bình");
        queAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrQue);
        spQue.setAdapter(queAdapter);

        spQue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                que = spQue.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validate = Validate(txtName.getText().toString(), txtPhone.getText().toString(), rdNam, rdNu, que);
                if( validate == ""){
                    arrayList.add(new Person(txtName.getText().toString(), txtPhone.getText().toString(), rdNam.isChecked()?"Nam":"Nữ", que)) ;
                    listAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(MainActivity.this, validate, Toast.LENGTH_LONG).show();
                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    public String Validate(String name, String phone, RadioButton rdNam, RadioButton rdNu, String Que){
        if(name.equals("")){
            return "Name is required";
        }
        if(phone.equals("")){
            return "Phone is required";
        }
        try {
            int d = Integer.parseInt(phone);
        }catch (NumberFormatException e){
            return "Phone must is number";
        }
        if(!rdNam.isChecked() && !rdNu.isChecked()){
            return "You must choose your gender";
        }
        if(Que.equals("Quê quán")){
            return "You must choose your country";
        }
        return "";
    }

}
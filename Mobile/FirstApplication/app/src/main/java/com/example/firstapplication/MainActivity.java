package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Tham chiếu tới view trên giao diện
    // Tham chiếu tới view nào thì tạo đội tượng thành phần thuộc lớp đó
    Button btnSubmit;
    TextView textView;
    CheckBox checkBox;
    EditText editText;
    // Khai báo đối tượng ListView để tham chiếu tới ListView trên giao diện
    ListView listContact;
    // Khai báo Adapter để binding dữ liệu cho list view
    // Có nhiều loại Adapter, đặc điểm chung là kế thừa từ BaseAdapter
    // Ví dụ dùng ArrayAdapter để hiển thị các phần tử có dạng chuổi bằng TextView
    ArrayAdapter<String> lisContactAdapter;
    // Khai báo ArrayList<String> là nguồn dữ liệu cho ListViewAdapter
    ArrayList<String> arrContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(this, "onCreate running", Toast.LENGTH_LONG).show();
        // Tham chiếu tới button trên giao diện
        btnSubmit = findViewById(R.id.btnClick);
        textView = findViewById(R.id.textView);
        checkBox = findViewById(R.id.cbTest);
        editText = findViewById(R.id.InputTest);
        // Có thể thay đổi/ tùy biến các thuộc tính của view đã tham chiếu
        // Sử dụng get/set
        //Có thẻ bắt sự kiện
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("I'm android programer");
                if(!checkBox.isChecked()){
                    textView.setText("You must check the check box");
                }else{
                    textView.setText("Hello there");
                }
                String name = editText.getText().toString();
                arrContact.add(name);
                lisContactAdapter.notifyDataSetChanged();
//                Toast.makeText(MainActivity.this, "click submit", Toast.LENGTH_LONG).show();
            }
        });
        // Tạo dữ liệu cho ListViewAdapter
        arrContact = new ArrayList<>();
        arrContact.add("John");
        arrContact.add("Cara");
        arrContact.add("AShd");
        // Tạo đối tượng ListViewAdapter
        // Tham số 1: Context - Lớp cha của lớp activity lưu ngữ cảnh
        // Tham số 2: Layout của ListView
        // Tham số 3: Dữ liệu
        lisContactAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrContact);
        listContact = findViewById(R.id.listView);
        listContact.setAdapter(lisContactAdapter);
        // Bắt sự kiện cho ListView
        listContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrContact.get(i).toString(),Toast.LENGTH_LONG).show();
            }
        });
        listContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrContact.get(i).toString(),Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart running", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Toast.makeText(this, "onResume running", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop running", Toast.LENGTH_SHORT).show();
    }

    public void doClick(View v){
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);

    }
}
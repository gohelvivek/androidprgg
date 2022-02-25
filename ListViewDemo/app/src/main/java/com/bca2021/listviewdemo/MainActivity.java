package com.bca2021.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextClassifierEvent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText edt;
    Button btn;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.m_lstView);
        edt = findViewById(R.id.m_edt);
        btn = findViewById(R.id.m_btn);
        arrayList = new ArrayList<>();
        //listView.setBackgroundColor(Color.rgb(25,30,58));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "sdsdd", Toast.LENGTH_SHORT).show();
                arrayList.add(edt.getText().toString());
                arrayAdapter = new ArrayAdapter<>(
                        getApplicationContext(),
//                        android.R.layout.simple_list_item_1,
                        R.layout.custom_layout,
                        R.id.c_txt,
                        arrayList);
                listView.setAdapter(arrayAdapter);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View parent, int position, long idPosition) {
                try {
                    String value = adapter.getItemAtPosition(position).toString();
                    Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
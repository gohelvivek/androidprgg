package com.bca2021.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.m_grid);
        gridView.setAdapter(new ImageAdapter(getApplicationContext()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long positionId) {
                String val = adapterView.getItemAtPosition(position).toString();
                if (val=="0")
                {
                    Intent i = new Intent(getApplicationContext(),IndiaActivity2.class);
                    startActivity(i);
                }
            }
        });
    }
}
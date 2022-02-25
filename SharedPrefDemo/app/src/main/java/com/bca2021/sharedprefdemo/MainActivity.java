package com.bca2021.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b_login, b_reg;
    EditText ed_name, ed_pass;

    public void references() {
        b_login = findViewById(R.id.m_b_login);
        b_reg = findViewById(R.id.m_b_reg);
        ed_name = findViewById(R.id.m_e_nm);
        ed_pass = findViewById(R.id.m_e_pd);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        references(); // Your code starts here

        b_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", ed_name.getText().toString());
                editor.putString("pass", ed_pass.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this, "Data Saved Successfully.", Toast.LENGTH_SHORT).show();
            }
        });
        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);
                if (sp.contains("name")) {
                    String user = sp.getString("name", "");
                    String pass = sp.getString("pass", "");
                    if (user.equals(ed_name.getText().toString()) && pass.equals(ed_pass.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Great You'r Welcome.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Sorry this record not found.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "No Records Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
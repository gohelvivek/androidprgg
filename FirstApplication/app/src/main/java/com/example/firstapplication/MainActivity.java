package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edt1, edt2;
    TextView txt_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.m_edt1);
        edt2 = findViewById(R.id.m_edt2);
        btn = findViewById(R.id.m_btn);
        txt_welcome = findViewById(R.id.m_txt_w);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                if (str1.equals("") && str2.equals("")) {
                    Toast.makeText(MainActivity.this, "Strings are empty.", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Intent intent = new Intent(getApplicationContext(), second.class);
                        intent.putExtra("str1",str1);
                        intent.putExtra("str2",str2);
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
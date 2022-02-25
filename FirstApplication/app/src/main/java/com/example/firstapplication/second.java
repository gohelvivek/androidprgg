package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class second extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txt = findViewById(R.id.s_txt);
        txt.setBackgroundColor(Color.rgb(50,65,32));
        Intent intent = getIntent();
        txt.setText("वेलकम" + intent.getStringExtra("str1") + " " + intent.getStringExtra("str2"));
    }
}
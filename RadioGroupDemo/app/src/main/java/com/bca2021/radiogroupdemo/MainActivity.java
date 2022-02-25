package com.bca2021.radiogroupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton img;
    RadioGroup rg;
    RadioButton rb1, rb2, rb3, rb4;

    public void references() {
        img = findViewById(R.id.m_img_btn);
        rg = findViewById(R.id.m_rd_group);
        rb1 = findViewById(R.id.m_rd_1);
        rb2 = findViewById(R.id.m_rd_2);
        rb3 = findViewById(R.id.m_rd_3);
        rb4 = findViewById(R.id.m_rd_4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //All the references of MainLayout
        references();
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        img.setBackgroundColor(Color.rgb(45, 45, 65));
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                if (rb1.isChecked())
                    img.setImageResource(R.drawable.h1);
                else if (rb2.isChecked())
                    img.setImageResource(R.drawable.h2);
                else if (rb3.isChecked())
                    img.setImageResource(R.drawable.h3);
                else if (rb4.isChecked())
                    img.setImageResource(R.drawable.h4);
            }
        });


    }


}
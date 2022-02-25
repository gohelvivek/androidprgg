package com.bca2020.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b_alpha, b_rotate, b_scale, b_translate, b_frame;
    TextView txt;
    Handler handler;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_alpha = findViewById(R.id.b_alpha);
        b_rotate = findViewById(R.id.b_rotate);
        b_scale = findViewById(R.id.b_scale);
        b_translate = findViewById(R.id.b_trans);
        b_frame = findViewById(R.id.b_frame);
        img = findViewById(R.id.imageView);
        txt = findViewById(R.id.textView);

        b_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
                txt.startAnimation(animation);

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha2);
                        txt.startAnimation(animation2);
                    }
                }, 4000);
            }
        });

        b_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                txt.startAnimation(animation);
            }
        });

        b_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
                txt.startAnimation(animation);

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale2);
                        txt.startAnimation(animation2);
                    }
                }, 4000);
            }
        });

        b_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.trans);
                txt.startAnimation(animation);
            }
        });

        b_frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(0);
                img.setBackgroundResource(R.drawable.animation);
                AnimationDrawable anim = (AnimationDrawable) img.getBackground();
                anim.start();
            }
        });


    }
}
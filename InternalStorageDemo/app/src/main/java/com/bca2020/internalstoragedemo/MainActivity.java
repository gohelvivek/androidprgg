package com.bca2020.internalstoragedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    EditText edt;
    Button btn, btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.edt);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edt.getText().toString();
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput("Data", Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                    showMessaage("Insert", "Success");
                } catch (Exception e) {
                    showMessaage("Error", e.getMessage());
                }
            }


        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fis = null;
                StringBuffer buffer = new StringBuffer();
                try {
                    fis = openFileInput("Data");
                    int read1 = -1, end = -1;
                    while ((read1 = fis.read()) != end) {
                        buffer.append((char) read1);
                    }
                } catch (Exception e) {
                    showMessaage("Error", e.getMessage());
                }
                showMessaage("Data", buffer.toString());
            }
        });
    }

    public void showMessaage(String Title, String Message) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(Title);
        dialog.setMessage(Message);
        dialog.setCancelable(true);
        dialog.create();
        dialog.show();
    }
}
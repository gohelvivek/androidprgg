package com.bca2020.externalstoragedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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

                File myfile = new File(getCacheDir(), "Data.txt");
                File myfile1 = new File(getExternalCacheDir(), "Data.txt");
                File myfile2 = new File(getExternalFilesDir("MyApp"), "Data.txt");
                //Permission for below method write external storage
                File myfile3 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Data.txt");
                writeData(myfile, data);
                writeData(myfile1, data);
                writeData(myfile2, data);
                writeData(myfile3, data);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File myfile = new File(getCacheDir(), "Data.txt");
                File myfile1 = new File(getExternalCacheDir(), "Data.txt");
                File myfile2 = new File(getExternalFilesDir("MyApp"), "Data.txt");
                //Permission for below method write external storage
                File myfile3 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Data.txt");

                showMessaage("Return1",readData(myfile));
                showMessaage("Return2",readData(myfile1));
                showMessaage("Return3",readData(myfile2));
                showMessaage("Return4",readData(myfile3));
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

    public void writeData(File filename, String data) {
        try {
            FileOutputStream fos = null;
            fos = new FileOutputStream(filename);
            fos.write(data.getBytes());
            fos.close();
            showMessaage("Insert", "Success");
        } catch (Exception e) {
            showMessaage("Error", e.getMessage());
        }
    }

    public String readData(File filename) {
        FileInputStream fis = null;
        StringBuffer buffer = new StringBuffer();
        try {
            fis = new FileInputStream(filename);
            int read1 = -1, end = -1;
            while ((read1 = fis.read()) != end) {
                buffer.append((char) read1);
            }
        } catch (Exception e) {
            showMessaage("Error", e.getMessage());
        }
        return buffer.toString();
    }

}

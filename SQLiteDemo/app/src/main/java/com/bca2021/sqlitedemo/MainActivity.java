package com.bca2021.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText e_id, e_name, e_age;
    Button b_add, b_edit, b_del, b_view;
    TableLayout tbl;
    SQLite sqLite;


    public void references() {
        e_id = findViewById(R.id.m_e_id);
        e_name = findViewById(R.id.m_e_name);
        e_age = findViewById(R.id.m_e_age);

        b_add = findViewById(R.id.m_b_add);
        b_edit = findViewById(R.id.m_b_edit);
        b_del = findViewById(R.id.m_b_del);
        b_view = findViewById(R.id.m_b_view);

        tbl = findViewById(R.id.tbl);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        references();
        sqLite = new SQLite(this);

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = e_id.getText().toString();
                String name = e_name.getText().toString();
                String age = e_age.getText().toString();
                if (id.equals("") && name.equals("") && age.equals("")) {
                    Toast.makeText(MainActivity.this, "Data is Empty", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean data = sqLite.insertData(id, name, age);
                    if (data == false) {
                        Toast.makeText(MainActivity.this, "Something is wrong in Database.", Toast.LENGTH_SHORT).show();
                    } else {
                        b_view.callOnClick();
                        Toast.makeText(MainActivity.this, "Record Inserted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = e_id.getText().toString();
                String name = e_name.getText().toString();
                String age = e_age.getText().toString();
                if (id.equals("") && name.equals("") && age.equals("")) {
                    Toast.makeText(MainActivity.this, "Data is Empty", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean data = sqLite.updateData(id, name, age);
                    if (data == false) {
                        Toast.makeText(MainActivity.this, "Something is wrong in Database.", Toast.LENGTH_SHORT).show();
                    } else {
                        b_view.callOnClick();
                        Toast.makeText(MainActivity.this, "Record Updated Successfully.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = e_id.getText().toString();
                if (id.equals("")) {
                    Toast.makeText(MainActivity.this, "Data is Empty", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean data = sqLite.delData(id);
                    if (data == false) {
                        Toast.makeText(MainActivity.this, "Something is wrong in Database.", Toast.LENGTH_SHORT).show();
                    } else {
                        b_view.callOnClick();
                        Toast.makeText(MainActivity.this, "Record Deleted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        b_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = sqLite.readData();
                if (data.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No data to fetch.", Toast.LENGTH_SHORT).show();
                } else {
                    tbl.removeAllViews();
                    tbl = findViewById(R.id.tbl);
                    TableRow thr = new TableRow(getApplicationContext());
                    thr.setBackgroundColor(Color.rgb(58,58,56));
                    TextView th1 = new TextView(getApplicationContext());
                    TextView th2 = new TextView(getApplicationContext());
                    TextView th3 = new TextView(getApplicationContext());
                    th1.setPadding(30,30,30,30);
                    th2.setPadding(30,30,30,30);
                    th3.setPadding(30,30,30,30);
                    th1.setText("Id");
                    th2.setText("Name");
                    th3.setText("Age");
                    thr.addView(th1);
                    thr.addView(th2);
                    thr.addView(th3);
                    tbl.addView(thr);
                    while (data.moveToNext()){
                        TableRow tr = new TableRow(getApplicationContext());
                        tr.setBackgroundColor(Color.rgb(150,145,56));
                        TextView tv1 = new TextView(getApplicationContext());
                        TextView tv2 = new TextView(getApplicationContext());
                        TextView tv3 = new TextView(getApplicationContext());
                        tv1.setPadding(30,30,30,30);
                        tv2.setPadding(30,30,30,30);
                        tv3.setPadding(30,30,30,30);
                        tv1.setText(data.getString(0));
                        tv2.setText(data.getString(1));
                        tv3.setText(data.getString(2));
                        tr.addView(tv1);
                        tr.addView(tv2);
                        tr.addView(tv3);
                        tr.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                e_id.setText(tv1.getText());
                                e_name.setText(tv2.getText());
                                e_age.setText(tv3.getText());
                            }
                        });
                        tbl.addView(tr);
                    }

                }
            }
        });



    }
}
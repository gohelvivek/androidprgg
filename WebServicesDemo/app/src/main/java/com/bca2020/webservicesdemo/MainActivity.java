package com.bca2020.webservicesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b_login,b_newUser, b_listUsers;
    EditText e_user, e_pass;
    String data,login, uname, pass;
    BackgroundWorker backgroundWorker;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_login = findViewById(R.id.b_login);
        b_newUser = findViewById(R.id.b_newUser);
        b_listUsers = findViewById(R.id.b_listUsers);
        e_user = findViewById(R.id.e_user);
        e_pass = findViewById(R.id.e_pass);

        context = MainActivity.this;

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = e_user.getText().toString();
                pass = e_pass.getText().toString();
                login = "login";
                backgroundWorker = new BackgroundWorker(context);
                backgroundWorker.execute(login,uname,pass);
            }
        });
        b_newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = e_user.getText().toString();
                pass = e_pass.getText().toString();
                login = "addUser";
                backgroundWorker = new BackgroundWorker(context);
                backgroundWorker.execute(login,uname,pass);
            }
        });
        b_listUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = "listUsers";
                backgroundWorker = new BackgroundWorker(context);
                backgroundWorker.execute(login);
            }
        });
    }
}
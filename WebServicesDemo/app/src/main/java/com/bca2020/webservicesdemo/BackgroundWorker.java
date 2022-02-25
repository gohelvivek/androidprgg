package com.bca2020.webservicesdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

class BackgroundWorker extends AsyncTask<String, Void, String> {

    Context mContext;
    AlertDialog builder;
    String singleParsing = "";
    String dataParsing = "";

    public BackgroundWorker(Context c) {
        mContext = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        builder = new AlertDialog.Builder(mContext).create();
        builder.setTitle("Login Status");
    }

    @Override
    protected String doInBackground(String... members) {

        //All Url's for users table
        String urlData = members[0];
        String loginUrl = "http://192.168.43.80/webservices/login.php";
        String addNewUserUrl = "http://192.168.43.80/webservices/insertData.php";
        String list_Users = "http://192.168.43.80/webservices/listusers.php";
        if (urlData.equals("login")) {

            try {
                //Connection Open
                String name = members[1];
                String pass = members[2];
                URL url = new URL(loginUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);


                //Buffer for sending data
                //http://192.168.43.80/webservices/login.php?username=name&password=name
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                //For Results of sending data
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                return e.getMessage();
            } catch (UnsupportedEncodingException e) {
                return e.getMessage();
            } catch (ProtocolException e) {
                return e.getMessage();
            } catch (IOException e) {
                return e.getMessage();
            }
        } else if (urlData.equals("addUser")) {
            String name = members[1];
            String pass = members[2];
            try {
                //Connection Open
                URL url = new URL(addNewUserUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                //Buffer for sending data
                //http://192.168.43.80/webservices/insertData.php?username=name&password=name
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                //For Results of sending data
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                return e.getMessage();
            } catch (IOException e) {
                return e.getMessage();
            }
        } else if (urlData.equals("listUsers")) {
            try {

                URL url = new URL(list_Users);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                //For Results of sending data
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                //Json Parsing
                JSONArray ja = new JSONArray(result);
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = (JSONObject) ja.get(i);
                    singleParsing = "Name: " + jo.get("username") + "\n" +
                            "Password: " + jo.get("password") + "\n";
                    dataParsing += singleParsing;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return dataParsing;


            } catch (MalformedURLException e) {
                return e.getMessage();
            } catch (IOException e) {
                return e.getMessage();
            } catch (JSONException e) {
                return e.getMessage();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        //This method handles returned results of doInBackground()
        builder.setCancelable(true);
        if (result.equals("Login Successful")) {
//            builder.setMessage("You Are our App User.");
//            builder.show();
            Intent intent = new Intent(mContext,MainActivity2.class);
            mContext.startActivity(intent);
            //You can use shared preference
        } else if (result.equals("Insert Successful")) {
            builder.setMessage(result);
            builder.show();
        } else if (result.equals(this.dataParsing)) {
            builder.setMessage(result);
            builder.show();
        } else {
            builder.setMessage(result);
            builder.show();
        }
    }
}

package com.bca2020.androidtelephonyapidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edt;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.txt);
        btn = findViewById(R.id.call);
        txt = findViewById(R.id.txtview);

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //String deviceID = telephonyManager.getDeviceId();
        String deviceSoftwareVersion = telephonyManager.getDeviceSoftwareVersion();
        String networkOperator = telephonyManager.getNetworkOperator();
        String carrierIdName = telephonyManager.getNetworkOperatorName();
        String country = telephonyManager.getSimOperatorName();

        /* TO Get Details of Your Current Connection*/
        String net = null;
        int netType = telephonyManager.getNetworkType();
        switch (netType) {
            case TelephonyManager.NETWORK_TYPE_GSM:
                net = "2g";
                break;
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                net = "3g";
                break;
            case TelephonyManager.NETWORK_TYPE_LTE:
                net = "4G";
        }

        txt.setText(deviceSoftwareVersion + "\n" + networkOperator + "\n" + carrierIdName + "\n" + country + "\n" + net);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+91" + edt.getText().toString()));
                startActivity(intent);
            }
        });


    }
}
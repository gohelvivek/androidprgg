package com.bca2020.alarmmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    /*
                    DozeMode Jellybean
                    1. Senor stills at 1 one value
                    2. Device Display is off for
                    3. Processor CLocks stays at min. value 700mhz
                    ->When these three conditions matches fot a period 1hour.
                      than doze mode activates.
                     - Sensors are disabled.
                     - Brings Processor clocks to lowest possible value.
                     - It also removes apps from backround and foregound
                     - Memory Management will be cleared.
                    AlarmManager.set(RTC_WAKEUP,)
                    PendingIntent
                    */
                    AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    Intent intent = new Intent(MainActivity.this, AlarmNotiService.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
                    manager.set(AlarmManager.RTC_WAKEUP,3000, pendingIntent);
                    Toast.makeText(MainActivity.this, "This is from Activity", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
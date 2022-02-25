package com.bca2020.alarmmanagerdemo;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

/**
 * Created by Hardik Chavda on 3/26/2021.
 * Freelancer
 * hardikkchavda@gmail.com
 */
public class AlarmNotiService extends BroadcastReceiver {
//    long[] vibrate = {0, 100, 1000};
    @Override
    public void onReceive(Context context, Intent intent) {
        //This code executes for and below api Nogout.
//        Toast.makeText(context, "This is Working", Toast.LENGTH_LONG).show();
//        Log.d("MyApp", "Notification started");
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = null;
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel("1", "testApp", NotificationManager.IMPORTANCE_HIGH);
            builder = new Notification.Builder(context, "testApp");
            manager.createNotificationChannel(channel);
            builder.setContentText("Welcome to geetanjali")
                    .setContentTitle("This is Hardik Chavda")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setChannelId("1")
                    .setAutoCancel(true);
        } else {
            builder = new Notification.Builder(context);
            builder.setContentText("Welcome to geetanjali")
                    .setContentTitle("This is Hardik Chavda")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    //.setVibrate(vibrate)
                    //.setLights(Color.argb(1, 255, 255, 255), 1, 2)
                    .setAutoCancel(true);
        }
        manager.notify(1, builder.build());
    }
}

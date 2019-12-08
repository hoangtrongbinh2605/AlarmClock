package com.example.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("receive","hello");
        String chuoi_string = intent.getExtras().getString("extra");
        Intent myIntent = new Intent (context,Music.class);
        myIntent.putExtra("extra",chuoi_string);
        context.startService(myIntent);
    }
}

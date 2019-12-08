package com.example.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String chuoi_string = intent.getExtras().getString("extra");
        Intent i = new Intent (context,Music.class);
        i.putExtra("extra",chuoi_string);
        context.startService(i);
    }
}

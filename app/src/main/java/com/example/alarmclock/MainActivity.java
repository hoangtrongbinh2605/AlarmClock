package com.example.alarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    ToggleButton toggleButton;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    Calendar calendar;
    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timepicker);
        toggleButton = findViewById(R.id.togglebtn);
        txtTime = findViewById(R.id.textView);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        calendar = Calendar.getInstance();
        final Intent intent = new Intent(MainActivity.this, MyReceiver.class);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked()){
                    calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                    calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());

                    int hour = timePicker.getCurrentHour();
                    int min = timePicker.getCurrentMinute();

                    String string_hour = String.valueOf(hour);
                    String string_min = String.valueOf(min);

                    if(hour>12){
                        string_hour = String.valueOf(hour - 12);
                    }
                    if(min <10){
                        string_min = "0" + String.valueOf(min);
                    }

                    intent.putExtra("extra","on");
                    pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                    alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                    txtTime.setText("Giờ bạn đặt là: " + string_hour + ":" + string_min);
                    Toast.makeText(MainActivity.this,"Alarm is ON", Toast.LENGTH_SHORT).show();
                }
                else{
//                    alarmManager.cancel(pendingIntent);
//                    Toast.makeText(MainActivity.this,"Alarm is OFF",Toast.LENGTH_SHORT).show();
//                    intent.putExtra("extra","off");
//                    sendBroadcast(intent);
                    Intent mh2 = new Intent(MainActivity.this, ConfirmActivity.class);
                    startActivity(mh2);
                }
            }
        });

    }
}

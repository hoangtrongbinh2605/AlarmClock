package com.example.alarmclock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class ConfirmActivity extends AppCompatActivity {
    TextView tv;
    EditText edt;
    Button btnOff;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        final Intent intent = new Intent(ConfirmActivity.this, MyReceiver.class);

        tv = (TextView) findViewById(R.id.tv1);
        edt = (EditText)findViewById(R.id.edt2);
        btnOff = (Button)findViewById(R.id.btnOff);

        tv.setText(id = UUID.randomUUID().toString());

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt.getText().toString().equals(tv.getText().toString())) {
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
                    intent.putExtra("extra","off");
                    sendBroadcast(intent);
                    Intent mh1 = new Intent(ConfirmActivity.this, MainActivity.class);
                    startActivity(mh1);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Not Correct",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}

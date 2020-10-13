package com.example.lyhoo.nfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class analog_card extends AppCompatActivity {
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analog_card);
        t1 = (TextView) findViewById(R.id.text);

        Intent intent = getIntent();
        String number = intent.getStringExtra("number");

        t1.setText("正在取包裹\n"+number+"\n请靠近门口感应器完成验证！");
    }
}

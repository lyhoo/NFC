package com.example.lyhoo.nfc;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseNfcActivity {
    Button take_thing;
    Button give_thing;
    Button person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        take_thing = (Button) findViewById(R.id.take_thing);
        give_thing = (Button) findViewById(R.id.give_thing);
        person = (Button) findViewById(R.id.person);
        // NFC适配器，所有的关于NFC的操作从该适配器进行
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        take_thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,read_text.class);
                startActivity(intent);
            }
        });
        give_thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,give_thing.class);
                startActivity(intent);
            }
        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,person.class);
                startActivity(intent);
            }
        });
    }
}

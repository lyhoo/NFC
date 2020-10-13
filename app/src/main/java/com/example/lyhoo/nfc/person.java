package com.example.lyhoo.nfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class person extends AppCompatActivity {
    private TextView name;
    person_info person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        name = (TextView) findViewById(R.id.name1);
        person = new person_info();
        name.setText(person.getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        name = (TextView) findViewById(R.id.name1);
        person = new person_info();
        name.setText(person.getName());
    }
}

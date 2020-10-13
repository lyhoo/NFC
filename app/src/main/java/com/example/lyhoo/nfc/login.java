package com.example.lyhoo.nfc;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {
    private TextView name;
    private TextView password;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (TextView) findViewById(R.id.name);
        password = (TextView) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login:
                login();
                break;
            case R.id.register:
                register();
                break;
        }
    }

    public void login(){
        if(name.getText().toString().equals("")||password.getText().toString().equals("")){
            Toast.makeText(this,"请填写完整！",Toast.LENGTH_SHORT);
        }else{
            String Name;
            String querry_name;
            String Password;
            String querry_password;
            SQLiteDatabase db;
            Myhelper myhelper = new Myhelper(this);
            db =  myhelper.getReadableDatabase();
            Name = name.getText().toString();
            Password = password.getText().toString();
            Cursor cursor = db.query("person",null,"name=?",new String[]{Name},null,null,null);
            if (cursor.getCount()==0){
                Toast.makeText(this,"该用户不存在!",Toast.LENGTH_SHORT);
                name.setText("");
                password.setText("");
            }else{
                cursor.moveToNext();
                querry_name = cursor.getString(1);
                querry_password = cursor.getString(2);
                cursor.close();
                db.close();
                if (querry_password.equals(Password)){
                    person_info person = new person_info(Name,Password);
                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"密码错误!",Toast.LENGTH_SHORT);
                }
            }
        }

    }

    public void register(){
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }
}

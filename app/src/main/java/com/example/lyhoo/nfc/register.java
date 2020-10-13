package com.example.lyhoo.nfc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
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

public class register extends AppCompatActivity {
    private TextView name;
    private TextView password;
    private TextView password1;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (TextView) findViewById(R.id.name);
        password = (TextView) findViewById(R.id.password);
        password1 = (TextView) findViewById(R.id.password1);
        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Password = password.getText().toString();
                String Password1 = password1.getText().toString();
                if (Name.equals("")||Password.equals("")||Password1.equals("")){
                    Toast.makeText(register.this,"请填写完整！",Toast.LENGTH_SHORT);
                }else if (!Password.equals(Password1)){
                    Toast.makeText(register.this,"两次填写的密码不一致！",Toast.LENGTH_SHORT);
                    password.setText("");
                    password1.setText("");
                }else{
                    Myhelper myhelper = new Myhelper(register.this);
                    SQLiteDatabase db = myhelper.getWritableDatabase();
                    SQLiteDatabase db1 = myhelper.getReadableDatabase();
                    Cursor cursor = db1.query("person",null,"name=?",new String[]{Name},null,null,null);
                    if (cursor.getCount()==0){
                        ContentValues values = new ContentValues();
                        values.put("name",Name);
                        values.put("password",Password);
                        db.insert("person",null,values);
                        cursor.close();
                        db.close();
                        db1.close();
                        AlertDialog dialog;
                        dialog = new AlertDialog.Builder(register.this).setTitle("提示")
                                .setMessage("注册成功！")
                                .setPositiveButton("确定",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent;
                                                intent = new Intent(register.this,login.class);
                                                startActivity(intent);
                                            }
                                        }).create();
                        dialog.show();
                    }else{
                        Toast.makeText(register.this,"账号存在，请重新输入！",Toast.LENGTH_SHORT);
                        name.setText("");
                        password1.setText("");
                        password.setText("");
                    }
                }
            }
        });
    }
}

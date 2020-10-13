package com.example.lyhoo.nfc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Myhelper extends SQLiteOpenHelper {
    public Myhelper(Context context){
        super(context,"itcast.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE person(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),password VARCHAR(20))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVeresion){}
}
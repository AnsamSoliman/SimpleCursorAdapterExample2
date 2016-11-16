package com.example.ansam.simplecursoradapterexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ansam on 11/16/2016.
 */

public class HelperDB extends SQLiteOpenHelper {
    public HelperDB(Context context) {
        super(context,"STUDENTS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student "+"( _id INTEGER PRIMARY KEY AUTOINCREMENT,name text,email text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertStudent(String name,String town){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",town);
        db.insert("student",null,contentValues);
        return true;
    }
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from student",null);
        return res;
    }
}

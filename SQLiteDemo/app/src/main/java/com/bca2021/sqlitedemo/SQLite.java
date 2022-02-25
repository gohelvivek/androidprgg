package com.bca2021.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class SQLite extends SQLiteOpenHelper {
    //Context thisContext;

    public SQLite(Context context) {
        super(context, "DBASE", null, 1);
        //thisContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table emp(ID TEXT,NAME TEXT,AGE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists emp");
        onCreate(db);
    }

    public boolean insertData(String ID, String Name, String Age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", ID);
        contentValues.put("NAME", Name);
        contentValues.put("AGE", Age);
        long res = db.insert("emp", null, contentValues);
        if (res == -1)
            return false;
        else
            return true;
    }

    public boolean updateData(String ID, String Name, String Age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", Name);
        contentValues.put("AGE", Age);
        db.update("emp", contentValues, "ID="+ID ,null);
        return true;
    }

    public boolean delData(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("emp", "ID=" + ID, null);
        return true;
    }

    public Cursor readData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from emp", null);
        return cursor;
    }
}

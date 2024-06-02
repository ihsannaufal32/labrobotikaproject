package com.example.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class datahelper1 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "labrobotikapendidikan.db";
    private static final int DATABASE_VERSION = 1;

    public datahelper1(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table peminjaman (no integer primary key, email text null, nama text null, prodi  text null, wa text null, waktu text null, lama text null, fasilitas text null, jumlah text null, keterangan text null);";
        Log.d("Data","onCreate :"+sql);
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}

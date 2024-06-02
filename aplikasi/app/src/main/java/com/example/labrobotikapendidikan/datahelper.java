package com.example.labrobotikapendidikan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class datahelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "labrobotikapendidikan.db";
    private static final int DATABASE_VERSION = 1;

    public datahelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String dbpeminjaman = "create table peminjaman(no integer primary key autoincrement, nama text null, nim text null, prodi text null,email text null, wa text null, tanggal text null, jam text null, lama text null, fasilitas text null, jumlah text null, keterangan text null);";
        Log.d("Data","onCreate :"+dbpeminjaman);
        db.execSQL(dbpeminjaman);

        String dbpengembalian = "create table pengembalian(no integer primary key autoincrement, nama text null, nim text null, prodi text null, email text null, wa text null, tanggal text null, jam text null, fasilitas text null, jumlah text null, keterangan text null);";
        Log.d("Data","onCreate :"+dbpengembalian);
        db.execSQL(dbpengembalian);

        String dbpenggunaan = "create table pengguna(no integer primary key autoincrement, email text null, logbook text null, jenispenggunaan text null, kegiatan text null, pengguna text null, prodi text null, pj text null, tanggal text null, jammulai text null, jamselesai text null, alat text null, keterangan text null);";
        Log.d("Data","onCreate :"+dbpenggunaan);
        db.execSQL(dbpenggunaan);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}

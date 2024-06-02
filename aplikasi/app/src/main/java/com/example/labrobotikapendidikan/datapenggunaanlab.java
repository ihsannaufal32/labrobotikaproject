package com.example.labrobotikapendidikan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class datapenggunaanlab extends AppCompatActivity {


    protected Cursor cursor;
    datahelper dbHelper;
    Button but1;
    TextView text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapenggunaanlab);

        text1 = (TextView) findViewById(R.id.lihatnopl);
        text2 = (TextView) findViewById(R.id.lihatemailpl);
        text3 = (TextView) findViewById(R.id.logbookpl);
        text4 = (TextView) findViewById(R.id.jenispenggunaanpl);
        text5 = (TextView) findViewById(R.id.lihatnamakegiatanpl);
        text6 = (TextView) findViewById(R.id.penggunapl);
        text7 = (TextView) findViewById(R.id.prodipl);
        text8 = (TextView) findViewById(R.id.pjpl);
        text9 = (TextView) findViewById(R.id.tglpl);
        text10 = (TextView) findViewById(R.id.jammulaipl);
        text11 = (TextView) findViewById(R.id.jamselesaipl);
        text12 = (TextView) findViewById(R.id.alatpl);
        text13 = (TextView) findViewById(R.id.keteranganpl);
        but1 = (Button) findViewById(R.id.lihatkembali);

        dbHelper = new datahelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String A = getIntent().getStringExtra("email");
        cursor = db.rawQuery("SELECT * FROM pengguna WHERE email = '"+A+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text6.setText(cursor.getString(5).toString());
            text7.setText(cursor.getString(6).toString());
            text8.setText(cursor.getString(7).toString());
            text9.setText(cursor.getString(8).toString());
            text10.setText(cursor.getString(9).toString());
            text11.setText(cursor.getString(10).toString());
            text12.setText(cursor.getString(11).toString());
            text13.setText(cursor.getString(12).toString());
        }
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //TODO Auto-generated method stub
                finish();
            }
        });
    }
}
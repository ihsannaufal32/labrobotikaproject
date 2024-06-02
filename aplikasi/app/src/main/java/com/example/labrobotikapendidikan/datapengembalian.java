package com.example.labrobotikapendidikan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class datapengembalian extends AppCompatActivity {

    protected Cursor cursor;
    datahelper dbHelper;
    Button but1;
    TextView text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapengembalian);

        text1 = (TextView) findViewById(R.id.lihatno);
        text2 = (TextView) findViewById(R.id.lihatnama);
        text3 = (TextView) findViewById(R.id.lihatnim);
        text4 = (TextView) findViewById(R.id.lihatprogramstudi);
        text5 = (TextView) findViewById(R.id.lihatemail);
        text6 = (TextView) findViewById(R.id.lihatnowa1);
        text7 = (TextView) findViewById(R.id.lihattanggal);
        text8 = (TextView) findViewById(R.id.lihatjam1);
        text9 = (TextView) findViewById(R.id.lihatfasilitas);
        text10 = (TextView) findViewById(R.id.lihatjumlah);
        text11 = (TextView) findViewById(R.id.lihatketerangan);
        but1 = (Button) findViewById(R.id.lihatkembali);

        dbHelper = new datahelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String A = getIntent().getStringExtra("nama");
        cursor = db.rawQuery("SELECT * FROM pengembalian WHERE nama = '"+A+"'",null);
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
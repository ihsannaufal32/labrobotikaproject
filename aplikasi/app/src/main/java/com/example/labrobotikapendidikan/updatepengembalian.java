package com.example.labrobotikapendidikan;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class updatepengembalian extends AppCompatActivity {

    protected Cursor cursor;
    datahelper dbHelper;
    Button but1, but2;
    EditText text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
    TextView nama1,nim1,prodi1,email1,telepon1,tanggal1,jam1,fasilitas1,jumlah1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepengembalian);

        dbHelper = new datahelper(this);
        text1 = (EditText) findViewById(R.id.inputnama1);
        text2 = (EditText) findViewById(R.id.inputnim1);
        text3 = (EditText) findViewById(R.id.inputprodi1);
        text4 = (EditText) findViewById(R.id.inputemail1);
        text5 = (EditText) findViewById(R.id.inputtelepon1);
        text6 = (EditText) findViewById(R.id.inputtanggal1);
        text7 = (EditText) findViewById(R.id.inputjam1);
        text8 = (EditText) findViewById(R.id.inputfasilitas1);
        text9 = (EditText) findViewById(R.id.inputjumlah1);
        text10= (EditText) findViewById(R.id.inputketerangan1);
        nama1 = (TextView) findViewById(R.id.alertnama);
        nim1 = (TextView) findViewById(R.id.alertnim);
        prodi1 = (TextView) findViewById(R.id.alertprodi);
        email1 = (TextView) findViewById(R.id.alertemail);
        telepon1 = (TextView) findViewById(R.id.alertwa);
        tanggal1 = (TextView) findViewById(R.id.alerttanggal);
        fasilitas1 = (TextView) findViewById(R.id.alertfasilitas);
        jumlah1 = (TextView) findViewById(R.id.alertjumlah);
        but1 = (Button) findViewById(R.id.submit1);
        but2 = (Button) findViewById(R.id.kembali1);

        dbHelper = new datahelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String A = getIntent().getStringExtra("nama");
        cursor = db.rawQuery("SELECT * FROM pengembalian WHERE nama = '"+A+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(1).toString());
            text2.setText(cursor.getString(2).toString());
            text3.setText(cursor.getString(3).toString());
            text4.setText(cursor.getString(4).toString());
            text5.setText(cursor.getString(5).toString());
            text6.setText(cursor.getString(6).toString());
            text7.setText(cursor.getString(7).toString());
            text8.setText(cursor.getString(8).toString());
            text9.setText(cursor.getString(9).toString());
            text10.setText(cursor.getString(10).toString());
        }

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (text1.getText().toString().trim().length()==0){
                    nama1.setText("Data Harus Diisi");
                } else{
                    if(text2.getText().toString().trim().length()==0){
                        nim1.setText("Data harus diisi");
                        nama1.setText("");
                    }else{
                        if (text3.getText().toString().trim().length()==0){
                            prodi1.setText("Data Harus Diisi");
                            nama1.setText("");
                            nim1.setText("");
                        } else{
                            if (text4.getText().toString().trim().length()==0) {
                                email1.setText("Data Harus Diisi");
                                prodi1.setText("");
                                nama1.setText("");
                                nim1.setText("");
                            } else {
                                if (text5.getText().toString().trim().length()==0) {
                                    telepon1.setText("Data Harus Diisi");
                                    prodi1.setText("");
                                    email1.setText("");
                                    nama1.setText("");
                                    nim1.setText("");
                                } else {
                                    if (text6.getText().toString().trim().length()==0) {
                                        tanggal1.setText("Data Harus Diisi");
                                        email1.setText("");
                                        prodi1.setText("");
                                        telepon1.setText("");
                                        nama1.setText("");
                                        nim1.setText("");
                                    } else{
                                        if (text7.getText().toString().trim().length()==0) {
                                            tanggal1.setText("Data Harus Diisi");
                                            nama1.setText("");
                                            nim1.setText("");
                                            email1.setText("");
                                            prodi1.setText("");
                                            telepon1.setText("");
                                            nama1.setText("");
                                            nim1.setText("");
                                        } else{
                                            if (text8.getText().toString().trim().length()==0) {
                                                fasilitas1.setText("Data Harus Diisi");
                                                nama1.setText("");
                                                nim1.setText("");
                                                prodi1.setText("");
                                                email1.setText("");
                                                telepon1.setText("");
                                                tanggal1.setText("");
                                            } else{
                                                if (text9.getText().toString().trim().length()==0) {
                                                    jumlah1.setText("Data Harus Diisi");
                                                    nama1.setText("");
                                                    nim1.setText("");
                                                    prodi1.setText("");
                                                    email1.setText("");
                                                    telepon1.setText("");
                                                    tanggal1.setText("");
                                                    fasilitas1.setText("");
                                                } else{
                                                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                                                    db.execSQL("update pengembalian set nama='"+text1.getText().toString()+"',nim= '"+text2.getText().toString()+"',prodi='"+text3.getText().toString()+"',email='"+text4.getText().toString()+"',wa='"+text5.getText().toString()+"',tanggal='"+text6.getText().toString()+"',jam='"+text7.getText().toString()+"',fasilitas='"+text8.getText().toString()+"',jumlah='"+text9.getText().toString()+"',keterangan='"+text10.getText().toString()+"' WHERE nama = '"+A+"'");
                                                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                                                    daftarpengembalian.ma.RefreshList();
                                                    finish();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //TODO Auto-generated method stub
                finish();
            }
        });
    }
}

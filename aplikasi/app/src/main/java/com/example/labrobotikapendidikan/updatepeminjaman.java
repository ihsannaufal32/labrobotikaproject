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

import org.w3c.dom.Text;

public class updatepeminjaman extends AppCompatActivity {
    protected Cursor cursor;
    datahelper dbHelper;
    Button but1, but2;
    EditText nama1,nim2,prodi3,wa4,tanggal5,jam6,lama7,fasilitas8,jumlah9,keterangan10,email4;
    TextView nama,nim,prodi,wa,tanggal,lama,fasilitas,jumlah,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepeminjaman);

        dbHelper = new datahelper(this);
        nama1 = (EditText) findViewById(R.id.inputnama1);
        nim2 = (EditText) findViewById(R.id.inputnim1);
        prodi3 = (EditText) findViewById(R.id.inputprodi1);
        email4=(EditText)findViewById(R.id.inputemail1);
        wa4 = (EditText) findViewById(R.id.inputtelepon1);
        tanggal5 = (EditText) findViewById(R.id.inputtanggal1);
        jam6 = (EditText) findViewById(R.id.inputjam1);
        lama7 = (EditText) findViewById(R.id.inputlama1);
        fasilitas8 = (EditText) findViewById(R.id.inputfasilitas1);
        jumlah9 = (EditText) findViewById(R.id.inputjumlah1);
        keterangan10 = (EditText) findViewById(R.id.inputketerangan1);
        nama=(TextView) findViewById(R.id.alertnama);
        nim=(TextView) findViewById(R.id.alertnim);
        prodi=(TextView) findViewById(R.id.alertprodi);
        email=(TextView) findViewById(R.id.alertemail);
        wa=(TextView) findViewById(R.id.alertwa);
        tanggal=(TextView) findViewById(R.id.alerttanggal);
        lama=(TextView) findViewById(R.id.alertlama);
        fasilitas=(TextView) findViewById(R.id.alertfasilitas);
        jumlah=(TextView) findViewById(R.id.alertjumlah);

        but1 = (Button) findViewById(R.id.submit1);
        but2 = (Button) findViewById(R.id.kembali1);

        dbHelper = new datahelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String A = getIntent().getStringExtra("nama");
        cursor = db.rawQuery("SELECT * FROM peminjaman WHERE nama = '"+A+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            nama1.setText(cursor.getString(1).toString());
            nim2.setText(cursor.getString(2).toString());
            prodi3.setText(cursor.getString(3).toString());
            email4.setText(cursor.getString(4).toString());
            wa4.setText(cursor.getString(5).toString());
            tanggal5.setText(cursor.getString(6).toString());
            jam6.setText(cursor.getString(7).toString());
            lama7.setText(cursor.getString(8).toString());
            fasilitas8.setText(cursor.getString(9).toString());
            jumlah9.setText(cursor.getString(10).toString());
            keterangan10.setText(cursor.getString(11).toString());
        }

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (nama1.getText().toString().trim().length()==0){
                    nama.setText("Data harus diisi");
                } else{
                    if (nim2.getText().toString().trim().length()==0){
                        nama.setText("");
                        nim.setText("Data harus diisi");
                    } else{
                        if (prodi3.getText().toString().trim().length()==0){
                            prodi.setText("Data harus diisi");
                            nama.setText("");
                            nim.setText("");
                        } else{
                            if (email4.getText().toString().trim().length()==0){
                                email.setText("Data harus diisi");
                                prodi.setText("");
                                nama.setText("");
                                nim.setText("");
                            } else {
                                if (wa4.getText().toString().trim().length()==0){
                                    wa.setText("Data harus diisi");
                                    prodi.setText("");
                                    nama.setText("");
                                    nim.setText("");
                                    email.setText("");
                                } else {
                                    if (tanggal5.getText().toString().trim().length()==0){
                                        tanggal.setText("Data harus diisi");
                                        prodi.setText("");
                                        nim.setText("");
                                        nama.setText("");
                                        wa.setText("");
                                        email.setText("");
                                    } else{
                                        if (jam6.getText().toString().trim().length()==0){
                                            tanggal.setText("Data harus diisi");
                                            prodi.setText("");
                                            nama.setText("");
                                            nim.setText("");
                                            wa.setText("");
                                            email.setText("");
                                        } else{
                                            if (lama7.getText().toString().trim().length()==0){
                                                lama.setText("Data harus diisi");
                                                tanggal.setText("");
                                                nama.setText("");
                                                prodi.setText("");
                                                nim.setText("");
                                                wa.setText("");
                                                email.setText("");

                                            } else{
                                                if (fasilitas8.getText().toString().trim().length()==0){
                                                    fasilitas.setText("Data harus diisi");
                                                    lama.setText("");
                                                    tanggal.setText("");
                                                    prodi.setText("");
                                                    nama.setText("");
                                                    nim.setText("");
                                                    wa.setText("");
                                                    email.setText("");
                                                } else{
                                                    if (jumlah9.getText().toString().trim().length()==0){
                                                        jumlah.setText("Data harus diisi");
                                                        fasilitas.setText("");
                                                        lama.setText("");
                                                        tanggal.setText("");
                                                        prodi.setText("");
                                                        nama.setText("");
                                                        nim.setText("");
                                                        wa.setText("");
                                                        email.setText("");

                                                    } else{
                                                        // TODO Auto-generated method stub
                                                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                                                        db.execSQL("update peminjaman set nama='"+ nama1.getText().toString()+"',nim='"+ nim2.getText().toString()+"',prodi='"+ prodi3.getText().toString()+"',email='"+email4.getText().toString()+"',wa='"+ wa4.getText().toString()+"',tanggal='"+ tanggal5.getText().toString()+"',jam='"+jam6.getText().toString()+"',lama='"+lama7.getText().toString()+"',fasilitas='"+fasilitas8.getText().toString()+"',jumlah='"+jumlah9.getText().toString()+"', keterangan='"+keterangan10.getText().toString()+"' WHERE nama = '"+A+"'");
                                                        Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                                                        daftarpeminjaman.ma.RefreshList();
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

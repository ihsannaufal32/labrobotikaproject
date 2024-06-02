package com.example.labrobotikapendidikan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class peminjamanlab extends AppCompatActivity {

    protected Cursor cursor;
    datahelper dbHelper;
    Button but1, but2;
    TextView nama1,nim1,prodi1,wa1,tanggal1,lama1,fasilitas1,jumlah1,email1;
    EditText nama,nim,prodi,wa,tanggal,jam,lama,fasilitas,jumlah,keterangan, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitypeminjaman2);

        dbHelper = new datahelper(this);
        nama = (EditText) findViewById(R.id.inputnama1);
        nim = (EditText) findViewById(R.id.inputnim1);
        prodi = (EditText) findViewById(R.id.inputprodi1);
        wa = (EditText) findViewById(R.id.inputtelepon1);
        email=(EditText)findViewById(R.id.inputemail1);
        tanggal = (EditText) findViewById(R.id.inputtanggal1);
        jam = (EditText) findViewById(R.id.inputjam1);
        lama = (EditText) findViewById(R.id.inputlama1);
        fasilitas = (EditText) findViewById(R.id.inputfasilitas1);
        jumlah = (EditText) findViewById(R.id.inputjumlah1);
        keterangan = (EditText) findViewById(R.id.inputketerangan1);
        nama1=(TextView) findViewById(R.id.alertnama);
        nim1=(TextView) findViewById(R.id.alertnim);
        prodi1=(TextView) findViewById(R.id.alertprodi);
        wa1=(TextView) findViewById(R.id.alertwa);
        tanggal1=(TextView) findViewById(R.id.alerttanggal);
        lama1=(TextView) findViewById(R.id.alertlama);
        email1=(TextView) findViewById(R.id.alertemail);
        fasilitas1=(TextView) findViewById(R.id.alertfasilitas);
        jumlah1=(TextView) findViewById(R.id.alertjumlah);
        but1 = (Button) findViewById(R.id.submit1);
        but2 = (Button) findViewById(R.id.kembali1);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (nama.getText().toString().trim().length()==0){
                    nama1.setText("Data harus diisi");
                } else{
                    if (nim.getText().toString().trim().length()==0){
                        nama1.setText("");
                        nim1.setText("Data harus diisi");
                    } else{
                        if (prodi.getText().toString().trim().length()==0){
                            prodi1.setText("Data harus diisi");
                            nama1.setText("");
                            nim1.setText("");
                        } else{
                            if (email.getText().toString().trim().length()==0){
                            email1.setText("Data harus diisi");
                            prodi1.setText("");
                            nama1.setText("");
                            nim1.setText("");
                                } else {
                                if (wa.getText().toString().trim().length()==0){
                                    wa1.setText("Data harus diisi");
                                    prodi1.setText("");
                                    nama1.setText("");
                                    nim1.setText("");
                                    email1.setText("");
                                } else {
                                    if (tanggal.getText().toString().trim().length()==0){
                                        tanggal1.setText("Data harus diisi");
                                        prodi1.setText("");
                                        nim1.setText("");
                                        nama1.setText("");
                                        wa1.setText("");
                                        email1.setText("");
                                    } else{
                                        if (jam.getText().toString().trim().length()==0){
                                            tanggal1.setText("Data harus diisi");
                                            prodi1.setText("");
                                            nama1.setText("");
                                            nim1.setText("");
                                            wa1.setText("");
                                            email1.setText("");
                                        } else{
                                            if (lama.getText().toString().trim().length()==0){
                                                lama1.setText("Data harus diisi");
                                                tanggal1.setText("");
                                                nama1.setText("");
                                                prodi1.setText("");
                                                nim1.setText("");
                                                wa1.setText("");
                                                email1.setText("");

                                            } else{
                                                if (fasilitas.getText().toString().trim().length()==0){
                                                    fasilitas1.setText("Data harus diisi");
                                                    lama1.setText("");
                                                    tanggal1.setText("");
                                                    prodi1.setText("");
                                                    nama1.setText("");
                                                    nim1.setText("");
                                                    wa1.setText("");
                                                    email1.setText("");
                                                } else{
                                                    if (jumlah.getText().toString().trim().length()==0){
                                                        jumlah1.setText("Data harus diisi");
                                                        fasilitas1.setText("");
                                                        lama1.setText("");
                                                        tanggal1.setText("");
                                                        prodi1.setText("");
                                                        nama1.setText("");
                                                        nim1.setText("");
                                                        wa1.setText("");
                                                        email1.setText("");
                                                    } else{
                                                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                                                        db.execSQL("insert into peminjaman(nama, nim, prodi, email, wa, tanggal, jam, lama, fasilitas, jumlah, keterangan) values ('"+ nama.getText().toString()+"','"+ nim.getText().toString()+"','"+ prodi.getText().toString()+"','"+email.getText().toString()+"','"+ wa.getText().toString()+"','"+ tanggal.getText().toString()+"','"+ jam.getText().toString()+"','"+ lama.getText().toString()+"','"+ fasilitas.getText().toString()+"','"+ jumlah.getText().toString()+"','"+ keterangan.getText().toString()+"')");
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
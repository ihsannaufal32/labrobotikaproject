package com.example.labrobotikapendidikan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class penggunaanlab extends AppCompatActivity {
    datahelper dbHelper;
    RadioGroup logbook,jenispenggunaan,penanggungjawab,pengguna;
    EditText email,namakegiatan,tanggal,mulai,akhir,keterangan,alat,prodi;
    RadioButton pilihanlogbook,rb_jenpeng, rb_pj, rb_pengg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penggunaanlab3);
        dbHelper = new datahelper(this);
        jenispenggunaan=(RadioGroup) findViewById(R.id.rad_jenpeng);
        penanggungjawab=(RadioGroup) findViewById(R.id.rad_pj);
        pengguna=(RadioGroup) findViewById(R.id.rad_pengg);
        logbook=(RadioGroup) findViewById(R.id.optionlogbook1);
        email=(EditText) findViewById(R.id.Email_lb) ;
        namakegiatan=(EditText)findViewById(R.id.namakeg);
        tanggal=(EditText)findViewById(R.id.tanggalkeg);
        mulai=(EditText)findViewById(R.id.mulaikeg);
        akhir=(EditText)findViewById(R.id.selesaikeg);
        keterangan=(EditText)findViewById(R.id.ketkeg);
        alat=(EditText)findViewById(R.id.alatkeg);
        prodi=(EditText) findViewById(R.id.prodked);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Button button1 = findViewById(R.id.kembali2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button button2 = findViewById(R.id.submit2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pilihan_jenpeng = jenispenggunaan.getCheckedRadioButtonId();
                int pilihan_pj = penanggungjawab.getCheckedRadioButtonId();
                int pilihan_pengg= pengguna.getCheckedRadioButtonId();
                int pil_log=logbook.getCheckedRadioButtonId();
                pilihanlogbook=(RadioButton)findViewById(pil_log);
                rb_jenpeng=(RadioButton) findViewById(pilihan_jenpeng);
                rb_pengg=(RadioButton) findViewById(pilihan_pengg);
                rb_pj=(RadioButton) findViewById(pilihan_pj);
                db.execSQL("insert into pengguna (email, logbook, jenispenggunaan, kegiatan, pengguna, prodi, pj, tanggal, jammulai, jamselesai, alat, keterangan) " +
                        "values ('"+ email.getText().toString()+"'," +
                        "'"+ pilihanlogbook.getText().toString()+"'," +
                        "'"+rb_jenpeng.getText().toString()+"'," +
                        "'"+namakegiatan.getText().toString()+"'," +
                        "'"+rb_pengg.getText().toString()+"'," +
                        "'"+prodi.getText().toString()+"'," +
                        "'"+rb_pj.getText().toString()+"'," +
                        "'"+tanggal.getText().toString()+"'," +
                        "'"+mulai.getText().toString()+"'," +
                        "'"+akhir.getText().toString()+"'," +
                        "'"+alat.getText().toString()+"'," +
                        "'"+keterangan.getText().toString()+"')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                daftarpenggunaanlab.ma.RefreshList();
                finish();
            }
        });
    }
}
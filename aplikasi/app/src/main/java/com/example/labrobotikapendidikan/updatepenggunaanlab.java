package com.example.labrobotikapendidikan;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class updatepenggunaanlab extends AppCompatActivity {
    protected Cursor cursor;
    datahelper dbHelper;
    RadioGroup logbook,jenispenggunaan,penanggungjawab,pengguna;
    EditText email,namakegiatan,tanggal,mulai,akhir,keterangan,alat,prodi;
    RadioButton pilihanlogbook,rb_jenpeng, rb_pj, rb_pengg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepenggunaanlab);
        jenispenggunaan=(RadioGroup) findViewById(R.id.rad_jenpeng);
        penanggungjawab=(RadioGroup) findViewById(R.id.rad_pj);
        pengguna=(RadioGroup) findViewById(R.id.rad_pengg);
        logbook=(RadioGroup) findViewById(R.id.optionlogbook1);
        Button button1 = findViewById(R.id.kembali2);
        Button button2 = findViewById(R.id.submit2);
        dbHelper = new datahelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String A = getIntent().getStringExtra("nama");
//        cursor = db.rawQuery("SELECT * FROM pengguna WHERE email = '"+A+"'",null);
//        cursor.moveToFirst();
//        if(cursor.getCount()>0){
//            cursor.moveToPosition(0);
//            email.setText(cursor.getString(1).toString());
//            namakegiatan.setText(cursor.getString(3).toString());
//            prodi.setText(cursor.getString(5).toString());
//            tanggal.setText(cursor.getString(7).toString());
//            mulai.setText(cursor.getString(8).toString());
//            akhir.setText(cursor.getString(9).toString());
//            alat.setText(cursor.getString(10).toString());
//            keterangan.setText(cursor.getString(11).toString());
//        }


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
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update pengguna set email='"+ email.getText().toString()+"',logbook='"+ pilihanlogbook.getText().toString()+"',jenispenggunaan='"+ rb_jenpeng.getText().toString()+"',kegiatan='"+namakegiatan.getText().toString()+"',pengguna='"+ rb_pengg.getText().toString()+"',prodi='"+ prodi.getText().toString()+"',pj='"+rb_pj.getText().toString()+"',tanggal='"+tanggal.getText().toString()+"',jammulai='"+mulai.getText().toString()+"',jamselesai='"+akhir.getText().toString()+"', alat='"+alat.getText().toString()+"',keterangan='"+keterangan.getText().toString()+"' WHERE email = '"+A+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                daftarpeminjaman.ma.RefreshList();
                finish();

            }
        });
    }
}

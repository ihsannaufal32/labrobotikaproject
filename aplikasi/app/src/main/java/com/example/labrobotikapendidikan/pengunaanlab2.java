package com.example.labrobotikapendidikan;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pengunaanlab2 extends AppCompatActivity {

    protected Cursor cursor;
    datahelper dbHelper;
    Button but1, but2;
    RadioGroup jenispenggunaan,penanggungjawab,pengguna;
    EditText namakegiatan,tanggal,mulai,akhir,keterangan,alat,prodi;
    RadioButton rb_jenpeng, rb_pj, rb_pengg;
    CheckBox chkalat1,chkalat2,chkalat3,chkalat4,chkalat5,chkprodi1,chkprodi2,chkprodi3,chkprodi4,chkprodi5,chkprodi6;

//    TextView nama1,nim1,prodi1,email1,telepon1,tanggal1,jam1,fasilitas1,jumlah1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penggunaanlab3);

        dbHelper = new datahelper(this);
        namakegiatan=(EditText)findViewById(R.id.namakeg);
        tanggal=(EditText)findViewById(R.id.tanggalkeg);
        mulai=(EditText)findViewById(R.id.mulaikeg);
        akhir=(EditText)findViewById(R.id.selesaikeg);
        keterangan=(EditText)findViewById(R.id.ketkeg);
        alat=(EditText)findViewById(R.id.alatkeg);
        prodi=(EditText) findViewById(R.id.prodked);
        jenispenggunaan=(RadioGroup) findViewById(R.id.rad_jenpeng);
        penanggungjawab=(RadioGroup) findViewById(R.id.rad_pj);
        pengguna=(RadioGroup) findViewById(R.id.rad_pengg);
        int pilihan_jenpeng = jenispenggunaan.getCheckedRadioButtonId();
        int pilihan_pj = penanggungjawab.getCheckedRadioButtonId();
        int pilihan_pengg= pengguna.getCheckedRadioButtonId();
        rb_jenpeng=(RadioButton) findViewById(pilihan_jenpeng);
        rb_pengg=(RadioButton) findViewById(pilihan_pengg);
        rb_pj=(RadioButton) findViewById(pilihan_pj);


//        nama1 = (TextView) findViewById(R.id.alertnama);
//        nim1 = (TextView) findViewById(R.id.alertnim);
//        prodi1 = (TextView) findViewById(R.id.alertprodi);
//        email1 = (TextView) findViewById(R.id.alertemail);
//        telepon1 = (TextView) findViewById(R.id.alertwa);
//        tanggal1 = (TextView) findViewById(R.id.alerttanggal);
//        fasilitas1 = (TextView) findViewById(R.id.alertfasilitas);
//        jumlah1 = (TextView) findViewById(R.id.alertjumlah);
        but1 = (Button) findViewById(R.id.submit2);
        but2 = (Button) findViewById(R.id.kembali2);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update pengguna WHERE no = (SELECT MAX(no)  FROM penggunaan) set jenispenggunaan='"+ rb_jenpeng.getText().toString()+"',kegiatan='"+ namakegiatan.getText().toString()+"',pengguna='"+ rb_pengg.getText().toString()+"',prodi='"+prodi.getText().toString()+"',pj='"+rb_pj.getText().toString()+"',tanggal='"+ tanggal.getText().toString()+"',jammulai='"+mulai.getText().toString()+"',jamselesai='"+akhir.getText().toString()+"',alat='"+alat.getText().toString()+"',keterangan='"+keterangan.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                daftarpengembalian.ma.RefreshList();
                finish();
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

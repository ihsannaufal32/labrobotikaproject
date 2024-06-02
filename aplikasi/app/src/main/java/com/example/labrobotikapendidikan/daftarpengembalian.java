package com.example.labrobotikapendidikan;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.labrobotikapendidikan.databinding.ActivityMainBinding;

public class daftarpengembalian extends AppCompatActivity {
    String[] daftar;
    ListView ListView1;
    Menu menu;
    protected Cursor cursor;
    datahelper dbcenter;
    public static daftarpengembalian ma;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarpengembalian);
        ma = this;
        dbcenter=new datahelper(this);
        Button back = findViewById(R.id.btn_bck);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(daftarpengembalian.this, listdata.class);
                startActivity(intent);
            }
        });
        RefreshList(); //sebuah fungsi
    }


    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pengembalian", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc<cursor.getCount();cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView1 = (ListView) findViewById(R.id.ListView01);
        ListView1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView1.setSelected(true);

        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat Data", "Update Data", "Hapus Data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(daftarpengembalian.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item){
                            case 0:
                                Intent i =new Intent(getApplicationContext(), datapengembalian.class);
                                i.putExtra("nama", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(),updatepengembalian.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            case 2:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from pengembalian where nama = '"+ selection +"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) ListView1.getAdapter()).notifyDataSetInvalidated();
    }
}

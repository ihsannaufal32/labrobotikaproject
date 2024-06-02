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

public class daftarpenggunaanlab extends AppCompatActivity {
    String[] daftar;
    ListView ListView1;
    Menu menu;
    protected Cursor cursor;
    datahelper dbcenter;
    public static daftarpenggunaanlab ma;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarpenguunaanlab);
        ma = this;
        dbcenter=new datahelper(this);
        Button back = findViewById(R.id.btn_bck);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(daftarpenggunaanlab.this, listdata.class);
                startActivity(intent);
            }
        });
        RefreshList(); //sebuah fungsi
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pengguna", null);
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
                final CharSequence[] dialogitem = {"Lihat Data",  "Hapus Data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(daftarpenggunaanlab.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item){
                            case 0:
                                Intent i =new Intent(getApplicationContext(), datapenggunaanlab.class);
                                i.putExtra("email", selection);
                                startActivity(i);
                                break;
                            case 1:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from pengguna where email = '"+ selection +"'");
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

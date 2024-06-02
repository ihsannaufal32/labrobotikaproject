package com.example.labrobotikapendidikan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.crud.datahelper1;
import com.example.labrobotikapendidikan.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    String[] daftar;
    ListView Listview01;
    Menu menu;
    protected Cursor cursor;
    datahelper1 dbcenter;
    public static MainActivity ma;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, optionform.class);
                startActivity(intent);
            }
        });

        ma = this;
        dbcenter = new datahelper1(this);
    }
//
//    public void RefreshList() {
//        SQLiteDatabase db = dbcenter.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM peminjaman", null);
//        daftar = new String[cursor.getCount()];
//        cursor.moveToFirst();
//        for (int cc = 0; cc < cursor.getCount(); cc++) {
//            cursor.moveToPosition(cc);
//            daftar[cc] = cursor.getString(1).toString();
//        }
//        Listview01 = (ListView) findViewById(R.id.ListView);
//        Listview01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
//        Listview01.setSelected(true);
//    }
}
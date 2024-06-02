package com.example.labrobotikapendidikan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class optionform extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optionform);

        Button button1 = findViewById(R.id.peminjaman);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten1 = new Intent(optionform.this, peminjamanlab.class);
                startActivity(inten1);
            }
        });

        Button button2 = findViewById(R.id.pengembalian);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten2 = new Intent(optionform.this, pengembalianlab.class);
                startActivity(inten2);
            }
        });

        Button button3 = findViewById(R.id.penggunaan);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten3 = new Intent(optionform.this, penggunaanlab.class);
                startActivity(inten3);
            }
        });

        Button button4 = findViewById(R.id.list);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten4 = new Intent(optionform.this, listdata.class);
                startActivity(inten4);
            }
        });

    }}

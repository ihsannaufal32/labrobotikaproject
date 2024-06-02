package com.example.labrobotikapendidikan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class listdata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);


        Button button1 = findViewById(R.id.listpeminjaman);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listpeminjaman = new Intent(listdata.this, daftarpeminjaman.class);
                startActivity(listpeminjaman);
            }
        });

        Button button2 = findViewById(R.id.listpengembalian);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listpengembalian = new Intent(listdata.this, daftarpengembalian.class);
                startActivity(listpengembalian);
            }
        });

        Button button3 = findViewById(R.id.listpengunaan);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listpenggunaan = new Intent(listdata.this, daftarpenggunaanlab.class);
                startActivity(listpenggunaan);
            }
        });

        Button button4 = findViewById(R.id.buttonoptionform);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtohomepage = new Intent(listdata.this, optionform.class);
                startActivity(backtohomepage);
            }
        });
    }
}

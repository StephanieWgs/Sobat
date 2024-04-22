package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dsrmobile.sobat.util.Util;

public class TambahDataFisik extends AppCompatActivity {
    LinearLayout back,tambah;
    EditText tglData, berat, tinggi, lingkarKepala;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_fisik);
        // Mendapatkan Intent yang memulai aktivitas ini
        Intent intent = getIntent();
        // Menangkap nilai idAnak dari ekstra Intent
        String idAnak = intent.getStringExtra("idAnak");

        back = (LinearLayout) findViewById(R.id.back);
        tambah = (LinearLayout) findViewById(R.id.tambah);

        tglData = (EditText) findViewById(R.id.tglData);
        berat = (EditText) findViewById(R.id.berat);
        tinggi = (EditText) findViewById(R.id.tinggi);
        lingkarKepala = (EditText) findViewById(R.id.lingkarKepala);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tglDataFisik = tglData.getText().toString();
                int beratAnak = Integer.parseInt(berat.getText().toString());
                int tinggiAnak = Integer.parseInt(tinggi.getText().toString());
                int lingkarKepalaAnak = Integer.parseInt(lingkarKepala.getText().toString());
                String message = "";

                if(!tglDataFisik.equals("") && beratAnak != 0 && tinggiAnak != 0 && lingkarKepalaAnak != 0){
                    Util.simpanDataFisik(Util.idDataBaru(),tglDataFisik,beratAnak,tinggiAnak,lingkarKepalaAnak,idAnak);
                    Intent intent = new Intent(TambahDataFisik.this, MainActivity.class);
                    startActivity(intent);

                    message = "Data fisik anak berhasil ditambah!";
                }
                else{
                    message = "Isi data fisik dengan lengkap...";
                }
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(TambahDataFisik.this, message, duration);
                toast.show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
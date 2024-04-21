package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dsrmobile.sobat.util.Util;

public class DetailCatat extends AppCompatActivity {
    TextView beratBadan;
    LinearLayout tambahDataFisik, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catat);

        // Mendapatkan Intent yang memulai aktivitas ini
        Intent intent = getIntent();
        // Menangkap nilai idAnak dari ekstra Intent
        String idAnak = intent.getStringExtra("idAnak");

        tambahDataFisik = (LinearLayout) findViewById(R.id.tambahDataFisik);
        back = (LinearLayout) findViewById(R.id.back);

        beratBadan = (TextView) findViewById(R.id.beratBadan);
        beratBadan.setText(Util.getBeratBadan(idAnak));

        tambahDataFisik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailCatat.this, TambahDataFisik.class);
                startActivity(intent);
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
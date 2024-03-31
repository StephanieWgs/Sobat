package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DetailCatat extends AppCompatActivity {

    LinearLayout tambahDataFisik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catat);

        tambahDataFisik = (LinearLayout) findViewById(R.id.tambahDataFisik);

        tambahDataFisik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailCatat.this, TambahDataFisik.class);
                startActivity(intent);
            }
        });
    }
}
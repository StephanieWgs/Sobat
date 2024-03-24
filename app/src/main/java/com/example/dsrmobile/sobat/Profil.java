package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Profil extends AppCompatActivity {

    LinearLayout detailProfilAnak,catat,home,updateProfilIbu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        detailProfilAnak = (LinearLayout) findViewById(R.id.detailProfilAnak);
        catat = (LinearLayout) findViewById(R.id.catat);
        home = (LinearLayout) findViewById(R.id.home);
        updateProfilIbu = (LinearLayout) findViewById(R.id.updateProfilIbu);

        detailProfilAnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profil.this, UpdateProfilAnak.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profil.this, MainActivity.class);
                startActivity(intent);
            }
        });

        catat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profil.this, Catat.class);
                startActivity(intent);
            }
        });

        updateProfilIbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profil.this, UpdateProfilIbu.class);
                startActivity(intent);
            }
        });
    }
}
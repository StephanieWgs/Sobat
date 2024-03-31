package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    LinearLayout detailProfilAnak,catat,home,updateProfilIbu,logout, tambahAnak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        detailProfilAnak = (LinearLayout) findViewById(R.id.detailProfilAnak);
        catat = (LinearLayout) findViewById(R.id.catat);
        home = (LinearLayout) findViewById(R.id.home);
        updateProfilIbu = (LinearLayout) findViewById(R.id.updateProfilIbu);
        logout = (LinearLayout) findViewById(R.id.logout);
        tambahAnak = (LinearLayout) findViewById(R.id.tambahAnak);

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

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profil.this, Awal.class);
                startActivity(intent);

                String message = "Sampai Jumpa Kembali, Mums!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(Profil.this, message, duration);
                toast.show();
            }
        });
        tambahAnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profil.this, TambahAnak.class);
                startActivity(intent);
            }
        });

    }
}
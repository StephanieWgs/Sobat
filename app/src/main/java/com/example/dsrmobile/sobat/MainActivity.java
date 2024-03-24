package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout catat1,catat2,profile,konsul,forum,imunisasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catat1 = (LinearLayout) findViewById(R.id.catat1);
        catat2 = (LinearLayout) findViewById(R.id.catat2);
        profile = (LinearLayout) findViewById(R.id.profile);
        konsul = (LinearLayout) findViewById(R.id.konsul);
        forum = (LinearLayout) findViewById(R.id.forum);
        imunisasi = (LinearLayout) findViewById(R.id.imunisasi);

        catat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Catat.class);
                startActivity(intent);
            }
        });

        catat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Catat.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Profil.class);
                startActivity(intent);
            }
        });

        konsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Konsultasi.class);
                startActivity(intent);
            }
        });

        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Forum.class);
                startActivity(intent);
            }
        });

        imunisasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Imunisasi.class);
                startActivity(intent);
            }
        });
    }
}
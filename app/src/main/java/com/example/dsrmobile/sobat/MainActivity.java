package com.example.dsrmobile.sobat;

import com.example.dsrmobile.sobat.util.Util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dsrmobile.sobat.Model.Anak;
import com.example.dsrmobile.sobat.Model.DataFisikAnak;
import com.example.dsrmobile.sobat.Model.Ibu;

import java.time.LocalDate;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    LinearLayout catat1,catat2,profile,konsul,forum,imunisasi,anak,tambahAnak;

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
        anak = (LinearLayout) findViewById(R.id.anak);
        tambahAnak = (LinearLayout) findViewById(R.id.tambahAnak);

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

        anak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailCatat.class);
                startActivity(intent);
            }
        });

        tambahAnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TambahAnak.class);
                startActivity(intent);
            }
        });
    }

}
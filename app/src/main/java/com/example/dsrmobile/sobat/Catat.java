package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dsrmobile.sobat.Adapter.AnakAdapter;
import com.example.dsrmobile.sobat.Model.Anak;
import com.example.dsrmobile.sobat.util.Util;

import java.util.ArrayList;

public class Catat extends AppCompatActivity {

    LinearLayout home,profile,tambahProfil, notif;
    ListView listAnak;
    ArrayList<Anak> anakArrayList;
    private static AnakAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catat);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData", MODE_PRIVATE);
        String idIbu = sharedPreferences.getString("idIbu", null);

        home = (LinearLayout) findViewById(R.id.home);
        profile = (LinearLayout) findViewById(R.id.profile);
        tambahProfil = (LinearLayout) findViewById(R.id.tambahProfil);
        notif = (LinearLayout) findViewById(R.id.notif);

        listAnak = (ListView) findViewById(R.id.listAnak);
        anakArrayList = new ArrayList<>();
        anakArrayList = Util.cariAnakByIdIbu(Util.getAllAnak(),idIbu);

        adapter = new AnakAdapter(anakArrayList,getApplicationContext());
        listAnak.setAdapter(adapter);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Catat.this, MainActivity.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Catat.this, Profil.class);
                startActivity(intent);
            }
        });

        tambahProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Catat.this, TambahAnak.class);
                startActivity(intent);
            }
        });

        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Catat.this, Notifikasi.class);
                startActivity(intent);
            }
        });

        listAnak.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String idAnak = (String) view.getTag(R.id.idAnak);
                Intent intent = new Intent(Catat.this, DetailCatat.class);
                // Menyertakan idAnak sebagai ekstra dalam Intent
                intent.putExtra("idAnak", idAnak);
                startActivity(intent);
            }
        });
    }
}
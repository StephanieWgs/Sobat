package com.example.dsrmobile.sobat;

import com.example.dsrmobile.sobat.Adapter.AnakAdapter;
import com.example.dsrmobile.sobat.util.Util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dsrmobile.sobat.Model.Anak;
import com.example.dsrmobile.sobat.Model.DataFisikAnak;
import com.example.dsrmobile.sobat.Model.Ibu;

import java.time.LocalDate;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    LinearLayout catat1,catat2,profile,konsul,forum,imunisasi,anak, notif;
    ListView listAnak;

    ArrayList<Anak> anakArrayList;
    private static AnakAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData", MODE_PRIVATE);
        String idIbu = sharedPreferences.getString("idIbu", null);

        catat1 = (LinearLayout) findViewById(R.id.catat1);
        catat2 = (LinearLayout) findViewById(R.id.catat2);
        profile = (LinearLayout) findViewById(R.id.profile);
        konsul = (LinearLayout) findViewById(R.id.konsul);
        forum = (LinearLayout) findViewById(R.id.forum);
        imunisasi = (LinearLayout) findViewById(R.id.imunisasi);
        notif = (LinearLayout) findViewById(R.id.notif);

        listAnak = (ListView) findViewById(R.id.listAnak);
        anakArrayList = new ArrayList<>();
        anakArrayList = Util.cariAnakByIdIbu(Util.getAllAnak(),idIbu);

        adapter = new AnakAdapter(anakArrayList,getApplicationContext());
        listAnak.setAdapter(adapter);

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
                Intent intent = new Intent(MainActivity.this, ListDokter.class);
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

        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Notifikasi.class);
                startActivity(intent);
            }
        });

        listAnak.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String idAnak = (String) view.getTag(R.id.idAnak);
                Intent intent = new Intent(MainActivity.this, DetailCatat.class);
                // Menyertakan idAnak sebagai ekstra dalam Intent
                intent.putExtra("idAnak", idAnak);
                startActivity(intent);
            }
        });
    }
}
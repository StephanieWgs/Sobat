package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dsrmobile.sobat.Adapter.AnakAdapter;
import com.example.dsrmobile.sobat.Model.Anak;
import com.example.dsrmobile.sobat.util.Util;

import java.util.ArrayList;

public class Profil extends AppCompatActivity {
    TextView namaIbu, tglLahirIbu;
    LinearLayout catat,home,updateProfilIbu,logout, tambahAnak, notif;
    ListView listAnak;

    ArrayList<Anak> anakArrayList;
    private static AnakAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData", MODE_PRIVATE);
        String idIbu = sharedPreferences.getString("idIbu", null);

        catat = (LinearLayout) findViewById(R.id.catat);
        home = (LinearLayout) findViewById(R.id.home);
        updateProfilIbu = (LinearLayout) findViewById(R.id.updateProfilIbu);
        logout = (LinearLayout) findViewById(R.id.logout);
        tambahAnak = (LinearLayout) findViewById(R.id.tambahAnak);
        notif = (LinearLayout) findViewById(R.id.notif);

        listAnak = (ListView) findViewById(R.id.listAnak);
        anakArrayList = new ArrayList<>();
        anakArrayList = Util.cariAnakByIdIbu(Util.getAllAnak(),idIbu);

        adapter = new AnakAdapter(anakArrayList,getApplicationContext());
        listAnak.setAdapter(adapter);

        namaIbu = (TextView) findViewById(R.id.namaIbu);
        namaIbu.setText(Util.getNamaIbu(idIbu));

        tglLahirIbu = (TextView) findViewById(R.id.tglLahirIbu);
        tglLahirIbu.setText(Util.getTglLahirIbu(idIbu));

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

        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profil.this, Notifikasi.class);
                startActivity(intent);
            }
        });

        listAnak.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String idAnak = (String) view.getTag(R.id.idAnak);
                Intent intent = new Intent(Profil.this, UpdateProfilAnak.class);
                // Menyertakan idAnak sebagai ekstra dalam Intent
                intent.putExtra("idAnak", idAnak);
                startActivity(intent);
            }
        });

    }
}
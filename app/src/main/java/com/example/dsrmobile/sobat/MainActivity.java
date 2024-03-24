package com.example.dsrmobile.sobat;

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
    ArrayList<Ibu> ibus;
    ArrayList<Anak> anaks;
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

    public void initRealm(){
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(config);

        clearAll();

        simpanDataIbu("1","Santika Putri","08123456789","1990-01-01",
                "ibu1","123");
        simpanDataIbu("2","Lisa","08123456788","1990-01-01",
                "ibu2","123");
        simpanDataIbu("3","Lisa","08123456799","1990-01-01",
                "ibu3","123");

        simpanDataAnak("1","Budi Susanto","2022-02-02",
                "Laki-laki","1");
        simpanDataAnak("1","Budi","2022-02-02",
                "Laki-laki","2");
        simpanDataAnak("1","Susan","2022-02-02",
                "Perempuan","3");

        simpanDataFisik("1","2024-03-24",3,30,20,"1");
        simpanDataFisik("1","2024-03-24",3,30,20,"2");
        simpanDataFisik("1","2024-03-24",3,30,20,"3");


    }

    public void simpanDataIbu(String idIbu, String namaIbu, String noTelp, String tglLahirIbu,
                              String username, String password){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Ibu ibu = realm.createObject(Ibu.class);
                ibu.setIdIbu(idIbu);
                ibu.setNamaIbu(namaIbu);
                ibu.setNoTelp(noTelp);
                ibu.setTglLahirIbu(tglLahirIbu);
                ibu.getUserLogin().setUsername(username);
                ibu.getUserLogin().setPassword(password);
            }
        });
        realm.close();
    }

    public void simpanDataAnak(String idAnak, String namaAnak, String tglLahirAnak,
                              String genderAnak, String idIbu){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Anak anak = realm.createObject(Anak.class);
                anak.setIdAnak(idAnak);
                anak.setNamaAnak(namaAnak);
                anak.setTglLahirAnak(tglLahirAnak);
                anak.setGenderAnak(genderAnak);
                anak.setIdIbu(idIbu);
            }
        });
        realm.close();
    }

    public void simpanDataFisik(String idData, String tglData, int berat,
                               int tinggi, int lingkarKepala, String idAnak){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                DataFisikAnak dataFisik = realm.createObject(DataFisikAnak.class);
                dataFisik.setIdData(idData);
                dataFisik.setTglData(tglData);
                dataFisik.setBerat(berat);
                dataFisik.setTinggi(tinggi);
                dataFisik.setLingkarKepala(lingkarKepala);
                dataFisik.setIdAnak(idAnak);
            }
        });
        realm.close();
    }
    public ArrayList<Ibu> getAllIbu(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Ibu> ibus = realm.where(Ibu.class).findAll();
        ArrayList<Ibu> ibuList = new ArrayList<>(ibus);
        return ibuList;
    }

    public ArrayList<Anak> getAllAnak(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Anak> anaks = realm.where(Anak.class).findAll();
        ArrayList<Anak> anakList = new ArrayList<>(anaks);
        return anakList;
    }

    public void clearAll(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
        realm.close();
    }
}
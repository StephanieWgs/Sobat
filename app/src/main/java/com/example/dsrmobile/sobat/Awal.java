package com.example.dsrmobile.sobat;

import com.example.dsrmobile.sobat.Model.Anak;
import com.example.dsrmobile.sobat.Model.Ibu;
import com.example.dsrmobile.sobat.util.Util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Awal extends AppCompatActivity {
    ArrayList<Ibu> ibus;
    ArrayList<Anak> anaks;
    LinearLayout login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);
        initRealm();

        login = (LinearLayout) findViewById(R.id.login);
        register = (LinearLayout) findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Awal.this, Login.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Awal.this, Register.class);
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

        Util.clearAll();
        Util.simpanDataIbu("1","Santika Putri","08123456789","1990-01-01",
                "ibu1","123");
        Util.simpanDataIbu("2","Lisa","08123456788","1990-01-01",
                "ibu2","123");
        Util.simpanDataIbu("3","Lisa","08123456799","1990-01-01",
                "ibu3","123");

        Util.simpanDataAnak("1","Budi Susanto","2022-02-02",
                "Laki-laki","1");
        Util.simpanDataAnak("2","Linda","2022-02-02",
                "Perempuan","1");
        Util.simpanDataAnak("3","Budi","2022-02-02",
                "Laki-laki","2");
        Util.simpanDataAnak("4","Susan","2022-02-02",
                "Perempuan","3");

        Util.simpanDataFisik("1","2024-03-24",3,30,20,"1");
        Util.simpanDataFisik("2","2024-03-24",3,30,20,"2");
        Util.simpanDataFisik("3","2024-03-24",3,30,20,"3");
    }
}
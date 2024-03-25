package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Catat extends AppCompatActivity {

    LinearLayout home,profile,detailCatat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catat);

        home = (LinearLayout) findViewById(R.id.home);
        profile = (LinearLayout) findViewById(R.id.profile);
        detailCatat = (LinearLayout) findViewById(R.id.detailCatat);

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

        detailCatat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Catat.this, DetailCatat.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Forum extends AppCompatActivity {

    LinearLayout detailForum1,detailForum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        detailForum1 = (LinearLayout) findViewById(R.id.detailForum1);
        detailForum2 = (LinearLayout) findViewById(R.id.detailForum2);

        detailForum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forum.this, DetailForum.class);
                startActivity(intent);
            }
        });

        detailForum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forum.this, DetailForum.class);
                startActivity(intent);
            }
        });
    }
}
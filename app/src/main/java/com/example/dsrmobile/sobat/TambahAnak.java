package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dsrmobile.sobat.util.Util;

public class TambahAnak extends AppCompatActivity {

    LinearLayout back, tambah;
    EditText namaAnak, tglLahirAnak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_anak);

        SharedPreferences sharedPreferences = getSharedPreferences("loginData", MODE_PRIVATE);
        String idIbu = sharedPreferences.getString("idIbu", null);

        back = (LinearLayout) findViewById(R.id.back);
        tambah = (LinearLayout) findViewById(R.id.tambah);
        namaAnak = (EditText) findViewById(R.id.namaAnak);
        tglLahirAnak = (EditText) findViewById(R.id.tglLahirAnak);
        Spinner genderAnak = (Spinner) findViewById(R.id.genderAnak);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gender,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderAnak.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = namaAnak.getText().toString();
                String tglLahir = tglLahirAnak.getText().toString();
                String gender = genderAnak.getSelectedItem().toString();

                String message = "";

                if(!nama.equals("") && !tglLahir.equals("")){
                    Util.simpanDataAnak(Util.idAnakBaru(), nama,tglLahir,gender,idIbu);

                    Intent intent = new Intent(TambahAnak.this, Profil.class);
                    startActivity(intent);

                    message = "Profil anak berhasil ditambah!";
                }
                else{
                    message = "Isi data dengan lengkap...";
                }
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(TambahAnak.this, message, duration);
                toast.show();
            }
        });
    }
}
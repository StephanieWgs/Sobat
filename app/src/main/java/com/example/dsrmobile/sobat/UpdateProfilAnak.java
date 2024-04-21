package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dsrmobile.sobat.util.Util;

public class UpdateProfilAnak extends AppCompatActivity {

    LinearLayout back,ubah;
    TextView nama1;
    EditText nama2, tglLahir;

    ImageView fotoAnak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profil_anak);

        // Mendapatkan Intent yang memulai aktivitas ini
        Intent intent = getIntent();

        // Menangkap nilai idAnak dari ekstra Intent
        String idAnak = intent.getStringExtra("idAnak");

        Spinner genderAnak = (Spinner) findViewById(R.id.genderAnak);
        back = (LinearLayout) findViewById(R.id.back);
        ubah = (LinearLayout) findViewById(R.id.ubah);

        nama1 = (TextView) findViewById(R.id.nama1);
        nama1.setText(Util.getNamaAnak(idAnak));

        nama2 = (EditText) findViewById(R.id.nama2);
        nama2.setText(Util.getNamaAnak(idAnak));

        tglLahir = (EditText) findViewById(R.id.tglLahir);
        tglLahir.setText(Util.getTglLahirAnak(idAnak));

        fotoAnak = (ImageView) findViewById(R.id.fotoAnak);
        if (Util.getGenderAnak(idAnak).equalsIgnoreCase("Laki-laki")){
            fotoAnak.setImageResource(R.drawable.boy_add_photo);
        }
        else{
            fotoAnak.setImageResource(R.drawable.girl_add_photo);
        }

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

        ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaAnak = nama2.getText().toString();
                String tglLahirAnak = tglLahir.getText().toString();
                String gender = genderAnak.getSelectedItem().toString();
                Util.updateProfilAnak(idAnak, namaAnak, tglLahirAnak, gender);

                Intent intent = new Intent(UpdateProfilAnak.this, Profil.class);
                startActivity(intent);

                String message = "Profil Anak berhasil di-update";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(UpdateProfilAnak.this, message, duration);
                toast.show();
            }
        });
    }
}
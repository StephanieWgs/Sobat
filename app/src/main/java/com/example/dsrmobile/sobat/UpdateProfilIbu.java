package com.example.dsrmobile.sobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dsrmobile.sobat.util.Util;

public class UpdateProfilIbu extends AppCompatActivity {
    LinearLayout back, ubah;
    EditText nama2, tglLahir, noTelp;
    TextView nama1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profil_ibu);

        SharedPreferences sharedPreferences = getSharedPreferences("loginData", MODE_PRIVATE);
        String idIbu = sharedPreferences.getString("idIbu", null);


        back = (LinearLayout) findViewById(R.id.back);
        ubah = (LinearLayout) findViewById(R.id.ubah);

        nama1 = (TextView) findViewById(R.id.nama1);
        nama1.setText(Util.getNamaIbu(idIbu));

        nama2 = (EditText) findViewById(R.id.nama2);
        nama2.setText(Util.getNamaIbu(idIbu));

        tglLahir = (EditText) findViewById(R.id.tglLahir);
        tglLahir.setText(Util.getTglLahirIbu(idIbu));

        noTelp = (EditText) findViewById(R.id.noTelp);
        noTelp.setText(Util.getNoTelpIbu(idIbu));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaIbu = nama2.getText().toString();
                String tglLahirIbu = tglLahir.getText().toString();
                String noTelpIbu = noTelp.getText().toString();
                Util.updateProfilIbu(idIbu, namaIbu, tglLahirIbu, noTelpIbu);

                Intent intent = new Intent(UpdateProfilIbu.this, Profil.class);
                startActivity(intent);

                String message = "Profil Ibu berhasil di-update";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(UpdateProfilIbu.this, message, duration);
                toast.show();
            }
        });
    }
}
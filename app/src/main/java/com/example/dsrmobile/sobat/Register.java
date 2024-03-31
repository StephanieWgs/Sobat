package com.example.dsrmobile.sobat;

import com.example.dsrmobile.sobat.util.Util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dsrmobile.sobat.Model.Ibu;
import com.example.dsrmobile.sobat.Model.UserLogin;

import io.realm.Realm;

public class Register extends AppCompatActivity {

    LinearLayout register;
    EditText nama, noTelp,tglLahir, username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (LinearLayout) findViewById(R.id.register);

        nama = (EditText) findViewById(R.id.nama);
        noTelp = (EditText) findViewById(R.id.noTelp);
        tglLahir = (EditText) findViewById(R.id.tglLahir);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataNama = nama.getText().toString();
                String dataNoTelp = noTelp.getText().toString();
                String dataTglLahir = tglLahir.getText().toString();
                String dataUsername = username.getText().toString();
                String dataPassword = password.getText().toString();
                Util.simpanDataIbu(Util.idIbuBaru(),dataNama,dataNoTelp,dataTglLahir,
                        dataUsername,dataPassword);
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);

                String message = "Akun berhasil dibuat";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(Register.this, message, duration);
                toast.show();
            }
        });
    }

}
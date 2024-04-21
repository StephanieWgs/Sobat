package com.example.dsrmobile.sobat;

import com.example.dsrmobile.sobat.util.Util;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.content.SharedPreferences;

public class Login extends AppCompatActivity {

    LinearLayout login, back;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (LinearLayout) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        back = (LinearLayout) findViewById(R.id.back);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Username atau password salah";
                String dataUsername = username.getText().toString();
                String dataPassword = password.getText().toString();

                if (Util.cekKredensial(dataUsername, dataPassword)){
                    message = "Login berhasil! Selamat Datang, Mums!";

                    // Simpan ID login ke SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("loginData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("idIbu", Util.getIdIbu(dataUsername));
                    editor.apply();

                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(Login.this, message, duration);
                toast.show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
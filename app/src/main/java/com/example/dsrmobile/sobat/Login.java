package com.example.dsrmobile.sobat;

import com.example.dsrmobile.sobat.util.Util;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    LinearLayout login;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (LinearLayout) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Username atau password salah";
                String dataUsername = username.getText().toString();
                String dataPassword = password.getText().toString();

                if (Util.cekKredensial(dataUsername, dataPassword)){
                    message = "Login berhasil! Selamat Datang, Mums!";
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(Login.this, message, duration);
                toast.show();
            }
        });
    }
}
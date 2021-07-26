package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.adg_vit_final.R;

public class Login extends AppCompatActivity {
    private TextView btnNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        btnNewAccount = findViewById(R.id.login_createAccount);

        btnNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Signup1.class));
            }
        });

    }
}
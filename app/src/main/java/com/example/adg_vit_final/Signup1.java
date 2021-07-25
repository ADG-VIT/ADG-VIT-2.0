package com.example.adg_vit_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Signup1 extends AppCompatActivity {
    private TextView login;
    private EditText name,email,password,confirm_password;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        getSupportActionBar().hide();

        login = findViewById(R.id.signup1_login);
        name = findViewById(R.id.signup1_name);
        email = findViewById(R.id.signup1_email);
        password = findViewById(R.id.signup1_password);
        confirm_password = findViewById(R.id.signup1_confirm_password);
        next = findViewById(R.id.next_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent for the login page
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent for the next page
                startActivity(new Intent(getApplicationContext(), SignUpTwo.class));
            }
        });
    }
}
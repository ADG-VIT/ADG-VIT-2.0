package com.adgvit.externals.JavaActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.adgvit.externals.R;

public class FirstBoarding extends AppCompatActivity {
    TextView about;
    Button loginBtn, createAccountBtn;
    ImageView cross;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_boarding);


        getSupportActionBar().hide();

        SharedPreferences sharedPreferences= getSharedPreferences("com.adgvit.externals",MODE_PRIVATE);
        String token = sharedPreferences.getString("Token","");

        String themeChosen = getSharedPreferences("Appearance_shared_pref", MODE_PRIVATE)
                .getString("theme", "sys_def");
        if (themeChosen.equals("light"))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else if (themeChosen.equals("dark"))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        if(!token.equals(""))
        {
            Intent intent = new Intent(FirstBoarding.this,Home.class);
            startActivity(intent);
        }

        about= findViewById(R.id.about);
        cross = findViewById(R.id.first_cross);
        loginBtn = findViewById(R.id.login_btn);
        createAccountBtn = findViewById(R.id.create_acct_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Signup1.class));
            }
        });

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               startActivity(new Intent(getApplicationContext(),Home.class));
               finish();
            }
        });

    }

}
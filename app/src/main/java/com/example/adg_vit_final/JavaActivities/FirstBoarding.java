package com.example.adg_vit_final.JavaActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.adg_vit_final.R;

public class FirstBoarding extends AppCompatActivity {
    TextView about;
    Button loginBtn, createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_boarding);

        getSupportActionBar().hide();
        String themeChosen = getSharedPreferences("Appearance_shared_pref", MODE_PRIVATE)
                .getString("theme", "sys_def");
        if (themeChosen.equals("light"))
        {Toast.makeText(this, "light", Toast.LENGTH_SHORT).show();
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);}
        else if (themeChosen.equals("dark"))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        about= findViewById(R.id.about);
        loginBtn = findViewById(R.id.login_btn);
        createAccountBtn = findViewById(R.id.create_acct_btn);
        about.setText("Lorem ipsum dolor sit amet. 33 deleniti sint a quisquam velit sed porro voluptatum aut possimus enim nam minima aspernatur et ");
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


    }
}
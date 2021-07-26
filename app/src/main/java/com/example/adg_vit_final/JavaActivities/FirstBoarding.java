package com.example.adg_vit_final.JavaActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adg_vit_final.R;

public class FirstBoarding extends AppCompatActivity {
    TextView about;
    Button loginBtn, createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_boarding);

        getSupportActionBar().hide();

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
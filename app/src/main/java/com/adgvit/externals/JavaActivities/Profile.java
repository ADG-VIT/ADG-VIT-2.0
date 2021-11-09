package com.adgvit.externals.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.adgvit.externals.R;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences.Editor editor = getSharedPreferences("com.adgvit.externals", MODE_PRIVATE).edit();
        editor.putString("Token", "");
        editor.apply();

        startActivity(new Intent(Profile.this, FirstBoarding.class));
    }
}
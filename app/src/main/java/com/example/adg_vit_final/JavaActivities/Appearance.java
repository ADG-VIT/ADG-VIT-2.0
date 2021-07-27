package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.ThemeUtils;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.adg_vit_final.R;

import okhttp3.internal.Util;

public class Appearance extends AppCompatActivity {

    RadioGroup radioGroupThemeChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance);

        getSupportActionBar().hide();

        SharedPreferences.Editor editor = getSharedPreferences("Appearance_shared_pref", MODE_PRIVATE).edit();

        radioGroupThemeChanger = findViewById(R.id.radio_group_theme_changer);

        radioGroupThemeChanger.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_sys_def){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    editor.putString("theme", "sys_def");
                    Toast.makeText(Appearance.this, "System Default", Toast.LENGTH_SHORT).show();
                }
                else if (checkedId == R.id.rb_light_mode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putString("theme", "light");
                    Toast.makeText(Appearance.this, "Light Mode", Toast.LENGTH_SHORT).show();
                }
                else if (checkedId == R.id.rb_dark_mode){
                    editor.putString("theme", "dark");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Toast.makeText(Appearance.this, "Dark Mode", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
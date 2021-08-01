package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.ThemeUtils;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.adg_vit_final.R;

import okhttp3.internal.Util;

public class Appearance extends AppCompatActivity {

    private RadioGroup radioGroupThemeChanger;
    private RadioButton radioButtonSysDef, radioButtonLight, radioButtonDark;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance);

        getSupportActionBar().hide();

        SharedPreferences.Editor editor = getSharedPreferences("Appearance_shared_pref", MODE_PRIVATE).edit();

        radioGroupThemeChanger = findViewById(R.id.radio_group_theme_changer);
        radioButtonSysDef = findViewById(R.id.rb_sys_def);
        radioButtonLight = findViewById(R.id.rb_light_mode);
        radioButtonDark = findViewById(R.id.rb_dark_mode);
        back = findViewById(R.id.appearance_back);

        String themeChosen = getSharedPreferences("Appearance_shared_pref", MODE_PRIVATE)
                .getString("theme", "sys_def");
        radioButtonSysDef.setChecked(true);
        if (themeChosen.equals("light"))
            radioButtonLight.setChecked(true);
        else if (themeChosen.equals("dark"))
            radioButtonDark.setChecked(true);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        radioGroupThemeChanger.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_sys_def){
                    radioButtonSysDef.setChecked(true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    editor.putString("theme", "sys_def");
                    editor.apply();
                }
                else if (checkedId == R.id.rb_light_mode){
                    radioButtonLight.setChecked(true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putString("theme", "light");
                    editor.apply();
                }
                else if (checkedId == R.id.rb_dark_mode){
                    radioButtonDark.setChecked(true);
                    editor.putString("theme", "dark");
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            }
        });
    }
}
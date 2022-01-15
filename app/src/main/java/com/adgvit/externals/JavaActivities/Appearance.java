package com.adgvit.externals.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.adgvit.externals.R;
import com.adgvit.externals.RecyclerViewAdapter.Settings_Adapter;

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
        back = findViewById(R.id.noti_back);

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
        Intent intent = getIntent();
        try{
            radioGroupThemeChanger.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == R.id.rb_sys_def){

//                        radioButtonSysDef.setChecked(true);

                        editor.putString("theme", "sys_def");

                        editor.apply();
                        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
//                        startActivity(getIntent());
//                        finish();
//                        startActivity(getIntent());
//                        startActivity(new Intent(Settings_Adapter.intent));
                    }
                    else if (checkedId == R.id.rb_light_mode){
//                        radioButtonLight.setChecked(true);
                        editor.putString("theme", "light");
                        editor.apply();
                        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                        startActivity(getIntent());
//                        finish();
//                        startActivity(new Intent(Settings_Adapter.intent));
                    }
                    else if (checkedId == R.id.rb_dark_mode){
//                        radioButtonDark.setChecked(true);
                        editor.putString("theme", "dark");
                        editor.apply();
                        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                        startActivity(getIntent());
//                        finish();
//                        startActivity(getIntent());
//                        startActivity(new Intent(Settings_Adapter.intent));
                    }
                }
            });
        }
        catch (Exception e){
            Log.i("Theme error", e.getMessage());
        }


    }
}
package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.adg_vit_final.R;

public class Notofication extends AppCompatActivity {
    private RadioGroup radioGroupNoti;
    private RadioButton radioButtonOn, radioButtonOff;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notofication);
        getSupportActionBar().hide();

        radioGroupNoti=findViewById(R.id.radio_group_noti);
        radioButtonOff=findViewById(R.id.notiOff);
        radioButtonOn=findViewById(R.id.notiOn);


        back = findViewById(R.id.noti_back);

        SharedPreferences sharedPreferences = getSharedPreferences("Notification",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String notiDet = sharedPreferences.getString("Notification","On");
        radioButtonOn.setChecked(true);
        if(notiDet.equals("Off")){
            radioButtonOff.setChecked(true);
        }
        radioGroupNoti.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.notiOn){
                    editor.putString("Notification","On");
                    radioButtonOn.setChecked(true);
                    editor.apply();
                }
                else if(i==R.id.notiOff){
                    editor.putString("Notification","Off");
                    radioButtonOff.setChecked(true);
                    editor.apply();
                }
            }
        });


    }
}
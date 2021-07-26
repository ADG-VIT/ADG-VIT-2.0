package com.example.adg_vit_final.JavaActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.adg_vit_final.R;

public class EventDetails extends AppCompatActivity {

    private Button register;
    private TextView title,date,desc;
    ImageView img;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventdetails);

        getSupportActionBar().hide();

        img = findViewById(R.id.eventdet_image);
        register = findViewById(R.id.register_btn);
        title = findViewById(R.id.eventdet_title);
        date = findViewById(R.id.eventdet_date);
        desc = findViewById(R.id.eventdet_details);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent for registering
            }
        });
    }
}

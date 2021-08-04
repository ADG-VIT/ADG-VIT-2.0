package com.example.adg_vit_final.JavaActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.adg_vit_final.NetworkModels.EventModelNetwork;
import com.example.adg_vit_final.R;

import retrofit2.Call;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.getDate;
import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

public class EventDetails extends AppCompatActivity {

    private String eventId, eventImageUrl, eventTitle, eventInfo;
    private int eventDate;
    private Button register;
    private TextView title,date,desc;
    private ImageView img;
    private LinearLayout back;
    private TextView share;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventdetails);

        getSupportActionBar().hide();

        eventId = getIntent().getExtras().getString("event_id");
        eventImageUrl = getIntent().getExtras().getString("image_url");
        eventTitle = getIntent().getExtras().getString("title");
        eventDate = getIntent().getExtras().getInt("date");
        eventInfo = getIntent().getExtras().getString("info");


        img = findViewById(R.id.eventdet_image);
        register = findViewById(R.id.register_btn);
        title = findViewById(R.id.eventdet_title);
        date = findViewById(R.id.eventdet_date);
        desc = findViewById(R.id.eventdet_details);
        back = findViewById(R.id.eventdet_back);
        share = findViewById(R.id.eventdet_share);

        Glide.with(this)
                .load(eventImageUrl)
                .into(img);
        title.setText(eventTitle);
        date.setText(getDate(eventDate));
        desc.setText(eventInfo);


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for sharing
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent for registering
            }
        });
    }
}

package com.example.adg_vit_final.JavaActivities;

import android.app.ProgressDialog;
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
import retrofit2.Callback;
import retrofit2.Response;

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
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventdetails);

        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Event...");
        progressDialog.show();

        try{
            eventId = getIntent().getExtras().getString("event_id");
            Call<EventModelNetwork> call = networkAPI.getEvent(eventId);

            call.enqueue(new Callback<EventModelNetwork>() {
                @Override
                public void onResponse(Call<EventModelNetwork> call, Response<EventModelNetwork> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(EventDetails.this, "Code : " + response.code() + " , Reason : " + response.message(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    progressDialog.dismiss();
                    EventModelNetwork data = response.body();

                    Glide.with(EventDetails.this)
                            .load(data.getPosterURL())
                            .into(img);
                    title.setText(data.getName());
                    date.setText(getDate(data.getDate()));
                    desc.setText(data.getInfo());

                }

                @Override
                public void onFailure(Call<EventModelNetwork> call, Throwable t) {
                    Toast.makeText(EventDetails.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e){
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        img = findViewById(R.id.eventdet_image);
        register = findViewById(R.id.register_btn);
        title = findViewById(R.id.eventdet_title);
        date = findViewById(R.id.eventdet_date);
        desc = findViewById(R.id.eventdet_details);
        back = findViewById(R.id.eventdet_back);
        share = findViewById(R.id.eventdet_share);


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

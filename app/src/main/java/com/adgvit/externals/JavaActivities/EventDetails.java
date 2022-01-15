package com.adgvit.externals.JavaActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.adgvit.externals.NetworkInterface.NetworkAPI;
import com.adgvit.externals.NetworkModels.resetPass;
import com.adgvit.externals.NetworkUtil.NetworkUtils;
import com.bumptech.glide.Glide;
import com.adgvit.externals.NetworkModels.EventModelNetwork;
import com.adgvit.externals.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.adgvit.externals.NetworkUtil.NetworkUtils.getDate;
import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EventDetails extends AppCompatActivity {

    private String eventId, eventImageUrl, eventTitle, eventInfo;
    private int eventDate;
    private Button register;
    private TextView title,date,desc;
    private ImageView img;
    private LinearLayout back;
    private List<String> regUsers;
    private TextView share;
    private ProgressDialog progressDialog;
    private boolean isDone;
    private String token;
    private int flag;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventdetails);

        getSupportActionBar().hide();
        regUsers = new ArrayList<>();

        flag = 0;

        progressDialog = new ProgressDialog(this);
        isDone=false;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isDone){

                }
                else {
                    progressDialog.show();
                }
            }
        },400);

        try{
            eventId = getIntent().getExtras().getString("event_id");
            Call<EventModelNetwork> call = networkAPI.getSpecificEvent(eventId);

            call.enqueue(new Callback<EventModelNetwork>() {
                @Override
                public void onResponse(Call<EventModelNetwork> call, Response<EventModelNetwork> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(EventDetails.this, "Code : " + response.code() + " , Reason : " + response.message(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    EventModelNetwork data = response.body();

                    Glide.with(EventDetails.this)
                            .load(data.getPosterURL())
                            .into(img);
                    title.setText(data.getName());
                    date.setText(getDate(data.getDate()));
                    desc.setText(data.getInfo());
                    try {
                        regUsers.addAll(data.getRegUsers());
                    }
                    catch (Exception e)
                    {
                        flag = 1;
                    }
                    isDone = true;
                    progressDialog.dismiss();
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
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                // Add data to the intent, the receiving app will decide
                // what to do with it.
                share.putExtra(Intent.EXTRA_TEXT, "ADG-VIT PRESENTS\nEvent : " + title.getText() + "\nDate : " + date.getText() + "\nDetails : " + desc.getText() + "\nApp Link : https://play.google.com/store/apps/details?id=com.adgvit.externals");

                startActivity(Intent.createChooser(share, "Share this event"));
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
                SharedPreferences sh = getSharedPreferences("com.adgvit.externals", MODE_PRIVATE);
                String token = sh.getString("Token","");
                String id = sh.getString("id","");
                if(regUsers.contains(id))
                {
                    Toast.makeText(getApplicationContext(),"User already registered for this event. Redirecting to Vtop...",Toast.LENGTH_LONG).show();
                    String url = "https://vtop.vit.ac.in/vtop/initialProcess";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                else {
                    try{
                        Call<resetPass> call = networkAPI.registerEvent(eventId,token);
                        call.enqueue(new Callback<resetPass>() {
                            @Override
                            public void onResponse(Call<resetPass> call, Response<resetPass> response) {
                                if(!response.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                                    return;
                                }

                                if(response.code()==200){
                                    Toast.makeText(getApplicationContext(), response.body().getMessage() + " Redirecting to Vtop", Toast.LENGTH_LONG).show();
                                    String url = "https://vtop.vit.ac.in/vtop/initialProcess";
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(url));
                                    startActivity(i);
                                }
                                else{

                                    Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<resetPass> call, Throwable t) {
                                Toast.makeText(EventDetails.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    catch (Exception e){
                        Log.i("Error", e.getMessage());
                    }

                }
            }
        });
    }
}

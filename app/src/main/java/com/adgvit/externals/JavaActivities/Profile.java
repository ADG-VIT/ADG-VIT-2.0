package com.adgvit.externals.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adgvit.externals.NetworkModels.User;
import com.adgvit.externals.NetworkUtil.NetworkUtils;
import com.adgvit.externals.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {

    TextView textViewName, textViewClg, textViewEmail, textViewNumber;
    Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();

        textViewName = findViewById(R.id.textview_name);
        textViewClg = findViewById(R.id.textview_clg);
        textViewEmail = findViewById(R.id.textview_email);
        textViewNumber = findViewById(R.id.textview_number);

        buttonLogout = findViewById(R.id.button_logout);
        
        SharedPreferences sh = getSharedPreferences("com.adgvit.externals", MODE_PRIVATE);
        String token = sh.getString("Token","");

        Call<User> call = NetworkUtils.networkAPI.getUserInfo(token);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "" + response.code(), Toast.LENGTH_SHORT).show();
                }
                User user = response.body();
                textViewName.setText(user.getName());
                textViewClg.setText(user.getUniversity());
                textViewEmail.setText(user.getEmail());
                textViewNumber.setText(user.getPhone());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("com.adgvit.externals", MODE_PRIVATE).edit();
                editor.putString("Token", "");
                editor.apply();
                startActivity(new Intent(Profile.this, FirstBoarding.class));
            }
        });
        
    }
}
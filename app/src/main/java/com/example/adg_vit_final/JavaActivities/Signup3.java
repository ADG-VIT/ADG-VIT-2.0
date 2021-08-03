package com.example.adg_vit_final.JavaActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adg_vit_final.Interfaces.RegisterUserApi;
import com.example.adg_vit_final.Objects.User;
import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Signup3 extends AppCompatActivity {
    private EditText nameofUni;
    private Button create;
    private User user;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);

        getSupportActionBar().hide();

        intent = getIntent();
        user = (User)intent.getSerializableExtra("User");

        nameofUni = findViewById(R.id.signup3_nameofuni);
        create = findViewById(R.id.signup3_create);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //For creating account
                user.setUniversity(nameofUni.getText().toString());
                registerUser();
            }
        });
    }

    private void registerUser() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://backend-events.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterUserApi registerUserApi = retrofit.create(RegisterUserApi.class);

        Call<User> call = registerUserApi.registerUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NotNull Call<User> call, @NotNull Response<User> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Code : " + response.code() + " , Error : " + response.message(),Toast.LENGTH_LONG).show();
                    return;
                }
                User responseUser = response.body();
                assert responseUser != null;
                String message = responseUser.getMessage();
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getApplicationContext(),Login.class);
                startActivity(intent1);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error : " + t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
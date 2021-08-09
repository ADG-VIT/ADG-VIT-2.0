package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

import com.example.adg_vit_final.NetworkModels.LoginModelNetwork;
import com.example.adg_vit_final.NetworkModels.User;
import com.example.adg_vit_final.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

public class Login extends AppCompatActivity {
    private TextView btnNewAccount;
    Button buttonLogin;
    private EditText email, password;
    TextView content;
    private Intent intent;
    private LoginModelNetwork login;
    private String Email, Password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor myEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        sharedPreferences = getSharedPreferences("MySharedPreference",MODE_PRIVATE);
        myEdit = sharedPreferences.edit();


        intent = getIntent();
        login = (LoginModelNetwork) intent.getSerializableExtra("LoginModelNetwork");

        btnNewAccount = findViewById(R.id.login_createAccount);
        buttonLogin = findViewById(R.id.login_button);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);

        btnNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Signup1.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = email.getText().toString();
                Password = password.getText().toString();
                login = new LoginModelNetwork();
                login.setEmail(Email);
                login.setPassword(Password);
                loginUser();
            }
        });
    }

    //loginUser
    private void loginUser() {
        Call<LoginModelNetwork> call = networkAPI.loginUser(login);

        call.enqueue(new Callback<LoginModelNetwork>() {

            @Override
            public void onResponse(@NotNull Call<LoginModelNetwork> call, @NotNull Response<LoginModelNetwork> response) {
                if (!response.isSuccessful()){
                    try {
                        LoginModelNetwork loginresp = response.body();
                        Toast.makeText(getApplicationContext(), "Error : " + loginresp.getMessage() + "code : " + response.code(), Toast.LENGTH_LONG).show();
                    }catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Some error has occured, Try Again",Toast.LENGTH_LONG).show();
                    }
                    return;
                }
                LoginModelNetwork loginresp = response.body();
                assert loginresp != null;
                String message = loginresp.getMessage();
                String token = loginresp.getToken();
                myEdit.putString("Token", token);
                myEdit.commit();
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getApplicationContext(),Home.class);
                startActivity(intent1);
            }

            @Override
            public void onFailure(Call<LoginModelNetwork> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("TAG", "" + t.getMessage());
            }
        });
    }
}
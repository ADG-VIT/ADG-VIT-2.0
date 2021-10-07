package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.example.adg_vit_final.NetworkModels.LoginModelNetwork;
import com.example.adg_vit_final.NetworkModels.SignUpCallBack;
import com.example.adg_vit_final.NetworkModels.User;
import com.example.adg_vit_final.NetworkUtil.NetworkUtils;
import com.example.adg_vit_final.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

public class Login extends AppCompatActivity {
    private TextView btnNewAccount;
    Button buttonLogin;
    private EditText email, password;
    private String Email, Password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor myEdit;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        sharedPreferences = getSharedPreferences("com.adgvit.externals",MODE_PRIVATE);
        myEdit = sharedPreferences.edit();

        progressDialog = new ProgressDialog(this);
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
                progressDialog.show();
                Email = email.getText().toString();
                Password = password.getText().toString();
                LoginModelNetwork login = new LoginModelNetwork(Email,Password);
                loginUser(login);
            }
        });
    }

    //loginUser
    private void loginUser(LoginModelNetwork login) {
        Call<SignUpCallBack> call = networkAPI.loginUser(login);
        call.enqueue(new Callback<SignUpCallBack>() {
            @Override
            public void onResponse(Call<SignUpCallBack> call, Response<SignUpCallBack> response) {
                try {
                    Log.i("responseCode",String.valueOf(response.code()));
                    SignUpCallBack callBack=response.body();
                    ResponseBody error = response.errorBody();
                    if (response.code()==401){
                        Gson gson = new Gson();
                        Type type = new TypeToken<SignUpCallBack>() {}.getType();
                        SignUpCallBack errorResponse = gson.fromJson(response.errorBody().charStream(),type);
                        Log.i("message",errorResponse.getMessage());
                    }
                }catch (Exception e){
                    Log.i("hello",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<SignUpCallBack> call, Throwable t) {

            }
        });
    }
}
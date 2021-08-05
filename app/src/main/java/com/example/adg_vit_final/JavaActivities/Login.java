package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.json.JSONException;

import com.example.adg_vit_final.NetworkModels.LoginModelNetwork;
import com.example.adg_vit_final.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

public class Login extends AppCompatActivity {
    private TextView btnNewAccount;
    Button buttonLogin;
    EditText emailAddr;
    EditText password;
    TextView content;
    LoginModelNetwork login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        btnNewAccount = findViewById(R.id.login_createAccount);
        buttonLogin = findViewById(R.id.login_button);
        emailAddr = findViewById(R.id.login_email);
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
                try {
                    checkLogin();
                    //startActivity(new Intent(getApplicationContext(), Home.class));
                }

                catch(Exception e) {
                    content.setText("URL Exception!");
                }
            }
        });
    }

    //checkLogin
    public void checkLogin() {
        Call<LoginModelNetwork> call = networkAPI.loginUser(login);

        call.enqueue(new Callback<LoginModelNetwork>() {

            @Override
            public void onResponse(@NotNull Call<LoginModelNetwork> call, @NotNull Response<LoginModelNetwork> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Login.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                LoginModelNetwork loginresp = response.body();
                assert loginresp != null;
                String message = loginresp.getToken() + loginresp.getMessage();
                System.out.println(message);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
/*
                if (response.isSuccessful()) {
                    try {
                        LoginModelNetwork jsonresponse = response.body();
                        JSONObject jsonObject = new JSONObject(response);
                        token = jsonObject.getString("Token");
                        message = jsonObject.getString("message");
                        System.out.println("Token: " + token);
                        System.out.println("message: " + message);
                    }
                    catch(JSONException e) {

                    }
                } else {
                    Toast.makeText(Login.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                }
 */
            }

            @Override
            public void onFailure(Call<LoginModelNetwork> call, Throwable t) {
                Toast.makeText(Login.this, "" + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("TAG", "" + t.getMessage());
            }
        });
    }

    /*
    public void parseLoginData(String response) {
        String token = null;
        String message = null;

        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {

                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    token = dataobj.getString("Token");
                    message = dataobj.getString("message");
                }

                Toast.makeText(getApplicationContext(),
                        message+token,Toast.LENGTH_LONG).show();
                System.out.println("Error: " + message+token);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
     */
}
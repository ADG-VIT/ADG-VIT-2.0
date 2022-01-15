package com.adgvit.externals.JavaActivities;

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

import java.lang.reflect.Type;

import com.adgvit.externals.NetworkModels.LoginModelNetwork;
import com.adgvit.externals.NetworkModels.SignUpCallBack;
import com.adgvit.externals.NetworkModels.User;
import com.adgvit.externals.NetworkUtil.NetworkUtils;
import com.adgvit.externals.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;

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
        progressDialog.setMessage("Signing into your Account");
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
                if(Email.equals("") || Password.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter Email and Password", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
                else{
                LoginModelNetwork login = new LoginModelNetwork(Email,Password);
                loginUser(login);

                }
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
                        Log.i("message", errorResponse.getMessage());
                        Toast.makeText(getApplicationContext(),/*"Login failed. Please try again!"*/errorResponse.getMessage(),Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                    else {
                        try {
                            SignUpCallBack loginresp = response.body();
                            String message = loginresp.getMessage();
                            String token = loginresp.getToken();
                            myEdit.putString("Token", token);
                            myEdit.apply();
                            saveUserName();

                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                            Intent intent1 = new Intent(getApplicationContext(),Home.class);
                            progressDialog.dismiss();
                            startActivity(intent1);
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"Login failed. Please try again!",Toast.LENGTH_LONG).show();
                            //System.out.println(e.getLocalizedMessage());
                            progressDialog.dismiss();

                }}}catch (Exception e){
                    Log.i("hello", e.getMessage());
                    Toast.makeText(Login.this, "Log in Failed "+e.getMessage(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<SignUpCallBack> call, Throwable t) {
                Toast.makeText(Login.this, "LogIn Failed" + t.getMessage().toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });

    }
    public void saveUserName(){
        sharedPreferences = getSharedPreferences("com.adgvit.externals", MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
        String token = sharedPreferences.getString("Token","");
        Call<User> call = networkAPI.getUserInfo(token);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    try {
                        User obj = response.body();

                        Toast.makeText(getApplicationContext(),"Error: "+obj.getMessage() + "Code: " + response.code(),Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Some error has occured, Try Again",Toast.LENGTH_LONG).show();
//                        System.out.println(e.getLocalizedMessage());
                    }

                }
                else{
                    try {
                        User obj = response.body();
                        String name = obj.getName();
                        String clg = obj.getUniversity();
                        String id = obj.get_id();
                        myEdit.putString("UserName", name);
                        myEdit.putString("CollegeName", clg);
                        myEdit.putString("id", id);
                        myEdit.commit();
                    }
                    catch (Exception e){
//                        Toast.makeText(getApplicationContext(),"Some Error Occured",Toast.LENGTH_LONG).show();
                    }
                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("Fail",""+t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Login.this, FirstBoarding.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
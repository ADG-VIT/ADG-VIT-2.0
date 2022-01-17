package com.adgvit.externals.JavaActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adgvit.externals.NetworkModels.SignUpCallBack;
import com.adgvit.externals.NetworkModels.User;
import com.adgvit.externals.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;

import java.lang.reflect.Type;

public class Signup3 extends AppCompatActivity {
    private EditText nameofUni;
    private Button create;
    private User user;
    private Intent intent;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);

        getSupportActionBar().hide();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Creating your Account...");

        intent = getIntent();
        user = (User)intent.getSerializableExtra("User");

        nameofUni = findViewById(R.id.signup3_nameofuni);
        create = findViewById(R.id.signup3_create);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //For creating account
                progressDialog.show();
                user.setUniversity(nameofUni.getText().toString());
                System.out.println("Name : " + user.getName());
                System.out.println("Email : " + user.getEmail());
                System.out.println("PhNumber : " + user.getPhone());
                System.out.println("Password : " + user.getPassword());
                System.out.println("Uni : " + user.getUniversity());
                System.out.println("Reg no : " + user.getRegno());
                registerUser();
            }
        });
    }

    private void registerUser() {

        Call<SignUpCallBack> call = networkAPI.registerUser(user);

        call.enqueue(new Callback<SignUpCallBack>() {
            @Override
            public void onResponse(@NotNull Call<SignUpCallBack> call, @NotNull Response<SignUpCallBack> response) {

                try {
                    Log.i("responseCode",String.valueOf(response.code()));
                    SignUpCallBack callBack=response.body();
                    ResponseBody error = response.errorBody();
                    if (response.code()==406){
                        Gson gson = new Gson();
                        Type type = new TypeToken<SignUpCallBack>() {}.getType();
                        SignUpCallBack errorResponse = gson.fromJson(response.errorBody().charStream(),type);
                        Log.i("message", errorResponse.getMessage());
                        Toast.makeText(getApplicationContext(),/*"Account Creation failed. Please try again!"*/"Sign Up Failed : " + errorResponse.getMessage(),Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                    else {
                        try {
                            SignUpCallBack signupresp = response.body();
                            String message = signupresp.getMessage();
                            String token = signupresp.getToken();
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(getApplicationContext(),Login.class);
                            progressDialog.dismiss();
                            startActivity(intent1);
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"SignUp failed. Please try again!",Toast.LENGTH_LONG).show();
                            //System.out.println(e.getLocalizedMessage());
                            progressDialog.dismiss();

                        }}}catch (Exception e){
                    Log.i("hello", e.getMessage());
                    Toast.makeText(Signup3.this, ""+e.getMessage(), Toast.LENGTH_LONG).show();
                }
//                if(response.isSuccessful())
//                {
//                    try {
//                        SignUpCallBack responseUser = response.body();
//                        String message = responseUser.getMessage();
//                        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
//                        Intent intent1 = new Intent(getApplicationContext(),Login.class);
//                        progressDialog.dismiss();
//                        startActivity(intent1);
//                    }catch (Exception e){
//                        Toast.makeText(getApplicationContext(),"SignUp failed. Please try again!",Toast.LENGTH_LONG).show();
//                        Intent intent1 = new Intent(getApplicationContext(),Login.class);
//                        progressDialog.dismiss();
//                        startActivity(intent1);
//                    }
//                }else {
//                    SignUpCallBack responseUser = response.body();
//                    String message = responseUser.getMessage();
//                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
//                    progressDialog.dismiss();
//                    return;
//                }


            }

            @Override
            public void onFailure(Call<SignUpCallBack> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }
}
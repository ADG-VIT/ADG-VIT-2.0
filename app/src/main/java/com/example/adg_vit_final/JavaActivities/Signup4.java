package com.example.adg_vit_final.JavaActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adg_vit_final.NetworkModels.User;
import com.example.adg_vit_final.R;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

public class Signup4 extends AppCompatActivity {
    Button createAccountBtn;
    EditText usrRegNo;
    private Intent intent;
    private User user;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup4);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Creating your Account...");
        intent = getIntent();
        user = (User)intent.getSerializableExtra("User");

        createAccountBtn = findViewById(R.id.create_acct_btn);
        usrRegNo=findViewById(R.id.usrRegNo);

        getSupportActionBar().hide();

        createAccountBtn = findViewById(R.id.login_btn);

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                user.setRegno(usrRegNo.getText().toString());
                System.out.println("Name : " + user.getName());
                System.out.println("Email : " + user.getEmail());
                System.out.println("PhNumber : " + user.getPhone());
                System.out.println("Password : " + user.getPassword());
                System.out.println("Univ : " + user.getUniversity());
                System.out.println("Reg no : " + user.getRegno());
                registerUser();

            }
        });
    }

    private void registerUser() {

        Call<User> call = networkAPI.registerUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NotNull Call<User> call, @NotNull Response<User> response) {
                if(!response.isSuccessful())
                {
                    User responseUser = response.body();
                    assert responseUser != null;
                    Toast.makeText(getApplicationContext(),"Code : " + response.code() + " , Error : " + responseUser.getMessage(),Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                    return;
                }
                User responseUser = response.body();
                assert responseUser != null;
                String message = responseUser.getMessage() + responseUser.getName();
                System.out.println("Error : " + responseUser.getName());
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getApplicationContext(),Login.class);
                progressDialog.dismiss();
                startActivity(intent1);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error : " + t.getMessage(),Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });


    }
}
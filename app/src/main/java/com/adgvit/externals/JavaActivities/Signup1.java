package com.adgvit.externals.JavaActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adgvit.externals.NetworkModels.User;
import com.adgvit.externals.R;

public class Signup1 extends AppCompatActivity {
    private TextView login;
    private EditText name,email,password,phNumber;
    private Button next;
    private String Name,Email,PhNumber,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        getSupportActionBar().hide();

        login = findViewById(R.id.signup1_login);
        name = findViewById(R.id.signup1_name);
        email = findViewById(R.id.signup1_email);
        phNumber = findViewById(R.id.signup1_phNumber);
        password = findViewById(R.id.signup1_password);
        next = findViewById(R.id.next_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent for the login page
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent for the next page
                Name = name.getText().toString();
                Email = email.getText().toString();
                PhNumber = phNumber.getText().toString();
                Password = password.getText().toString();

                String error = "Error : ";
                int flag = 0;
                if(Password.length()<8)
                {
                    error = error + "Password must be atleast 8 characters";
                    flag = 1;
                }
                if(PhNumber.length() != 10)
                {
                    if(flag == 1)
                    {
                        error += " , ";
                    }
                    error += "Phone Number must contain 10 digits";
                    flag+=1;
                }
                if(flag==0) {
                    User temp = new User();
                    temp.setName(Name);
                    temp.setEmail(Email);
                    temp.setPhone(PhNumber);
                    temp.setPassword(Password);
                    Intent intent = new Intent(getApplicationContext(), SignUpTwo.class);
                    intent.putExtra("User", temp);
                    startActivity(intent);
                }
                else
                    {
                        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
}
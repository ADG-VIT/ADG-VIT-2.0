package com.example.adg_vit_final.JavaActivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adg_vit_final.Objects.User;
import com.example.adg_vit_final.R;

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

                User temp = new User();
                temp.setName(Name);
                temp.setEmail(Email);
                temp.setPhone(PhNumber);
                temp.setPassword(Password);
                Intent intent = new Intent(getApplicationContext(),SignUpTwo.class);
                intent.putExtra("User", temp);
                startActivity(intent);
            }
        });
    }
}
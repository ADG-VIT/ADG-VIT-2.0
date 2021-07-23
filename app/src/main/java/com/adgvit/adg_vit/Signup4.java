package com.adgvit.adg_vit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup4 extends AppCompatActivity {
    Button createAccountBtn;
    EditText usrRegNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup4);
        createAccountBtn = findViewById(R.id.create_acct_btn);
        usrRegNo=findViewById(R.id.usrRegNo);



        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
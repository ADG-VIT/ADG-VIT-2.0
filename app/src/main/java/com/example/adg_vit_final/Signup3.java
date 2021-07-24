package com.example.adg_vit_final;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Signup3 extends AppCompatActivity {
    private EditText nameofUni;
    private Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);

        getSupportActionBar().hide();

        nameofUni = findViewById(R.id.signup3_nameofuni);
        create = findViewById(R.id.signup3_create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //For creating account
            }
        });
    }
}
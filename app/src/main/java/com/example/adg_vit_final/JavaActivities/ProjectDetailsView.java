package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adg_vit_final.R;

public class ProjectDetailsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView project_image;
        TextView descp, features;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details_view);
        getSupportActionBar().hide();
        project_image = findViewById(R.id.project_image);
        descp = findViewById(R.id.project_descp);
        features = findViewById(R.id.features);
        project_image.setImageResource(R.drawable.projectsample1);
        descp.setText("Connect, Collaborate, Concur.\n" +
                "ADG Connect app  is built to ensure seamless operations and complete administration within the club.\n" +
                "It is an application built to ensure seamless operations and complete administration within the club.\n" +
                "It allows delegation of work among the members, guarantees quick documentation and better circulation of key details.");
        features.setText("1. Receive all the latest notifications regarding club activities.\n\n" +
                "2. Stay up-to-date about the upcoming events and projects.\n\n" +
                "3. Allows members to acknowledge for scheduled meetings\n\n" +
                "4 .Access all [M.O.Ms] in one place.\n\n" +
                "5.Allows to view domain wise assigned tasks.\n\n");

    }
}
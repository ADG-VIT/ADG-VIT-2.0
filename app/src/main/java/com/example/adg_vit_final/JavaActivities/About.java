package com.example.adg_vit_final.JavaActivities;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adg_vit_final.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class About extends AppCompatActivity {

    TextView tagline;

    TabLayout tabLayout;
    TabItem tabItemBoard, tabItemDevelopers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();
        tagline = findViewById(R.id.club_descp);
        tagline.setText("Apple Developers Group is a student community at VIT that brings together " +
                "like-minded individuals who are interested in Developing " +
                "their Dream. The group provides a platform for students to explore their interests " +
                "while collaborating with others on projects. The aim of the group is to enable students to develop themselves " +
                "as developers and provide them with all the tools they need for success.");

        tabLayout = findViewById(R.id.tab_layout);
        tabItemBoard = findViewById(R.id.tab_board);
        tabItemDevelopers = findViewById(R.id.tab_developers);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(About.this, "" + tab.getPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
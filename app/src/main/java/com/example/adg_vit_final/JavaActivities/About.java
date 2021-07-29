package com.example.adg_vit_final.JavaActivities;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.AboutUs;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.RecyclerViewAdapter.AboutRVAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class About extends AppCompatActivity {

    TextView tagline;

    TabLayout tabLayout;
    TabItem tabItemBoard, tabItemDevelopers;
    RecyclerView recyclerView;
    ArrayList<AboutUs> listBoard, listDevs;

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
        recyclerView = findViewById(R.id.recycler_view_about);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listBoard = new ArrayList<>();
        listDevs = new ArrayList<>();

        listBoard = new ArrayList<>();
        listBoard.add(new AboutUs(R.drawable.board_member_utkarsh_dixit, "Utkarsh Dixit",
                "Executive Head"));
        listBoard.add(new AboutUs(R.drawable.board_member_utkarsh_dixit, "Utkarsh Dixit",
                "Executive Head"));
        listBoard.add(new AboutUs(R.drawable.board_member_utkarsh_dixit, "Utkarsh Dixit",
                "Executive Head"));

        listDevs = new ArrayList<>();
        listDevs.add(new AboutUs(R.drawable.developers_raehat, "Raehat Singh Nanda",
                "Android Domain"));
        listDevs.add(new AboutUs(R.drawable.developers_raehat, "Raehat Singh Nanda",
                "Android Domain"));
        listDevs.add(new AboutUs(R.drawable.developers_raehat, "Raehat Singh Nanda",
                "Android Domain"));

        recyclerView.setAdapter(new AboutRVAdapter(getApplicationContext(), listBoard));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    // have to show Board'21 members
                    recyclerView.setAdapter(new AboutRVAdapter(getApplicationContext(), listBoard));
                }
                else if (tab.getPosition()==1){
                    // have to show developers of this app
                    recyclerView.setAdapter(new AboutRVAdapter(getApplicationContext(), listDevs));
                }
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
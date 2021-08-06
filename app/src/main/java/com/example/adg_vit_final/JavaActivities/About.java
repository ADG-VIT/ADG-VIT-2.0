package com.example.adg_vit_final.JavaActivities;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.AboutUs;
import com.example.adg_vit_final.DataModels.ProjectItems;
import com.example.adg_vit_final.NetworkInterface.NetworkAPI;
import com.example.adg_vit_final.NetworkModels.AboutModelNetwork;
import com.example.adg_vit_final.NetworkModels.ProjectModelNetwork;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.RecyclerViewAdapter.AboutRVAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class About extends AppCompatActivity {

    TextView tagline;

    TabLayout tabLayout;
    TabItem tabItemBoard, tabItemDevelopers;
    RecyclerView recyclerView;
    ArrayList<AboutUs> listBoard, listDevs;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();
        back = findViewById(R.id.about_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
        listBoard.add(new AboutUs(String.valueOf(R.drawable.board_member_utkarsh_dixit), "Utkarsh Dixit",
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
                if (tab.getPosition() == 0) {
//board 21

                    Call<List<AboutModelNetwork>> call = networkAPI.getAbout();
                    call.enqueue(new Callback<List<AboutModelNetwork>>() {
                        @Override

                        public void onResponse(Call<List<AboutModelNetwork>> call, Response<List<AboutModelNetwork>> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(About.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                            }
                            List<AboutModelNetwork> about = response.body();
                            for (AboutModelNetwork abouts : about) {
                                AboutUs aboutUs = new AboutUs();
                                aboutUs.setPic(aboutUs.getPic());
                                aboutUs.setName(aboutUs.getName());
                                aboutUs.setDesignation(aboutUs.getDesignation());
                                //aboutUs.setEmail(aboutUs.getEmail());
                                //aboutUs.setGithub(aboutUs.getGithub());
                                //aboutUs.setLinkedin(aboutUs.getLinkedin());
                                listBoard.add(aboutUs);

                            }
                            recyclerView.setAdapter(new AboutRVAdapter(getApplicationContext(), listBoard));

                        }


                        @Override
                        public void onFailure(Call<List<AboutModelNetwork>> call, Throwable t) {
                            Toast.makeText(About.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                    ImageView git=findViewById(R.id.gitimage);
                    ImageView email=findViewById(R.id.mailimage);
                    ImageView linkedin=findViewById(R.id.mailimage);

                    git.setOnClickListener(new View.OnClickListener() {
                        @Override

                        public void onClick(View v) {
                            if(v==git) {
                                AboutUs aboutus = new AboutUs();
                                String url = aboutus.getGithub().toString();
                                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                                CustomTabsIntent customTabsIntent = builder.build();
                                customTabsIntent.launchUrl(About.this, Uri.parse(url));
                            }
                            else if(v== email){
                                AboutUs aboutus = new AboutUs();
                                String url = aboutus.getEmail().toString();
                                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                                CustomTabsIntent customTabsIntent = builder.build();
                                customTabsIntent.launchUrl(About.this, Uri.parse(url));
                            }
                            else if(v==linkedin){
                                AboutUs aboutus = new AboutUs();
                                String url = aboutus.getLinkedin().toString();
                                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                                CustomTabsIntent customTabsIntent = builder.build();
                                customTabsIntent.launchUrl(About.this, Uri.parse(url));
                            }
                        }
                    });


                } else if (tab.getPosition() == 1) {
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
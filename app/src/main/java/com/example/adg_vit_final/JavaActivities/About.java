package com.example.adg_vit_final.JavaActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.AboutUs;
import com.example.adg_vit_final.NetworkModels.AboutModelNetwork;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.RecyclerViewAdapter.AboutRVAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;
public class About extends AppCompatActivity {

    private TextView tagline;

    private TabLayout tabLayout;
    private TabItem tabItemBoard, tabItemDevelopers;
    private RecyclerView recyclerView;
    private List<AboutModelNetwork> listBoard, listDevs;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();
        back= findViewById(R.id.about_back);
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

        Call<List<AboutModelNetwork>> call = networkAPI.getBoard();

        try
        {
            call.enqueue(new Callback<List<AboutModelNetwork>>() {
                @Override
                public void onResponse(Call<List<AboutModelNetwork>> call, Response<List<AboutModelNetwork>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(About.this, "Code : " + response.code() + " , Error : " + response.message(), Toast.LENGTH_SHORT).show();

                    }
                    listBoard = response.body();
                    recyclerView.setAdapter(new AboutRVAdapter(getApplicationContext(), listBoard));
                }

                @Override
                public void onFailure(Call<List<AboutModelNetwork>> call, Throwable t) {

                }
            });
        }catch (Exception e)
        {

        }

        //listBoard = new ArrayList<>();
//        listBoard.add(new AboutUs(R.drawable.board_member_utkarsh_dixit, "Utkarsh Dixit",
//                "Executive Head"));
//        listBoard.add(new AboutUs(R.drawable.board_member_utkarsh_dixit, "Utkarsh Dixit",
//                "Executive Head"));
//        listBoard.add(new AboutUs(R.drawable.board_member_utkarsh_dixit, "Utkarsh Dixit",
//                "Executive Head"));

        //listDevs = new ArrayList<>();
//        listDevs.add(new AboutUs(R.drawable.developers_raehat, "Raehat Singh Nanda",
//                "Android Domain"));
//        listDevs.add(new AboutUs(R.drawable.developers_raehat, "Raehat Singh Nanda",
//                "Android Domain"));
//        listDevs.add(new AboutUs(R.drawable.developers_raehat, "Raehat Singh Nanda",
//                "Android Domain"));



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
package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adg_vit_final.DataModels.ProjectItems;
import com.example.adg_vit_final.DataModels.EventsRVObject;
import com.example.adg_vit_final.DataModels.HomeDomainsObject;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.RecyclerViewAdapter.DomainsHomeAdapter;
import com.example.adg_vit_final.RecyclerViewAdapter.EventHomeAdapter;
import com.example.adg_vit_final.RecyclerViewAdapter.ProjectsAdapterHome;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView recyclerViewHomeProjects;
    RecyclerView recyclerViewHomeDomains;
    ArrayList<EventsRVObject> list;
    ArrayList<ProjectItems> projectItemsArrayList;
    ArrayList<HomeDomainsObject> homeDomainsObjectArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycler_view_events_home);
        recyclerViewHomeProjects = findViewById(R.id.recycler_view_events_projects);
        recyclerViewHomeDomains = findViewById(R.id.recycler_view_events_domains);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewHomeProjects.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHomeDomains.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        list = new ArrayList<>();
        projectItemsArrayList = new ArrayList<>();
        homeDomainsObjectArrayList = new ArrayList<>();

        list.add(new EventsRVObject(R.drawable.home_cardview_drawable, "Recruitments", "12 Jan 2021"));
        list.add(new EventsRVObject(R.drawable.home_cardview_drawable, "Recruitments", "12 Jan 2021"));

        recyclerView.setAdapter(new EventHomeAdapter(getApplicationContext(), list));

        projectItemsArrayList.add(new ProjectItems(R.drawable.frame212, "ADG Connect App", ""));
        projectItemsArrayList.add(new ProjectItems(R.drawable.frame212, "ADG Connect App", ""));
        projectItemsArrayList.add(new ProjectItems(R.drawable.frame212, "ADG Connect App", ""));

        recyclerViewHomeProjects.setAdapter(new ProjectsAdapterHome(projectItemsArrayList, getApplicationContext()));

        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.home_domain_icon, "iOS Domain"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.home_domain_icon, "iOS Domain"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.home_domain_icon, "iOS Domain"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.home_domain_icon, "iOS Domain"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.home_domain_icon, "iOS Domain"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.home_domain_icon, "iOS Domain"));

        recyclerViewHomeDomains.setAdapter(new DomainsHomeAdapter(getApplicationContext(), homeDomainsObjectArrayList));

    }
}
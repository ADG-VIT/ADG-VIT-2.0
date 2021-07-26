package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.adg_vit_final.R;
import com.example.adg_vit_final.DataModels.ProjectItems;
import com.example.adg_vit_final.RecyclerViewAdapter.ProjectsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity {
    RecyclerView recyclerView_projects;
    List<ProjectItems> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        getSupportActionBar().hide();

        recyclerView_projects=findViewById(R.id.recyclerview_projects);
        list = new ArrayList<ProjectItems>();

        recyclerView_projects.setLayoutManager(new LinearLayoutManager(this));

        ProjectItems a = new ProjectItems(R.drawable.projectsample1,"ADG VIT App", "Short Description About Project");
        ProjectItems b = new ProjectItems(R.drawable.projectsample1, "ADG VIT App","Short Description About Project" );
        ProjectItems c = new ProjectItems(R.drawable.projectsample1, "ADG VIT App","Short Description About Project" );

        list.add(a);
        list.add(b);
        list.add(c);
        recyclerView_projects.setAdapter(new ProjectsAdapter(list, Projects.this));
        recyclerView_projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }




}
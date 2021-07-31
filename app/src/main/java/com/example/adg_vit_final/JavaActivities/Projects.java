package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.adg_vit_final.R;
import com.example.adg_vit_final.DataModels.ProjectItems;
import com.example.adg_vit_final.RecyclerViewAdapter.ProjectsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity {
    RecyclerView recyclerView_projects;
    List<ProjectItems> list;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        getSupportActionBar().hide();

        recyclerView_projects=findViewById(R.id.recyclerview_projects);
        back=findViewById(R.id.project_back);
        list = new ArrayList<ProjectItems>();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView_projects.setLayoutManager(new LinearLayoutManager(this));

        ProjectItems a = new ProjectItems(R.drawable.projectsample1,"ADG VIT App", "Short Description About Project");
        ProjectItems b = new ProjectItems(R.drawable.projectsample1, "ADG VIT App","Short Description About Project" );
        ProjectItems c = new ProjectItems(R.drawable.projectsample1, "ADG VIT App","Short Description About Project" );

        list.add(a);
        list.add(b);
        list.add(c);
        recyclerView_projects.setAdapter(new ProjectsAdapter(list, Projects.this));

    }




}
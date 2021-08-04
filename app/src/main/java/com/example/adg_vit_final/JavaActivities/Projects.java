package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

import com.example.adg_vit_final.NetworkModels.EventModelNetwork;
import com.example.adg_vit_final.NetworkModels.ProjectModelNetwork;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.DataModels.ProjectItems;
import com.example.adg_vit_final.RecyclerViewAdapter.ProjectsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Projects extends AppCompatActivity {
    RecyclerView recyclerView_projects;
    ArrayList<ProjectItems> list;
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

        Call<List<ProjectModelNetwork>> call = networkAPI.getProjects();

        call.enqueue(new Callback<List<ProjectModelNetwork>>() {
            @Override
            public void onResponse(Call<List<ProjectModelNetwork>> call, Response<List<ProjectModelNetwork>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(Projects.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Projects.this, "" + response.body().toString(), Toast.LENGTH_SHORT).show();
                /*List<ProjectModelNetwork> projects = response.body();
                for(ProjectModelNetwork project: projects){
                    list.add(new ProjectItems(project.getThumbnail(), project.getTitle()
                    , project.getDescription()));
                }
                recyclerView_projects.setAdapter(new ProjectsAdapter(list, Projects.this));*/


            }

            @Override
            public void onFailure(Call<List<ProjectModelNetwork>> call, Throwable t) {
                Toast.makeText(Projects.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("TAG", "" + t.getMessage());

            }
        });

    }




}
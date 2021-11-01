package com.adgvit.externals.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;

import com.adgvit.externals.NetworkModels.ProjectModelNetwork;
import com.adgvit.externals.R;
import com.adgvit.externals.DataModels.ProjectItems;
import com.adgvit.externals.RecyclerViewAdapter.ProjectsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class   Projects extends AppCompatActivity {
    RecyclerView recyclerView_projects;
    List<ProjectItems> list;
    ImageView back;
    private ProgressDialog progressDialog;
    private boolean isDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        getSupportActionBar().hide();
        progressDialog = new ProgressDialog(this);
        isDone=false;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isDone){

                }
                else {
                    progressDialog.show();
                }
            }
        },400);

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

        try {
            Call<List<ProjectModelNetwork>> call = networkAPI.getProjects(0);

            call.enqueue(new Callback<List<ProjectModelNetwork>>() {
                @Override
                public void onResponse(Call<List<ProjectModelNetwork>> call, Response<List<ProjectModelNetwork>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(Projects.this, "Code : " + response.code() + "Error : " + response.message(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        return;
                    }

                    List<ProjectModelNetwork> projects = response.body();
                    for (ProjectModelNetwork project : projects) {
                        ProjectItems projectItems = new ProjectItems();
                        projectItems.setImage(project.getThumbnail());
                        projectItems.setName(project.getTitle());
                        projectItems.setShortDescp(project.getShortDescription());
                        projectItems.setId(project.getId());
                        list.add(projectItems);

                    }
                    recyclerView_projects.setAdapter(new ProjectsAdapter(list, Projects.this));
                    isDone = true;
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<List<ProjectModelNetwork>> call, Throwable t) {
                    Toast.makeText(Projects.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            });

        }catch (Exception e)
        {
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"Error : " + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }


    }




}
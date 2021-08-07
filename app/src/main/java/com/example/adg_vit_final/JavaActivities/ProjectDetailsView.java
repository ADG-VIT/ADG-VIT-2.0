package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.adg_vit_final.NetworkModels.SpecificProject;
import com.example.adg_vit_final.R;
import com.google.gson.JsonObject;
import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectDetailsView extends AppCompatActivity {

    private static String id ;
    private ImageView project_image;
    private TextView descp, features;
    private LinearLayout back;
    private TextView share;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details_view);
        getSupportActionBar().hide();
        Intent i = getIntent();
        id = i.getStringExtra("id");
        back = findViewById(R.id.projectdet_back);
        share=findViewById(R.id.projectdet_share);
        project_image = findViewById(R.id.project_image);
        descp = findViewById(R.id.project_descp);
        features = findViewById(R.id.features);
        name = findViewById(R.id.project_name);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

       Call<SpecificProject> call = networkAPI.getSpecificProject(id);

        call.enqueue(new Callback<SpecificProject>() {
            @Override
            public void onResponse(Call<SpecificProject> call, Response<SpecificProject> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(ProjectDetailsView.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                SpecificProject object = response.body();
//
                String desc = object.getDescription();
                String featur = object.getFeatures();
                Glide.with(ProjectDetailsView.this).load(object.getThumbnail()).into(project_image);
                name.setText(object.getTitle());
                descp.setText(desc);
                features.setText(featur);
            }

            @Override
            public void onFailure(Call<SpecificProject> call, Throwable t) {
                Toast.makeText(ProjectDetailsView.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
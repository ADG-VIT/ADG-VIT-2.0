package com.adgvit.externals.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.adgvit.externals.NetworkModels.SpecificProject;
import com.adgvit.externals.R;

import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;
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
    private Button tryNow;
    private String androidLink,iosLink;
    private SpecificProject object;
    private ProgressDialog progressDialog;
    private boolean isDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details_view);
        getSupportActionBar().hide();
        androidLink = "";
        iosLink = "";
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
        Intent i = getIntent();
        id = i.getStringExtra("id");
        tryNow = findViewById(R.id.tryNow);
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
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                // Add data to the intent, the receiving app will decide
                // what to do with it.
                share.putExtra(Intent.EXTRA_TEXT, "ADG-VIT PRESENTS\nProject : " + name.getText() + "\nDetails : " + descp.getText() + "\nAndroid Link : " + androidLink+ "\niOS Link : " + iosLink);

                startActivity(Intent.createChooser(share, "Share this project"));
            }
        });

       Call<SpecificProject> call = networkAPI.getSpecificProject(id);

        call.enqueue(new Callback<SpecificProject>() {
            @Override
            public void onResponse(Call<SpecificProject> call, Response<SpecificProject> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(ProjectDetailsView.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    return;
                }
                object = response.body();
//
                String desc = object.getDescription();
                String featur = object.getFeatures();
                Glide.with(ProjectDetailsView.this).load(object.getThumbnail()).into(project_image);
                name.setText(object.getTitle());
                descp.setText(desc);
                features.setText(featur);
                Log.i("features",featur);
                isDone=true;
                progressDialog.dismiss();

                androidLink += object.getAndroidLink();
                iosLink += object.getIosLink();

            }

            @Override
            public void onFailure(Call<SpecificProject> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ProjectDetailsView.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        tryNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                try
                {
                    i.setData(Uri.parse(androidLink));
                    startActivity(i);
                }
                catch (Exception e)
                {
                    i.setData(Uri.parse("https://" + androidLink));
                    startActivity(i);
                }
            }
        });

    }
}
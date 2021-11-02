package com.adgvit.externals.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adgvit.externals.DataModels.DomainsDataModel;
import com.adgvit.externals.NetworkModels.Domain;
import com.adgvit.externals.RecyclerViewAdapter.DomainsAdapter;
import com.bumptech.glide.Glide;
import com.adgvit.externals.DataModels.ProjectItems;
import com.adgvit.externals.DataModels.EventsRVObject;
import com.adgvit.externals.DataModels.HomeDomainsObject;
import com.adgvit.externals.NetworkModels.EventModelNetwork;
import com.adgvit.externals.NetworkModels.Highlight;
import com.adgvit.externals.NetworkModels.HomeModelNetwork;
import com.adgvit.externals.NetworkModels.ProjectModelNetwork;
import com.adgvit.externals.R;
import com.adgvit.externals.RecyclerViewAdapter.DomainsHomeAdapter;
import com.adgvit.externals.RecyclerViewAdapter.EventHomeAdapter;
import com.adgvit.externals.RecyclerViewAdapter.ProjectsAdapterHome;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView recyclerViewHomeProjects;
    private RecyclerView recyclerViewHomeDomains;
    private ArrayList<EventsRVObject> list;
    private ArrayList<ProjectItems> projectItemsArrayList;
    private List<DomainsDataModel> dataList;
    private List<HomeDomainsObject> homeDomainsObjectArrayList;
    private List<EventModelNetwork> eventHomeList;
    private List<ProjectModelNetwork> projectHomeList;
    private Highlight highlight;
    private ImageView hightlight_image;
    private ImageView settings;
    private HomeModelNetwork homeModel;
    private TextView eventsSeeAll, projectsSeeAll, domainsSeeAll;
    private ProgressDialog progressDialog;
    private boolean isDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
        try {

            eventHomeList = new ArrayList<>();
            projectHomeList = new ArrayList<>();
            dataList = new ArrayList<>();

            eventsSeeAll = findViewById(R.id.our_events_see_all);
            projectsSeeAll = findViewById(R.id.our_projects_see_all);
            domainsSeeAll = findViewById(R.id.our_domains_see_all);
            hightlight_image = findViewById(R.id.highlight_image);

            settings = findViewById(R.id.settings);

            recyclerView = findViewById(R.id.recycler_view_events_home);
            recyclerViewHomeProjects = findViewById(R.id.recycler_view_events_projects);
            recyclerViewHomeDomains = findViewById(R.id.recycler_view_events_domains);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerViewHomeProjects.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerViewHomeDomains.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

            Call<HomeModelNetwork> call = networkAPI.getHomeDetails();

            call.enqueue(new Callback<HomeModelNetwork>() {
                @Override
                public void onResponse(Call<HomeModelNetwork> call, Response<HomeModelNetwork> response) {
                    if (!response.isSuccessful()) {
                        progressDialog.dismiss();
                        Toast.makeText(Home.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    homeModel = response.body();
//                    assert homeModel != null;
                    highlight = homeModel.getHighlight();
                    eventHomeList = homeModel.getEvents();
                    projectHomeList = homeModel.getProjects();

                    Glide.with(getApplicationContext()).load(highlight.getImageURL()).into(hightlight_image);

                    hightlight_image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent;
                            if (highlight.getType().equals("Event")) {
                                intent = new Intent(getApplicationContext(), EventDetails.class);
                                intent.putExtra("event_id", highlight.get_id());
                            } else {
                                intent = new Intent(getApplicationContext(), ProjectDetailsView.class);
                                intent.putExtra("id", highlight.get_id());
                            }
                            startActivity(intent);
                        }
                    });

                    recyclerView.setAdapter(new EventHomeAdapter(getApplicationContext(), eventHomeList));
                    recyclerViewHomeProjects.setAdapter(new ProjectsAdapterHome(projectHomeList, getApplicationContext()));
                    isDone = true;
                    progressDialog.dismiss();
                    //System.out.println("Event Home List : " + eventHomeList.size());
                }

                @Override
                public void onFailure(Call<HomeModelNetwork> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(Home.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.i("LoginFailuare", t.getMessage());
                }
            });
        } catch (Exception e) {
            progressDialog.dismiss();
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        try{
        Call<List<Domain>> call = networkAPI.getDomains();

        call.enqueue(new Callback<List<Domain>>() {
            @Override
            public void onResponse(Call<List<Domain>> call, Response<List<Domain>> response) {
                if(!response.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                List<Domain> obj = response.body();
                for(Domain d: obj){
                    DomainsDataModel dm = new DomainsDataModel(d.getLogo(),d.getName(),d.getDescription());
                    dataList.add(dm);
                }
                recyclerViewHomeDomains.setAdapter(new DomainsHomeAdapter(getApplicationContext(), dataList));
                isDone = true;
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<Domain>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Home.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        } catch (Exception e) {
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"Error: " + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }

        eventsSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(getApplicationContext(), Events.class));
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Error : " + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

        projectsSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(getApplicationContext(), Projects.class));
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Error : " + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
                }
        });

        domainsSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(getApplicationContext(), Domains.class));
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Error : " + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
                }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(getApplicationContext(), Settings.class));
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Error : " + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
                }
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Do you want to close ADG-VIT?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("NO", null)
                .show();
    }
}
package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.adg_vit_final.DataModels.ProjectItems;
import com.example.adg_vit_final.DataModels.EventsRVObject;
import com.example.adg_vit_final.DataModels.HomeDomainsObject;
import com.example.adg_vit_final.NetworkModels.EventModelNetwork;
import com.example.adg_vit_final.NetworkModels.Highlight;
import com.example.adg_vit_final.NetworkModels.HomeModelNetwork;
import com.example.adg_vit_final.NetworkModels.ProjectModelNetwork;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.RecyclerViewAdapter.DomainsHomeAdapter;
import com.example.adg_vit_final.RecyclerViewAdapter.EventHomeAdapter;
import com.example.adg_vit_final.RecyclerViewAdapter.ProjectsAdapterHome;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView recyclerViewHomeProjects;
    private RecyclerView recyclerViewHomeDomains;
    private ArrayList<EventsRVObject> list;
    private ArrayList<ProjectItems> projectItemsArrayList;
    private ArrayList<HomeDomainsObject> homeDomainsObjectArrayList;
    private List<EventModelNetwork> eventHomeList;
    private List<ProjectModelNetwork> projectHomeList;
    private Highlight highlight;
    private ImageView hightlight_image;
    private ImageView settings;
    private HomeModelNetwork homeModel;
    private TextView eventsSeeAll, projectsSeeAll, domainsSeeAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        try {

            eventHomeList = new ArrayList<>();
            projectHomeList =new ArrayList<>();

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
                    if (!response.isSuccessful()){
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
                            if(highlight.getType().equals("Event"))
                            {
                                intent = new Intent(getApplicationContext(), EventDetails.class);
                                intent.putExtra("event_id",highlight.get_id());
                            }
                            else
                                {
                                    intent = new Intent(getApplicationContext(), ProjectDetailsView.class);
                                    intent.putExtra("id",highlight.get_id());
                                }
                            startActivity(intent);
                        }
                    });

                    recyclerView.setAdapter(new EventHomeAdapter(getApplicationContext(), eventHomeList));
                    recyclerViewHomeProjects.setAdapter(new ProjectsAdapterHome(projectHomeList, getApplicationContext()));
                    //System.out.println("Event Home List : " + eventHomeList.size());
                }

                @Override
                public void onFailure(Call<HomeModelNetwork> call, Throwable t) {
                    Toast.makeText(Home.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.i("LoginFailuare", t.getMessage());
                }
            });
        }catch (Exception e){
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

//        list = new ArrayList<>();
//        projectItemsArrayList = new ArrayList<>();
        homeDomainsObjectArrayList = new ArrayList<>();

//        list.add(new EventsRVObject(R.drawable.home_cardview_drawable, "Recruitments", "12 Jan 2021"));
//        list.add(new EventsRVObject(R.drawable.home_cardview_drawable, "Recruitments", "12 Jan 2021"));



//        projectItemsArrayList.add(new ProjectItems(R.drawable.frame212, "ADG Connect App", ""));
//        projectItemsArrayList.add(new ProjectItems(R.drawable.frame212, "ADG Connect App", ""));
//        projectItemsArrayList.add(new ProjectItems(R.drawable.frame212, "ADG Connect App", ""));


        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.ic_ios, "iOS Domain"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.ic_android, "Android"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.ic_web, "Web Domain"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.ic_ml, "ML Domain"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.ic_design, "Design"));
        homeDomainsObjectArrayList.add(new HomeDomainsObject(R.drawable.ic_ios, "Management"));

        recyclerViewHomeDomains.setAdapter(new DomainsHomeAdapter(getApplicationContext(), homeDomainsObjectArrayList));

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
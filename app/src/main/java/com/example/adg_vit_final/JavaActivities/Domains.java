package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adg_vit_final.DataModels.DomainsDataModel;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.RecyclerViewAdapter.DomainsAdapter;
import com.example.adg_vit_final.RecyclerViewAdapter.EventsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Domains extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<DomainsDataModel> dataList;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domains);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.domains_recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();
        back = findViewById(R.id.domains_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dataList.add(new DomainsDataModel(R.drawable.ic_ios,"iOS Domain","Apple Developers Group conducts a 48 hour long hackathon"));
        dataList.add(new DomainsDataModel(R.drawable.ic_android,"Android Domain","Apple Developers Group conducts a 48 hour long hackathon"));
        dataList.add(new DomainsDataModel(R.drawable.ic_web,"Web Domain","Apple Developers Group conducts a 48 hour long hackathon"));
        dataList.add(new DomainsDataModel(R.drawable.ic_ml,"Machine Learning Domain","Apple Developers Group conducts a 48 hour long hackathon"));

        recyclerView.setAdapter(new DomainsAdapter(this,dataList));

    }
}
package com.example.adg_vit_final.JavaActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.EventsDataModel;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.RecyclerViewAdapter.EventsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Events extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<EventsDataModel> dataList;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getSupportActionBar().hide();

        dataList = new ArrayList<>();
        recyclerView = findViewById(R.id.events_recView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        back = findViewById(R.id.events_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));
        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));
        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));
        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));
        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));
        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));
        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));
        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));
        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));
        dataList.add(new EventsDataModel(R.drawable.rectangle_375,"Recruitments","21 Jan 2021"));

        recyclerView.setAdapter(new EventsAdapter(this,dataList));


    }
}
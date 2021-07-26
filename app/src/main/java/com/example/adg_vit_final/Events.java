package com.example.adg_vit_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adg_vit_final.DataModels.EventsDataModel;
import com.example.adg_vit_final.RecyclerViewAdapter.EventsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Events extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<EventsDataModel> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getSupportActionBar().hide();

        dataList = new ArrayList<>();
        recyclerView = findViewById(R.id.events_recView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

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
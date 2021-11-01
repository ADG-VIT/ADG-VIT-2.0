package com.adgvit.externals.JavaActivities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adgvit.externals.DataModels.EventsDataModel;
import com.adgvit.externals.NetworkModels.EventModelNetwork;
import com.adgvit.externals.R;
import com.adgvit.externals.RecyclerViewAdapter.EventsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;

public class Events extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<EventsDataModel> dataList;
    private ImageView back;
    private ProgressDialog progressDialog;
    private boolean isDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

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
            Call<List<EventModelNetwork>> call = networkAPI.getEvents(0);

            call.enqueue(new Callback<List<EventModelNetwork>>() {
                @Override
                public void onResponse(Call<List<EventModelNetwork>> call, Response<List<EventModelNetwork>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(Events.this, "Code : " + response.code() + " , Error : " + response.message(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        return;
                    }
                    List<EventModelNetwork> events = response.body();

                    for (EventModelNetwork event : events) {
                        dataList.add(new EventsDataModel(event.get_id(), event.getPosterURL(), event.getName(), event.getDate(), event.getInfo()));
                    }
                    recyclerView.setAdapter(new EventsAdapter(Events.this, dataList));
                    isDone = true;
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<List<EventModelNetwork>> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(Events.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.i("TAG", "" + t.getMessage());
                }
            });


    }
}
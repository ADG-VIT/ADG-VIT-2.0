package com.example.adg_vit_final.JavaActivities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adg_vit_final.DataModels.EventsDataModel;
import com.example.adg_vit_final.NetworkModels.EventModelNetwork;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.RecyclerViewAdapter.EventsAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

public class Events extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<EventsDataModel> dataList;
    private ImageView back;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getSupportActionBar().hide();

        try {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading all the Events...");
        progressDialog.show();
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
            Call<List<EventModelNetwork>> call = networkAPI.getEvents("events");

            call.enqueue(new Callback<List<EventModelNetwork>>() {
                @Override
                public void onResponse(Call<List<EventModelNetwork>> call, Response<List<EventModelNetwork>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(Events.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                    }
                    List<EventModelNetwork> events = response.body();

                    for (EventModelNetwork event : events) {
                        dataList.add(new EventsDataModel(event.get_id(), event.getPosterURL(), event.getName(), event.getDate(), event.getInfo()));
                    }
                    recyclerView.setAdapter(new EventsAdapter(Events.this, dataList));
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<List<EventModelNetwork>> call, Throwable t) {
                    Toast.makeText(Events.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.i("TAG", "" + t.getMessage());
                }
            });
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Error : " + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }


    }
}
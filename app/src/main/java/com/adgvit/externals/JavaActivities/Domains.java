package com.adgvit.externals.JavaActivities;

import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.adgvit.externals.NetworkModels.Domain;
import com.adgvit.externals.DataModels.DomainsDataModel;
import com.adgvit.externals.R;
import com.adgvit.externals.RecyclerViewAdapter.DomainsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Domains extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<DomainsDataModel> dataList;
    private ImageView back;
    private ProgressDialog progressDialog;
    private boolean isDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domains);

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
                    recyclerView.setAdapter(new DomainsAdapter(Domains.this,dataList));
                    isDone = true;
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<List<Domain>> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(Domains.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"Error: " + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }

//        dataList.add(new DomainsDataModel(R.drawable.ic_ios,"iOS Domain","Apple Developers Group conducts a 48 hour long hackathon"));
//        dataList.add(new DomainsDataModel(R.drawable.ic_android,"Android Domain","Apple Developers Group conducts a 48 hour long hackathon"));
//        dataList.add(new DomainsDataModel(R.drawable.ic_web,"Web Domain","Apple Developers Group conducts a 48 hour long hackathon"));
//        dataList.add(new DomainsDataModel(R.drawable.ic_ml,"Machine Learning Domain","Apple Developers Group conducts a 48 hour long hackathon"));



    }
}
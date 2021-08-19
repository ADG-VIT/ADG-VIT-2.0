package com.example.adg_vit_final.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adg_vit_final.DataModels.SettingsItems;
import com.example.adg_vit_final.NetworkModels.User;
import com.example.adg_vit_final.R;
import com.example.adg_vit_final.RecyclerViewAdapter.Settings_Adapter;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import static com.example.adg_vit_final.NetworkUtil.NetworkUtils.networkAPI;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Settings extends AppCompatActivity {
    RecyclerView recy1,recy2,recy3;
    TextView userName, college;
    List<SettingsItems> lst1,lst2,lst3;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();
        userName = findViewById(R.id.userName);
        college = findViewById(R.id.userClg);
        back = findViewById(R.id.settings_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recy1 = findViewById(R.id.rcy1);
        recy2 = findViewById(R.id.rcy2);
        recy3 = findViewById(R.id.rcy3);
        lst1 = new ArrayList<SettingsItems>();
        lst2 = new ArrayList<SettingsItems>();
        lst3 = new ArrayList<SettingsItems>();
        recy1.setNestedScrollingEnabled(false);
        recy2.setNestedScrollingEnabled(false);
        recy3.setNestedScrollingEnabled(false);

        SharedPreferences sharedPreferences= getSharedPreferences("com.adgvit.externals",MODE_PRIVATE);
        String token = sharedPreferences.getString("Token","");

        Call<User> call = networkAPI.getUserInfo(token);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    try {
                        User obj = response.body();

                        Toast.makeText(getApplicationContext(),"Error: "+obj.getMessage() + "Code: " + response.code(),Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Some error has occured, Try Again",Toast.LENGTH_LONG).show();
                        System.out.println(e.getLocalizedMessage());
                    }

                }

                User obj = response.body();
                String name = obj.getName();
                String clg = obj.getUniversity();
                userName.setText(name);
                college.setText(clg);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("Fail",""+t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        recy1.setLayoutManager(new LinearLayoutManager(this));
        recy2.setLayoutManager(new LinearLayoutManager(this));
        recy3.setLayoutManager(new LinearLayoutManager(this));

        lst1.add(new SettingsItems(R.drawable.ic_appearance, "Appearance"));
        lst1.add(new SettingsItems(R.drawable.ic_notifications, "Notifications"));
        recy1.setAdapter(new Settings_Adapter(this,lst1));

        lst2.add(new SettingsItems(R.drawable.ic_contact_us,"Contact Us"));
        lst2.add(new SettingsItems(R.drawable.ic_share,"Share with Peers"));
        lst2.add(new SettingsItems(R.drawable.ic_ig,"Our Instagram"));
        lst2.add(new SettingsItems(R.drawable.ic_twit,"Our Twitter"));
        lst2.add(new SettingsItems(R.drawable.ic_fb,"Our Facebook"));
        lst2.add(new SettingsItems(R.drawable.ic_linkedin_settings,"Our LinkedIn"));

        recy2.setAdapter(new Settings_Adapter(this,lst2));


        lst3.add(new SettingsItems(R.drawable.ic_about_us,"About Us"));
        lst3.add(new SettingsItems(R.drawable.ic_privacy,"Privacy Policy"));
        recy3.setAdapter(new Settings_Adapter(this,lst3));



    }
}
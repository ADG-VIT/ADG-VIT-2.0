package com.adgvit.externals.JavaActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adgvit.externals.DataModels.SettingsItems;
import com.adgvit.externals.NetworkModels.User;
import com.adgvit.externals.R;
import com.adgvit.externals.RecyclerViewAdapter.Settings_Adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;

import retrofit2.Callback;
import retrofit2.Response;

public class Settings extends AppCompatActivity {
    RecyclerView recy1,recy2,recy3;
    TextView userName, college;
    List<SettingsItems> lst1,lst2,lst3;
    ImageView back;
    CardView signedIn,notSignedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();
        userName = findViewById(R.id.userName);
        college = findViewById(R.id.userClg);
        back = findViewById(R.id.settings_back);
        signedIn = findViewById(R.id.cardLogin);
        notSignedIn=findViewById(R.id.cardNotLogin);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        notSignedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FirstBoarding.class));
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
        String userNam = sharedPreferences.getString("UserName","");
        String collegeNam = sharedPreferences.getString("CollegeName","");

        if(token.equals("")){
            signedIn.setVisibility(View.GONE);
            notSignedIn.setVisibility(View.VISIBLE);
        }
        else{
            signedIn.setVisibility(View.VISIBLE);
            notSignedIn.setVisibility(View.GONE);
            userName.setText(userNam);
            college.setText(collegeNam);

        }

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
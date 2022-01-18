package com.adgvit.externals.JavaActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adgvit.externals.DataModels.AboutUs;
import com.adgvit.externals.NetworkModels.AboutModelNetwork;
import com.adgvit.externals.R;
import com.adgvit.externals.RecyclerViewAdapter.AboutRVAdapter;
import com.adgvit.externals.RecyclerViewAdapter.AboutRVAdapterDevs;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.adgvit.externals.NetworkUtil.NetworkUtils.networkAPI;
public class About extends AppCompatActivity {

    private TextView tagline;

    private TabLayout tabLayout;
    private TabItem tabItemBoard, tabItemDevelopers;
    private RecyclerView recyclerView;
    private List<AboutModelNetwork> listBoard;
    private ImageView back;
    private List<AboutUs> listDevelopers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();
        back= findViewById(R.id.about_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tagline = findViewById(R.id.club_descp);
        tagline.setText("Apple Developers Group is a student community at VIT that brings together " +
                "like-minded individuals who are interested in Developing " +
                "their Dream. The group provides a platform for students to explore their interests " +
                "while collaborating with others on projects. The aim of the group is to enable students to develop themselves " +
                "as developers and provide them with all the tools they need for success.");

        tabLayout = findViewById(R.id.tab_layout);
        tabItemBoard = findViewById(R.id.tab_board);
        tabItemDevelopers = findViewById(R.id.tab_developers);
        recyclerView = findViewById(R.id.recycler_view_about);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listBoard = new ArrayList<>();
        listDevelopers = new ArrayList<>();

        Call<List<AboutModelNetwork>> call = networkAPI.getBoard();

        try
        {
            call.enqueue(new Callback<List<AboutModelNetwork>>() {
                @Override
                public void onResponse(Call<List<AboutModelNetwork>> call, Response<List<AboutModelNetwork>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(About.this, "Code : " + response.code() + " , Error : " + response.message(), Toast.LENGTH_SHORT).show();

                    }
                    listBoard = response.body();
                    recyclerView.setAdapter(new AboutRVAdapter(getApplicationContext(), listBoard));
                }

                @Override
                public void onFailure(Call<List<AboutModelNetwork>> call, Throwable t) {

                }
            });
        }catch (Exception e)
        {

        }

        listDevelopers.add((new AboutUs("Raehat Singh Nanda", "raehatsingh.nanda2020@vitstudent.ac.in", "http://github.com/raehat", "https://www.linkedin.com/in/raehat-singh-nanda-b29085201/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492111/Raehet_Singh_Nanda_ukq71g.jpg", "Android Developer")));
        listDevelopers.add((new AboutUs("Jatin Dhall", "jatin.dhall7385@gmail.com", "https://github.com/Jatin7385", "https://www.linkedin.com/in/jatin-dhall-3947a6123/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492111/Jatin_Dhall_jbitl1.jpg", "Android Developer")));
        listDevelopers.add((new AboutUs("Haneet Arya", "haneetarya16@gmail.com", "https://github.com/Haneet-Arya", "https://www.linkedin.com/in/haneet-arya-067b72141", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492110/Haneet_Arya_a8id0j.jpg", "Android Developer")));
        listDevelopers.add((new AboutUs("Saswata Basu", "saswatabasu23@gmail.com", "https://github.com/saswatabasu23", "http://linkedin.com/in/saswata-basu-865a80200", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492113/Saswata_zkqs5w.jpg", "Web Developer")));
        listDevelopers.add((new AboutUs("Srinivas", "s7varanasi@gmail.com", "https://github.com/MrVSiK", "https://www.linkedin.com/in/srinivasa-varanasi-ba752a217/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492112/Srinivas_qsfouo.jpg", "Web Developer")));
        listDevelopers.add((new AboutUs("Kaushal Agrawal", "itsk397@gmail.com", "https://github.com/Kaushal-A", "https://www.linkedin.com/in/kaushal-agrawal-40b6111b6/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492112/kaushal_agrawal_wzcxhc.jpg", "Web Developer")));
        listDevelopers.add((new AboutUs("Umesh Kumar", "umesh.raju021@gmail.com", "https://github.com/vumeshkumarraju", "https://www.linkedin.com/in/umesh-kumar-40812019b/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492114/UMESH_KUMAR_jynfov.png", "IOS Developer")));
        listDevelopers.add((new AboutUs("Arjeet Anand", "anandarjeet27@gmail.com", "https://github.com/Arjeet27", "https://www.linkedin.com/in/arjeetanand/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492110/Arjeet_Anand_dxh5ct.jpg", "Design")));
        listDevelopers.add((new AboutUs("Saumya Verma", "verma.saumya.703@gmail.com", "https://github.com/saumya-703", "https://www.linkedin.com/in/saumya-verma-186343203/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492112/Saumya_Verma_wc1kmv.jpg", "Design")));
        listDevelopers.add((new AboutUs("Shivam Raj", "shivamraj058@gmail.com", "https://github.com/Shivamraj-hub", "https://www.linkedin.com/in/shivam-raj-80416b1bb/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492270/Shivam_Raj_sbpxcz.jpg", "IOS Developer")));
        listDevelopers.add((new AboutUs("Pranav", "pranavr2002@gmail.com", "https://github.com/pranav-r13", "www.linkedin.com/in/pranav-r13", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492118/Pranav_y9qqin.jpg", "Web Developer")));
        listDevelopers.add((new AboutUs("Nimish", "nimishjain100701@gmail.com", "https://github.com/nimishjn", "https://linkedin.com/in/nimishjn", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492112/NIMISH_rxx6up.jpg", "Web Developer")));
        listDevelopers.add((new AboutUs("Mugdha Raje Ashiya", "mugdhaashiya@gmail.com", "https://github.com/mugdha-7002", "", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492111/MUGDHA_RAJE_ASHIYA_dzmozp.jpg", "IOS Developer")));
        listDevelopers.add((new AboutUs("Pranav Ram K", "pranavram063@gmail.com", "https://github.com/pranavram-52", "https://www.linkedin.com/in/pranav-ram-178420202/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492111/Pranav_Ram_K_vioy0u.png", "IOS Developer")));
        listDevelopers.add((new AboutUs("Harsh Vardhan", "harshvardhan6.hv@gmail.com", "https://github.com/harshhvv", "https://www.linkedin.com/in/harsh-vardhan-b412551b8/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492110/harsh_vardhan_d48qmn.jpg", "IOS Developer")));
        listDevelopers.add((new AboutUs("Devika Varshney", "Devikavarshney0003@gmail.com ", "https://github.com/devikavarshney", "https://www.linkedin.com/in/devika-varshney-2776721b5", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492110/Devika_varshney_qsjedn.jpg", "Web Developer")));
        listDevelopers.add((new AboutUs("Aman", "amananytime07@gmail.com", "https://github.com/arcAman07", "https://www.linkedin.com/in/aman-sharma-70078a1bb/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492110/Aman_cya0qk.jpg", "Web Developer")));
        listDevelopers.add((new AboutUs("Adhithan", "adhithan.c@gmail.com ", "https://github.com/Adhithan7", "https://www.linkedin.com/in/adhithan-c-9939b91bb/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642492109/Adhithan_nqskwg.jpg", "Web Developer")));
        listDevelopers.add((new AboutUs("Sowmiya", "sowmiyalakshmig@gmail.com", "https://github.com/Sowmiya81", "https://www.linkedin.com/in/aura-g-288388210/", "https://res.cloudinary.com/dolaseklj/image/upload/v1642548523/Sowmiyalakshmi_G_tdihqi.jpg", "Android Developer")));
        listDevelopers.add((new AboutUs("Abhinandita Banerjee", "abhinanditaban@gmail.com", "https://github.com/abhinandita-banerjee02", "https://www.linkedin.com/in/abhinandita-banerjee-43846b1bb/", "", "Android Developer")));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    // have to show Board'21 members
                    recyclerView.setAdapter(new AboutRVAdapter(getApplicationContext(), listBoard));
                }
                else if (tab.getPosition()==1){
                    // have to show developers of this app
                    recyclerView.setAdapter(new AboutRVAdapterDevs(getApplicationContext(), listDevelopers));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
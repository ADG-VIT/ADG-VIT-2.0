package com.adgvit.externals.JavaActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adgvit.externals.R;
import com.google.android.material.tabs.TabLayout;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class OnBoarding extends AppCompatActivity {

    TextView textViewSkip;
    ViewPager viewPager;
    DotsIndicator dotsIndicator;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        next = findViewById(R.id.on_boarding_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem() == 0)
                {
                    viewPager.setCurrentItem(1);
                }
                else
                    {
                        startActivity(new Intent(getApplicationContext(),FirstBoarding.class));
                    }
            }
        });

        viewPager = findViewById(R.id.view_pager);

        dotsIndicator = findViewById(R.id.dots_indicator);
        PagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        dotsIndicator.setViewPager(viewPager);

        SharedPreferences sharedPreferences = getSharedPreferences("onboarding", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("onBoardingVisited",false)) {
            startActivity(new Intent(getApplicationContext(), FirstBoarding.class));
            finish();
        }
        else {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("onBoardingVisited",true);
            editor.apply();

            textViewSkip = findViewById(R.id.skip);

            textViewSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), FirstBoarding.class));
                }
            });
        }

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0) {
                return new OnBoarding1();
            }
            return new OnBoarding2();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
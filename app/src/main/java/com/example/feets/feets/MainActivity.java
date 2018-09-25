package com.example.feets.feets;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.feets.feets.adapters.MainFragmentAdapter;
import com.example.feets.feets.models.Challenge;
import com.example.feets.feets.ui.FlipAnimation;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Toolbar toolbar;
    private TextView event3in30btn;
    private ImageView imgView1;
    private ImageView imgView2;
    private TabLayout mtabLayout;
    private TabItem mtabChallenges;
    private TabItem mtabFeed;
    private TabItem mtabAnnouncement;
    private ViewPager mviewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_highfive:
                    mTextMessage.setText(R.string.title_highfive);
                    return true;
                case R.id.navigation_ting:
                    mTextMessage.setText(R.string.title_ting);
                    return true;
                case R.id.navigation_feeters:
                    mTextMessage.setText(R.string.title_feeters);
                    return true;
                case R.id.navigation_makanbuddy:
                    mTextMessage.setText(R.string.title_makanbuddy);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Statusbar change color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.StartColor3in30Opacity));
        }

        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewEx bnve = (BottomNavigationViewEx) findViewById(R.id.navigation);
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
        bnve.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        event3in30btn = (TextView) findViewById(R.id.event3in30);
        event3in30btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CampaignActivity.class);
                startActivity(intent);
            }
        });

        imgView1 = (ImageView) findViewById(R.id.ImageView01);
        imgView2 = (ImageView) findViewById(R.id.ImageView02);

        imgView1.setClickable(true);
        imgView2.setClickable(true);

//        imgView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FlipAnimation flipAnimation = new FlipAnimation(imgView1,imgView2);
//                if (imgView1.getVisibility() == View.GONE) {
//                    flipAnimation.reverse();
//                    Log.i(com.example.feets.feets.constants.GeneralConstants.TAG, "flipAnimation.reverse();");
//                }
//                else{
//                    imgView2.startAnimation(flipAnimation);
//                    Log.i(com.example.feets.feets.constants.GeneralConstants.TAG, "imgView2.startAnimation(flipAnimation)");
//                }
//            }
//        });

        imgView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlipAnimation flipAnimation = new FlipAnimation(imgView1, imgView2, true);
                imgView2.startAnimation(flipAnimation);
            }
        });

        imgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlipAnimation flipAnimation = new FlipAnimation(imgView2, imgView1, false);
                imgView1.startAnimation(flipAnimation);
            }
        });

        mtabLayout = (TabLayout) findViewById(R.id.tabs);
        mtabChallenges = (TabItem) findViewById(R.id.tab_challenges);
        mtabFeed = (TabItem) findViewById(R.id.tab_feed);
        mtabAnnouncement = (TabItem) findViewById(R.id.tab_announcement);
        mviewPager = (ViewPager) findViewById(R.id.tab_viewpager);


        MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), mtabLayout.getTabCount());
        mviewPager.setAdapter(mainFragmentAdapter);
        mviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtabLayout));

        mtabLayout.addOnTabSelectedListener(new
            TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mviewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_toolbar, menu);
        return true;
    }


}

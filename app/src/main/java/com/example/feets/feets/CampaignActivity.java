package com.example.feets.feets;

import android.graphics.Color;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.feets.feets.adapters.PageAdapter;

public class CampaignActivity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private TabLayout mtabLayout;
    private TabItem mtab3in30;
    private TabItem mtab3in30Leaderboard;
    private ViewPager mviewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign);

        mtoolbar = (Toolbar) findViewById(R.id.toolbar_campaign);
        mtoolbar.setTitle("Kick-Start Campaign");
        setSupportActionBar(mtoolbar);
        mtoolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);

        mtabLayout = (TabLayout) findViewById(R.id.tabs_campaign);
        mtab3in30 = (TabItem) findViewById(R.id.tab3in30);
        mtab3in30Leaderboard = (TabItem) findViewById(R.id.tab3in30Leaderboard);
        mviewPager = (ViewPager) findViewById(R.id.viewPager);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), mtabLayout.getTabCount());
        mviewPager.setAdapter(pageAdapter);
        mviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtabLayout));

        mtabLayout.addOnTabSelectedListener(new
           TabLayout.OnTabSelectedListener()
           {
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
        getMenuInflater().inflate(R.menu.activity_campaign_toolbar, menu);
        return true;
    }

}

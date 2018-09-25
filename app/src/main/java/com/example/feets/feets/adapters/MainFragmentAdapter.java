package com.example.feets.feets.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.feets.feets.fragments.Announcements;
import com.example.feets.feets.fragments.Challenges;
import com.example.feets.feets.fragments.Feeds;

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public MainFragmentAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Challenges();
            case 1:
                return new Feeds();
            case 2:
                return new Announcements();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

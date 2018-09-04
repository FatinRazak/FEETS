package com.example.feets.feets.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.feets.feets.fragments.Campaign3in30;
import com.example.feets.feets.fragments.Campaign3in30Leaderboard;

public class Campaign3in30Adapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public Campaign3in30Adapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Campaign3in30();
            case 1:
                return new Campaign3in30Leaderboard();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
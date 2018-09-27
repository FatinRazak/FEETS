package com.example.feets.feets.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.feets.feets.R;
import com.example.feets.feets.adapters.AnnouncementAdapter;
import com.example.feets.feets.models.Announcement;

import java.util.ArrayList;

public class Announcements extends Fragment {
    String[] items = new String[] { "Announcements", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
            "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
            "Android", "iPhone", "WindowsMobile"};

    String[] subitems = new String[] { "Sub Announcements", "Sub iPhone", "Sub WindowsMobile",
            "Sub Blackberry", "Sub WebOS", "Sub Ubuntu", "Sub Windows7", "Sub Max OS X",
            "Sub Linux", "Sub OS/2", "Sub Ubuntu", "Sub Windows7", "Sub Max OS X", "Sub Linux",
            "Sub OS/2", "Sub Ubuntu", "Sub Windows7", "Sub Max OS X", "Sub Linux", "Sub OS/2",
            "Sub Android", "Sub iPhone", "Sub WindowsMobile"};

    int[] imgid = {R.drawable.center3in30, R.drawable.potrait_girl, R.drawable.center3in30,
            R.drawable.potrait_girl, R.drawable.center3in30, R.drawable.potrait_girl, R.drawable.center3in30,
            R.drawable.potrait_girl, R.drawable.center3in30, R.drawable.potrait_girl, R.drawable.center3in30,
            R.drawable.potrait_girl, R.drawable.center3in30, R.drawable.potrait_girl, R.drawable.center3in30,
            R.drawable.potrait_girl, R.drawable.center3in30, R.drawable.potrait_girl, R.drawable.center3in30,
            R.drawable.potrait_girl, R.drawable.center3in30, R.drawable.potrait_girl, R.drawable.center3in30};

    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);

        final ArrayList<Announcement> announcementlist = new ArrayList<Announcement>();

        //Push dummy data to Adapter
        for (int i = 0; i < items.length; i++){
            Announcement announcement = new Announcement(items[i], subitems[i], imgid[i]);
            announcementlist.add(announcement);
        }


//        ArrayAdapter<String> itemsAdapter =
//                new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, list);

        AnnouncementAdapter announcementAdapter = new AnnouncementAdapter(getContext(),0, announcementlist);

        mListView = (ListView) view.findViewById(R.id.listView);

//        mListView.setAdapter(itemsAdapter);
        mListView.setAdapter(announcementAdapter);



        return view;
    }
}

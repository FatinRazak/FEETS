package com.example.feets.feets.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.feets.feets.R;
import com.example.feets.feets.adapters.FeedAdapter;
import com.example.feets.feets.models.Feed;

import java.util.ArrayList;

public class Feeds extends Fragment {

    String[] items = new String[] { "Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
            "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
            "Android", "iPhone", "WindowsMobile"};

    String[] subitems = new String[] { "Sub Android", "Sub iPhone", "Sub WindowsMobile",
            "Sub Blackberry", "Sub WebOS", "Sub Ubuntu", "Sub Windows7", "Sub Max OS X",
            "Sub Linux", "Sub OS/2", "Sub Ubuntu", "Sub Windows7", "Sub Max OS X", "Sub Linux",
            "Sub OS/2", "Sub Ubuntu", "Sub Windows7", "Sub Max OS X", "Sub Linux", "Sub OS/2",
            "Sub Android", "Sub iPhone", "Sub WindowsMobile"};

    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        final ArrayList<Feed> feedlist = new ArrayList<Feed>();

        //Push dummy data to Adapter
        for (int i = 0; i < items.length; i++){
            Feed feed = new Feed(items[i], subitems[i]);
            feedlist.add(feed);
        }


//        ArrayAdapter<String> itemsAdapter =
//                new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, list);

        FeedAdapter feedAdapter = new FeedAdapter(getContext(),0, feedlist);

        mListView = (ListView) view.findViewById(R.id.listView);

//        mListView.setAdapter(itemsAdapter);
        mListView.setAdapter(feedAdapter);



        return view;
    }
}

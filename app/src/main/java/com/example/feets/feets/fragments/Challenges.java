package com.example.feets.feets.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.feets.feets.R;
import com.example.feets.feets.adapters.ChallengeAdapter;
import com.example.feets.feets.models.Challenge;

import java.util.ArrayList;

public class Challenges extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_challenges, container, false);

//        final ArrayList<String> list = new ArrayList<String>();
//        for (int i = 0; i < items.length; ++i) {
//            list.add(items[i]);
//        }

        final ArrayList<Challenge> challengelist = new ArrayList<Challenge>();

        //Push dummy data to Adapter
        for (int i = 0; i < items.length; i++){
            Challenge challenge = new Challenge(items[i],subitems[i]);
            challengelist.add(challenge);
        }


//        ArrayAdapter<String> itemsAdapter =
//                new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, list);

        ChallengeAdapter challengeAdapter = new ChallengeAdapter(getContext(),0, challengelist);

        mListView = (ListView) view.findViewById(R.id.listView);

//        mListView.setAdapter(itemsAdapter);
        mListView.setAdapter(challengeAdapter);



        return view;
    }
}

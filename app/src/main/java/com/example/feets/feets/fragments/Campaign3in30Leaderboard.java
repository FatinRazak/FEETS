package com.example.feets.feets.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.feets.feets.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Campaign3in30Leaderboard extends Fragment{

    private CircleImageView mImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_3in30_leaderboard, container, false);



    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        mImageView = (CircleImageView) getView().findViewById(R.id.secondPlaceImage);
//        mImageView.setElevation(10);
//    }
}

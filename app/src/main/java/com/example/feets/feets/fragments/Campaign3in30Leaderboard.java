package com.example.feets.feets.fragments;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.feets.feets.R;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


public class Campaign3in30Leaderboard extends Fragment{
    private ImageView firstplaceimg;
    private ImageView secondplaceimg;
    private ImageView thirdplaceimg;
    private ImageView leaderboardimg;
    private ImageView leaderboardimgYOU;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view =  inflater.inflate(R.layout.fragment_3in30_leaderboard, container, false);

        firstplaceimg = (ImageView) view.findViewById(R.id.firstPlaceImage);
        secondplaceimg = (ImageView) view.findViewById(R.id.secondPlaceImage);
        thirdplaceimg = (ImageView) view.findViewById(R.id.thirdPlaceImage);
        leaderboardimg = (ImageView) view.findViewById(R.id.leaderboardImage);
        leaderboardimgYOU = (ImageView) view.findViewById(R.id.leaderboardImageYOU);

        Glide.with(this).load(R.drawable.potrait_girl)
                .apply(bitmapTransform(new CircleCrop())).into(firstplaceimg);

        Glide.with(this).load(R.drawable.potrait_girl)
                .apply(bitmapTransform(new CircleCrop())).into(secondplaceimg);

        Glide.with(this).load(R.drawable.potrait_girl)
                .apply(bitmapTransform(new CircleCrop())).into(thirdplaceimg);

        Glide.with(this).load(R.drawable.potrait_girl)
                .apply(bitmapTransform(new CircleCrop())).into(leaderboardimg);

        Glide.with(this).load(R.drawable.potrait_girl)
                .apply(bitmapTransform(new CircleCrop())).into(leaderboardimgYOU);
//
//        Glide.with(this).load(R.drawable.potrait_girl)
//                .apply(bitmapTransform(new CircleCrop())).into((ImageView) view.findViewById(R.id.secondPlaceImage));
        return view;

    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        mImageView = (CircleImageView) getView().findViewById(R.id.secondPlaceImage);
//        mImageView.setElevation(10);
//    }
}

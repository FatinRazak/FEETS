package com.example.feets.feets.fragments;

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

public class Campaign3in30 extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_3in30, container, false);

//
//        Glide.with(this).load(R.drawable.center3in30)
//                .apply(bitmapTransform(new CircleCrop())).into((ImageView) view.findViewById(R.id.img3in30));

        return view;
    }


}

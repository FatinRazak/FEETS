package com.example.feets.feets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.feets.feets.R;
import com.example.feets.feets.models.Challenge;

import java.util.ArrayList;

public class ChallengeAdapter extends ArrayAdapter {
    private ArrayList<Challenge> items;
    private ChallengeViewHolder challengeViewHolder;

    private class ChallengeViewHolder {
        TextView item;
        TextView subitem;
    }

    public ChallengeAdapter(Context context, int tvResId, ArrayList<Challenge> items) {
        super(context, tvResId, items);
        this.items = items;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            v = inflater.inflate(R.layout.listview_challenge, null);
            challengeViewHolder = new ChallengeViewHolder();
            challengeViewHolder.item = (TextView)v.findViewById(R.id.item);
            challengeViewHolder.subitem = (TextView)v.findViewById(R.id.subitem);
            v.setTag(challengeViewHolder);
        }
        else challengeViewHolder = (ChallengeViewHolder) v.getTag();

        Challenge challenge = items.get(pos);

        if (challenge != null) {
            challengeViewHolder.item.setText(challenge.getItem());
            challengeViewHolder.subitem.setText(challenge.getSubitem());
        }

        return v;
    }

}

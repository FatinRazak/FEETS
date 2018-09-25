package com.example.feets.feets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.feets.feets.R;
import com.example.feets.feets.models.Feed;

import java.util.ArrayList;

public class FeedAdapter extends ArrayAdapter {
    private ArrayList<Feed> items;
    private FeedViewHolder feedViewHolder;

    private class FeedViewHolder {
        TextView item;
        TextView subitem;
    }

    public FeedAdapter(Context context, int tvResId, ArrayList<Feed> items) {
        super(context, tvResId, items);
        this.items = items;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            v = inflater.inflate(R.layout.listview_feed, null);
            feedViewHolder = new FeedViewHolder();
            feedViewHolder.item = (TextView)v.findViewById(R.id.item);
            feedViewHolder.subitem = (TextView)v.findViewById(R.id.subitem);
            v.setTag(feedViewHolder);
        }
        else feedViewHolder = (FeedViewHolder) v.getTag();

        Feed feed = items.get(pos);

        if (feed != null) {
            feedViewHolder.item.setText(feed.getItem());
            feedViewHolder.subitem.setText(feed.getSubitem());
        }

        return v;

    }
}

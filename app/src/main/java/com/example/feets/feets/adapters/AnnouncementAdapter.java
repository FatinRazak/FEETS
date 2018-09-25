package com.example.feets.feets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.feets.feets.R;
import com.example.feets.feets.models.Announcement;
import java.util.ArrayList;

public class AnnouncementAdapter extends ArrayAdapter {

    private ArrayList<Announcement> items;
    private AnnouncementViewHolder announcementViewHolder;

    private class AnnouncementViewHolder {
        TextView item;
        TextView subitem;
    }

    public AnnouncementAdapter(Context context, int tvResId, ArrayList<Announcement> items) {
        super(context, tvResId, items);
        this.items = items;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            v = inflater.inflate(R.layout.listview_feed, null);
            announcementViewHolder = new AnnouncementViewHolder();
            announcementViewHolder.item = (TextView)v.findViewById(R.id.item);
            announcementViewHolder.subitem = (TextView)v.findViewById(R.id.subitem);
            v.setTag(announcementViewHolder);
        }
        else announcementViewHolder = (AnnouncementViewHolder) v.getTag();

        Announcement announcement = items.get(pos);

        if (announcement != null) {
            announcementViewHolder.item.setText(announcement.getItem());
            announcementViewHolder.subitem.setText(announcement.getSubitem());
        }

        return v;

    }
}

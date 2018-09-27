package com.example.feets.feets.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.feets.feets.R;
import com.example.feets.feets.models.Announcement;
import java.util.ArrayList;

public class AnnouncementAdapter extends ArrayAdapter {

    private ArrayList<Announcement> items;
    private AnnouncementViewHolder announcementViewHolder;

    private class AnnouncementViewHolder {
        //place to tell how many items to the adapter
        TextView item;
        TextView subitem;
        ImageView imageView;
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
            v = inflater.inflate(R.layout.listview_announcement, null);
            announcementViewHolder = new AnnouncementViewHolder();
            //Binding to ui container
            announcementViewHolder.item = (TextView)v.findViewById(R.id.item);
            announcementViewHolder.subitem = (TextView)v.findViewById(R.id.subitem);
            announcementViewHolder.imageView = (ImageView)v.findViewById(R.id.img);

            v.setTag(announcementViewHolder);
        }
        else announcementViewHolder = (AnnouncementViewHolder) v.getTag();

        Announcement announcement = items.get(pos);

        if (announcement != null) {
            //Set the insides to container.
            announcementViewHolder.item.setText(announcement.getItem());
            announcementViewHolder.subitem.setText(announcement.getSubitem());
            announcementViewHolder.imageView.setImageResource(announcement.getImgid());
        }

        return v;

    }
}
